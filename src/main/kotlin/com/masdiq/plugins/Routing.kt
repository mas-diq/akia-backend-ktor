package com.masdiq.plugins

import com.masdiq.repository.auth.UserDataInterface
import com.masdiq.route.auth.authorizedRoute
import com.masdiq.route.auth.tokenVerificationRoute
import com.masdiq.route.auth.unauthorizedRoute
import com.masdiq.route.auth.userRoute
import com.masdiq.route.pelayananDokter.evaluasi.*
import com.masdiq.route.pelayananDokter.pemeriksaanFisikRoute
import com.masdiq.route.pelayananDokter.trimester1.pemeriksaanLaboratorium1Route
import com.masdiq.route.pelayananDokter.trimester1.usgTrimester1Route
import com.masdiq.route.pelayananDokter.trimester2.skriningDiabetesRoute
import com.masdiq.route.pelayananDokter.trimester2.skriningPreeklampsiaRoute
import com.masdiq.route.pelayananDokter.trimester3.pemeriksaanLaboratorium2Route
import com.masdiq.route.pelayananDokter.trimester3.rencanaKonsultasiLanjutRoute
import com.masdiq.route.pelayananDokter.trimester3.rencanaPersalinanDanKbRoute
import com.masdiq.route.pelayananDokter.trimester3.usgTrimester3Route
import com.masdiq.route.pemantauanIbu.ibuHamil.pemantauanHarianIbuHamilRoute
import com.masdiq.route.pemantauanIbu.ibuHamil.pemantauanMingguanIbuHamilRoute
import com.masdiq.route.pemantauanIbu.ibuNifas.pemantauanHarianIbuNifasRoute
import com.masdiq.route.pemantauanIbu.ibuNifas.pemantauanMingguanIbuNifasRoute
import com.masdiq.route.persalinanIbu.pelayananNifas.kesimpulanAkhirNifasRoute
import com.masdiq.route.persalinanIbu.pelayananNifas.kunjunganNifasRoute
import com.masdiq.route.persalinanIbu.pelayananPersalinan.bayiSaatLahirRoute
import com.masdiq.route.persalinanIbu.pelayananPersalinan.ibuBersalinDanIbuNifasRoute
import com.masdiq.route.tabletTambahDarah.tambahDarahRoute
import io.ktor.server.application.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Application.configureRouting() {
    routing {
        val userDataInterface: UserDataInterface by inject()
        tokenVerificationRoute(application, userDataInterface)

        // Authentication
        authorizedRoute()
        unauthorizedRoute()
        userRoute(application, userDataInterface)

        // Pelayanan Dokter
        pemeriksaanFisikRoute(application)
        // Pelayanan Dokter / Evaluasi
        kondisiKesehatanRoute(application)
        pemeriksaanKhususRoute(application)
        penyakitKeluargaRoute(application)
        perilakuBeresikoRoute(application)
        riwayatKesehatanRoute(application)
        riwayatKehamilanRoute(application)
        statusImunisasiRoute(application)
        // Pelayanan Dokter / Trimester 1
        pemeriksaanLaboratorium1Route(application)
        usgTrimester1Route(application)
        // Pelayanan Dokter / Trimester 2
        skriningDiabetesRoute(application)
        skriningPreeklampsiaRoute(application)
        // Pelayanan Dokter / Trimester 3
        pemeriksaanLaboratorium2Route(application)
        rencanaKonsultasiLanjutRoute(application)
        rencanaPersalinanDanKbRoute(application)
        usgTrimester3Route(application)

        // Pemantauan Ibu
        // Pemantauan Ibu / Ibu Hamil
        pemantauanHarianIbuHamilRoute(application)
        pemantauanMingguanIbuHamilRoute(application)
        // Pemantauan Ibu / Ibu Nifas
        pemantauanHarianIbuNifasRoute(application)
        pemantauanMingguanIbuNifasRoute(application)

        // Persalinan Ibu
        // Persalinan Ibu / Pelayanan Nifas
        kesimpulanAkhirNifasRoute(application)
        kunjunganNifasRoute(application)
        // Persalinan Ibu / Pelayanan Persalinan
        bayiSaatLahirRoute(application)
        ibuBersalinDanIbuNifasRoute(application)
        // Tablet Tambah Darah
        tambahDarahRoute(application)
    }
}
