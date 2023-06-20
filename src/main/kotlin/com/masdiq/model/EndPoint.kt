package com.masdiq.model

sealed class EndPoint(val path: String) {
    object BASE_URL : EndPoint(path = "/akia")

    // --------------
    // Pelayanan Dokter
    object BASE_PELAYANAN_DOKTER : EndPoint(path = "${BASE_URL}/pelayanan-dokter")
    object URL_PEMERIKSAAN_FISIK : EndPoint(path = "$BASE_PELAYANAN_DOKTER/pemeriksaan-fisik")

    // Pelayanan Dokter / Evaluasi
    object BASE_EVALUASI : EndPoint(path = "$BASE_PELAYANAN_DOKTER/evaluasi")
    object URL_KONDISI_KESEHATAN : EndPoint(path = "$BASE_EVALUASI/kondisi-kesehatan")
    object URL_PEMERIKSAAN_KHUSUS : EndPoint(path = "$BASE_EVALUASI/pemeriksaan-khusus")
    object URL_PENYAKIT_KELUARGA : EndPoint(path = "$BASE_EVALUASI/penyakit-keluarga")
    object URL_PERILAKU_BERESIKO : EndPoint(path = "$BASE_EVALUASI/perilaku-beresiko")
    object URL_RIWAYAT_KEHAMILAN : EndPoint(path = "$BASE_EVALUASI/riwayat-kehamilan")
    object URL_RIWAYAT_KESEHATAN : EndPoint(path = "$BASE_EVALUASI/riwayat-kesehatan")
    object URL_STATUS_IMUNISASI : EndPoint(path = "$BASE_EVALUASI/status-imunisasi")

    // Pelayanan Dokter / Trimester 1
    object BASE_TRIMESTER_1 : EndPoint(path = "$BASE_PELAYANAN_DOKTER/trimester-1")
    object URL_PEMERIKSAAN_LABORATORIUM_1 : EndPoint(path = "$BASE_TRIMESTER_1/pemeriksaan-laboratorium-1")
    object URL_USG_TRIMESTER_1 : EndPoint(path = "$BASE_TRIMESTER_1/usg-trimester-1")

    // Pelayanan Dokter / Trimester 2
    object BASE_TRIMESTER_2 : EndPoint(path = "$BASE_PELAYANAN_DOKTER/trimester-2")
    object URL_SKRINING_DIABETES : EndPoint(path = "$BASE_TRIMESTER_2/skiring-diabetes")
    object URL_SKRINING_PREEKLAMPSIA : EndPoint(path = "$BASE_TRIMESTER_2/skiring-preeklampsia")

    // Pelayanan Dokter / Trimester 3
    object BASE_TRIMESTER_3 : EndPoint(path = "$BASE_PELAYANAN_DOKTER/trimester-3")
    object URL_PEMERIKSAAN_LABORATORIUM_2 : EndPoint(path = "$BASE_TRIMESTER_3/pemeriksaan-laboraatorium-2")
    object URL_RENCANA_KONSULTASI_LANJUT : EndPoint(path = "$BASE_TRIMESTER_3/rencana-konsultasi-lanjut")
    object URL_RENCANA_PERSALINAN_DAN_KB : EndPoint(path = "$BASE_TRIMESTER_3/rencana-persailnan-dan-kb")
    object URL_USG_TRIMESTER_3 : EndPoint(path = "$BASE_TRIMESTER_3/usg-trimester-3")

    // --------------
    // Pemantauan Ibu
    object BASE_PEMANTAUAN_IBU : EndPoint(path = "$BASE_URL/pemantauan-ibu")

    // Pemantauan Ibu / Ibu Hamil
    object BASE_IBU_HAMIL : EndPoint(path = "$BASE_PEMANTAUAN_IBU/ibu-hamil")
    object URL_PEMANTAUAN_HARIAN_IBU_HAMIL : EndPoint(path = "$BASE_IBU_HAMIL/pemantauan-harian-ibu-hamil")
    object URL_PEMANTAUAN_MINGGUAN_IBU_HAMIL : EndPoint(path = "$BASE_IBU_HAMIL/pemantauan-mingguan-ibu-hamil")

    // Pemantauan Ibu / Ibu Nifas
    object BASE_IBU_NIFAS : EndPoint(path = "$BASE_PEMANTAUAN_IBU/ibu-nifas")
    object URL_PEMANTAUAN_HARIAN_IBU_NIFAS : EndPoint(path = "$BASE_IBU_NIFAS/pemantauan-harian-ibu-nifas")
    object URL_PEMANTAUAN_MINGGUAN_IBU_NIFAS : EndPoint(path = "$BASE_IBU_NIFAS/pemantauan-mingguan-ibu-nifas")

    // --------------
    // Persalinan Ibu
    object BASE_PERSALINAN_IBU : EndPoint(path = "$BASE_URL/persalinan-ibu")

    // Persalinan Ibu / Pelayanan Nifas
    object BASE_PELAYANAN_NIFAS : EndPoint(path = "$BASE_PERSALINAN_IBU/pelayanan-nifas")
    object URL_KUNJUNGAN_NIFAS : EndPoint(path = "$BASE_PELAYANAN_NIFAS/kunjungan-nifas")
    object URL_KESIMPULAN_AKHIR_NIFAS : EndPoint(path = "$BASE_PELAYANAN_NIFAS/kesimpulan-akhir-nifas")

    // Persalinan Ibu / Pelayanan Persalinan
    object BASE_PELAYANAN_PERSALINAN : EndPoint(path = "$BASE_PERSALINAN_IBU/pelayanan-persalinan")
    object URL_BAYI_SAAT_LAHIR : EndPoint(path = "$BASE_PELAYANAN_PERSALINAN/bayi-saat-lahir")
    object URL_IBU_BERSALIN_DAN_IBU_NIFAS : EndPoint(path = "$BASE_PELAYANAN_PERSALINAN/ibu-bersalin-dan-ibu-nifas")

    // --------------
    // Tablet Tambah Darah
    object URL_TABLET_TAMBAH_DARAH : EndPoint(path = "$BASE_URL/tablet-tambah-darah")
}