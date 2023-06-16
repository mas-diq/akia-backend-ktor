package com.masdiq.template

const val BASE_URL = "/akia"

// --------------
// Pelayanan Dokter
const val BASE_PELAYANAN_DOKTER = "$BASE_URL/pelayanan-dokter"
const val URL_PEMERIKSAAN_FISIK = "$BASE_PELAYANAN_DOKTER/pemeriksaan-fisik"

// Pelayanan Dokter / Evaluasi
const val BASE_EVALUASI = "$BASE_PELAYANAN_DOKTER/evaluasi"
const val URL_KONDISI_KESEHATAN = "$BASE_EVALUASI/kondisi-kesehatan"
const val URL_PEMERIKSAAN_KHUSUS = "$BASE_EVALUASI/pemeriksaan-khusus"
const val URL_PENYAKIT_KELUARGA = "$BASE_EVALUASI/penyakit-keluarga"
const val URL_PERILAKU_BERESIKO = "$BASE_EVALUASI/perilaku-beresiko"
const val URL_RIWAYAT_KEHAMILAN = "$BASE_EVALUASI/riwayat-kehamilan"
const val URL_RIWAYAT_KESEHATAN = "$BASE_EVALUASI/riwayat-kesehatan"
const val URL_STATUS_IMUNISASI = "$BASE_EVALUASI/status-imunisasi"

// Pelayanan Dokter / Trimester 1
const val BASE_TRIMESTER_1 = "$BASE_PELAYANAN_DOKTER/trimester-1"
const val URL_PEMERIKSAAN_LABORATORIUM_1 = "$BASE_TRIMESTER_1/pemeriksaan-laboratorium-1"
const val URL_USG_TRIMESTER_1 = "$BASE_TRIMESTER_1/usg-trimester-1"

// Pelayanan Dokter / Trimester 2
const val BASE_TRIMESTER_2 = "$BASE_PELAYANAN_DOKTER/trimester-2"
const val URL_SKRINING_DIABETES = "$BASE_TRIMESTER_2/skiring-diabetes"
const val URL_SKRINING_PREEKLAMPSIA = "$BASE_TRIMESTER_2/skiring-preeklampsia"

// Pelayanan Dokter / Trimester 3
const val BASE_TRIMESTER_3 = "$BASE_PELAYANAN_DOKTER/trimester-3"
const val URL_PEMERIKSAAN_LABORATORIUM_2 = "$BASE_TRIMESTER_3/pemeriksaan-laboraatorium-2"
const val URL_RENCANA_KONSULTASI_LANJUT = "$BASE_TRIMESTER_3/rencana-konsultasi-lanjut"
const val URL_RENCANA_PERSALINAN_DAN_KB = "$BASE_TRIMESTER_3/rencana-persailnan-dan-kb"
const val URL_USG_TRIMESTER_3 = "$BASE_TRIMESTER_3/usg-trimester-3"

// --------------
// Pemantauan Ibu
const val BASE_PEMANTAUAN_IBU = "$BASE_URL/pemantauan-ibu"

// Pemantauan Ibu / Ibu Hamil
const val BASE_IBU_HAMIL = "$BASE_PEMANTAUAN_IBU/ibu-hamil"
const val URL_PEMANTAUAN_HARIAN_IBU_HAMIL = "$BASE_IBU_HAMIL/pemantauan-harian-ibu-hamil"
const val URL_PEMANTAUAN_MINGGUAN_IBU_HAMIL = "$BASE_IBU_HAMIL/pemantauan-mingguan-ibu-hamil"

// Pemantauan Ibu / Ibu Nifas
const val BASE_IBU_NIFAS = "$BASE_PEMANTAUAN_IBU/ibu-nifas"
const val URL_PEMANTAUAN_HARIAN_IBU_NIFAS = "$BASE_IBU_NIFAS/pemantauan-harian-ibu-nifas"
const val URL_PEMANTAUAN_MINGGUAN_IBU_NIFAS = "$BASE_IBU_NIFAS/pemantauan-mingguan-ibu-nifas"

// --------------
// Persalinan Ibu
const val BASE_PERSALINAN_IBU = "$BASE_URL/persalinan-ibu"

// Persalinan Ibu / Pelayanan Nifas
const val BASE_PELAYANAN_NIFAS = "$BASE_PERSALINAN_IBU/pelayanan-nifas"
const val URL_KUNJUNGAN_NIFAS = "$BASE_PELAYANAN_NIFAS/kunjungan-nifas"
const val URL_KESIMPULAN_AKHIR_NIFAS = "$BASE_PELAYANAN_NIFAS/kesimpulan-akhir-nifas"

// Persalinan Ibu / Pelayanan Persalinan
const val BASE_PELAYANAN_PERSALINAN = "$BASE_PERSALINAN_IBU/pelayanan-persalinan"
const val URL_BAYI_SAAT_LAHIR = "$BASE_PELAYANAN_PERSALINAN/bayi-saat-lahir"
const val URL_IBU_BERSALIN_DAN_IBU_NIFAS = "$BASE_PELAYANAN_PERSALINAN/ibu-bersalin-dan-ibu-nifas"

// --------------
// Tablet Tambah Darah
const val URL_TABLET_TAMBAH_DARAH = "$BASE_URL/tablet-tambah-darah"
