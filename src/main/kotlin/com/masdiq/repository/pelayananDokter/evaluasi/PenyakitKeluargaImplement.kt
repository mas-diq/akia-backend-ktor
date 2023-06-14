package com.masdiq.repository.pelayananDokter.evaluasi

import com.masdiq.model.pelayananDokter.evaluasi.PenyakitKeluarga

class PenyakitKeluargaImplement : PenyakitKeluargaRepository{
    override suspend fun getPenyakitKeluarga(reqId: String): PenyakitKeluarga? {
        TODO("Not yet implemented")
    }

    override suspend fun createOrUpdatePenyakitKeluarga(penyakitKeluarga: PenyakitKeluarga): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun deleteTabletPenyakitKeluarga(reqId: String): Boolean {
        TODO("Not yet implemented")
    }

}
