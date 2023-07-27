package com.masdiq.route.auth

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier
import com.google.api.client.http.javanet.NetHttpTransport
import com.google.api.client.json.gson.GsonFactory
import com.masdiq.model.EndPoint
import com.masdiq.model.auth.TokenReq
import com.masdiq.model.userPasien.UserPasien
import com.masdiq.model.auth.UserSession
import com.masdiq.repository.auth.UserDataInterface
import com.masdiq.util.ConstantAuth.AUDIENCE
import com.masdiq.util.ConstantAuth.ISSUER
import com.masdiq.util.dataConflict
import com.masdiq.util.dataSuccessCreated
import com.masdiq.util.tokenEmpty
import com.masdiq.util.tokenFailed
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.sessions.*
import io.ktor.util.pipeline.*

fun Route.tokenVerificationRoute(thisApp: Application, thisUserDataInterface: UserDataInterface) {
    post(EndPoint.URL_TOKEN_VERIFICATION.path) {
        val req = call.receive<TokenReq>()

        if (req.tokenId.isNotEmpty()) {
            val thisResult = verifyGoogleTokenId(tokenId = req.tokenId)

            if (thisResult != null) {
                saveUserToDatabase(
                    reqUserType = req.userType,
                    app = thisApp,
                    result = thisResult,
                    userDataInterface = thisUserDataInterface
                )
            } else {
                thisApp.log.info(tokenFailed)
                call.respondRedirect(EndPoint.URL_UNAUTHORIZED.path)
            }
        } else {
            thisApp.log.info(tokenEmpty)
            call.respondRedirect(EndPoint.URL_UNAUTHORIZED.path)
        }
    }
}

private suspend fun PipelineContext<Unit, ApplicationCall>.saveUserToDatabase(
    app: Application, result: GoogleIdToken, userDataInterface: UserDataInterface, reqUserType: String
) {
    val accountSub = result.payload["sub"].toString()
    val accountName = result.payload["name"].toString()
    val accountEmail = result.payload["email"].toString()
    val accountPhoto = result.payload["picture"].toString()
    val userPasien = UserPasien(
        userId = accountSub,
        name = accountName,
        emailAddress = accountEmail,
        profilePhoto = accountPhoto,
        userType = reqUserType
    )
    val response = userDataInterface.saveUserInfo(userPasien = userPasien)

    if (response) {
        app.log.info(dataSuccessCreated)
        call.sessions.set(UserSession(id = accountSub, name = accountName))
        call.respondRedirect(EndPoint.URL_AUTHORIZED.path)


    } else {
        app.log.info(dataConflict)
        call.respondRedirect(EndPoint.URL_UNAUTHORIZED.path)
    }
}

private fun verifyGoogleTokenId(tokenId: String): GoogleIdToken? {
    return try {
        val verifier = GoogleIdTokenVerifier.Builder(NetHttpTransport(), GsonFactory()).setAudience(listOf(AUDIENCE))
            .setIssuer(ISSUER).build()
        return verifier.verify(tokenId)
    } catch (e: Exception) {
        null
    }
}