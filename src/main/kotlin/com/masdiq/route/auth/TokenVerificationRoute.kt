package com.masdiq.route.auth

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier
import com.google.api.client.http.javanet.NetHttpTransport
import com.google.api.client.json.gson.GsonFactory
import com.masdiq.model.EndPoint
import com.masdiq.model.auth.TokenReq
import com.masdiq.model.auth.User
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
    post(EndPoint.TokenVerification.path) {
        val req = call.receive<TokenReq>()

        if (req.tokenId.isNotEmpty()) {
            val thisResult = verifyGoogleTokenId(tokenId = req.tokenId)

            if (thisResult != null) {
                saveUserToDatabase(
                    app = thisApp,
                    result = thisResult,
                    userDataInterface = thisUserDataInterface
                )
            } else {
                thisApp.log.info(tokenFailed)
                call.respondRedirect(EndPoint.Unauthorized.path)
            }
        } else {
            thisApp.log.info(tokenEmpty)
            call.respondRedirect(EndPoint.Unauthorized.path)
        }
    }
}

private suspend fun PipelineContext<Unit, ApplicationCall>.saveUserToDatabase(
    app: Application, result: GoogleIdToken, userDataInterface: UserDataInterface
) {
    val sub = result.payload["sub"].toString()
    val name = result.payload["name"].toString()
    val emailAddress = result.payload["email"].toString()
    val profilePhoto = result.payload["picture"].toString()
    val user = User(
        id = sub, name = name, emailAddress = emailAddress, profilePhoto = profilePhoto
    )
    val response = userDataInterface.saveUserInfo(user = user)

    if (response) {
        app.log.info(dataSuccessCreated)
        call.sessions.set(UserSession(id = sub, name = name))
        call.respondRedirect(EndPoint.Authorized.path)

    } else {
        app.log.info(dataConflict)
        call.respondRedirect(EndPoint.Unauthorized.path)
    }
}

private fun verifyGoogleTokenId(tokenId: String): GoogleIdToken? {
    return try {
        val verifier = GoogleIdTokenVerifier.Builder(NetHttpTransport(), GsonFactory())
            .setAudience(listOf(AUDIENCE))
            .setIssuer(ISSUER)
            .build()
        return verifier.verify(tokenId)
    } catch (e: Exception) {
        null
    }
}