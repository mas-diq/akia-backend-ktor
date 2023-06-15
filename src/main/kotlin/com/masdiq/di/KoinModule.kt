package com.masdiq.di

import com.masdiq.repository.pelayananDokter.PemeriksaanFisikImplement
import com.masdiq.repository.pelayananDokter.PemeriksaanFisikRepository
import com.masdiq.repository.pelayananDokter.evaluasi.*
import com.masdiq.repository.pelayananDokter.trimester1.PemeriksaanLaboratorium1Implement
import com.masdiq.repository.pelayananDokter.trimester1.PemeriksaanLaboratorium1Repository
import com.masdiq.repository.pelayananDokter.trimester1.UsgTrimester1Implement
import com.masdiq.repository.pelayananDokter.trimester1.UsgTrimester1Repository
import com.masdiq.repository.pelayananDokter.trimester2.SkriningDiabetesImplement
import com.masdiq.repository.pelayananDokter.trimester2.SkriningDiabetesRepository
import com.masdiq.repository.pelayananDokter.trimester2.SkriningPreeklampsiaImplement
import com.masdiq.repository.pelayananDokter.trimester2.SkriningPreeklampsiaRepository
import com.masdiq.repository.pelayananDokter.trimester3.*
import com.masdiq.repository.pemantauanIbu.ibuHamil.PemantauanHarianIbuHamilImplement
import com.masdiq.repository.pemantauanIbu.ibuHamil.PemantauanHarianIbuHamilRepository
import com.masdiq.repository.pemantauanIbu.ibuHamil.PemantauanMingguanIbuHamilImplement
import com.masdiq.repository.pemantauanIbu.ibuHamil.PemantauanMingguanIbuHamilRepository
import com.masdiq.repository.pemantauanIbu.ibuNifas.PemantauanHarianIbuNifasImplement
import com.masdiq.repository.pemantauanIbu.ibuNifas.PemantauanHarianIbuNifasRepository
import com.masdiq.repository.pemantauanIbu.ibuNifas.PemantauanMingguanIbuNifasImplement
import com.masdiq.repository.pemantauanIbu.ibuNifas.PemantauanMingguanIbuNifasRepository
import com.masdiq.repository.persalinanIbu.pelayananNifas.KesimpulanAkhirNifasImplement
import com.masdiq.repository.persalinanIbu.pelayananNifas.KesimpulanAkhirNifasRepository
import com.masdiq.repository.persalinanIbu.pelayananNifas.KunjunganNifasImplement
import com.masdiq.repository.persalinanIbu.pelayananNifas.KunjunganNifasRepository
import com.masdiq.repository.persalinanIbu.pelayananPersalinan.BayiSaatLahirImplement
import com.masdiq.repository.persalinanIbu.pelayananPersalinan.BayiSaatLahirRepository
import com.masdiq.repository.persalinanIbu.pelayananPersalinan.IbuBersalinDanIbuNifasImplement
import com.masdiq.repository.persalinanIbu.pelayananPersalinan.IbuBersalinDanIbuNifasRepository
import com.masdiq.repository.tabletTambahDarah.TabletTambahDarahImplement
import com.masdiq.repository.tabletTambahDarah.TabletTambahDarahRepository
import org.koin.dsl.module

val koinModule = module {

    // Pelayanan Dokter
    single<PemeriksaanFisikRepository> { PemeriksaanFisikImplement() }
    // Pelayanan Dokter / Evaluasi
    single<KondisiKesehatanRepository> { KondisiKesehatanImplement() }
    single<PemeriksaanKhususRepository> { PemeriksaanKhususImplement() }
    single<PenyakitKeluargaRepository> { PenyakitKeluargaImplement() }
    single<PerilakuBeresikoRepository> { PerilakuBeresikoImplement() }
    single<RiwayatKesehatanRepository> { RiwayatKesehatanImplement() }
    single<RiwayatKehamilanRepository> { RiwayatKehamilanImplement() }
    single<StatusImunisasiRepository> { StatusImunisasiImplement() }
    // Pelayanan Dokter / Trimester 1
    single<PemeriksaanLaboratorium1Repository> { PemeriksaanLaboratorium1Implement() }
    single<UsgTrimester1Repository> { UsgTrimester1Implement() }
    // Pelayanan Dokter / Trimester 2
    single<SkriningDiabetesRepository> { SkriningDiabetesImplement() }
    single<SkriningPreeklampsiaRepository> { SkriningPreeklampsiaImplement() }
    // Pelayanan Dokter / Trimester 3
    single<PemeriksaanLaboratorium2Repository> { PemeriksaanLaboratorium2Implement() }
    single<RencanaKonsultasiLanjutRepository> { RencanaKonsultasiLanjutImplement() }
    single<RencanaPersalinanDanKbRepository> { RencanaPersalinanDanKbImplement() }
    single<UsgTrimester3Repository> { UsgTrimester3Implement() }

    // Pemantauan Ibu
    // Pemantauan Ibu / Ibu Hamil
    single<PemantauanHarianIbuHamilRepository> { PemantauanHarianIbuHamilImplement() }
    single<PemantauanMingguanIbuHamilRepository> { PemantauanMingguanIbuHamilImplement() }
    // Pemantauan Ibu / Ibu Nifas
    single<PemantauanHarianIbuNifasRepository> { PemantauanHarianIbuNifasImplement() }
    single<PemantauanMingguanIbuNifasRepository> { PemantauanMingguanIbuNifasImplement() }

    // Persalinan Ibu
    // Persalinan Ibu / Pelayanan Nifas
    single<KesimpulanAkhirNifasRepository> { KesimpulanAkhirNifasImplement() }
    single<KunjunganNifasRepository> { KunjunganNifasImplement() }
    // Persalinan Ibu / Pelayanan Persalinan
    single<BayiSaatLahirRepository> { BayiSaatLahirImplement() }
    single<IbuBersalinDanIbuNifasRepository> { IbuBersalinDanIbuNifasImplement() }

    // Tablet Tambah Darah
    single<TabletTambahDarahRepository> { TabletTambahDarahImplement() }
}
