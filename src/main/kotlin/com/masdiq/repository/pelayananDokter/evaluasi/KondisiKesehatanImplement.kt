package com.masdiq.repository.pelayananDokter.evaluasi

import com.masdiq.model.pelayananDokter.evaluasi.KondisiKesehatan
import com.masdiq.repository.DATABASE

//val tabletTD = DATABASE.getCollection<KondisiKesehatanImplement>()

class KondisiKesehatanImplement : KondisiKesehatanRepository {
    override suspend fun getKondisiKesehatan(reqId: String): KondisiKesehatan? {
        TODO("Not yet implemented")
    }

    override suspend fun createOrUpdateKondisiKesehatan(kondisiKesehatan: KondisiKesehatan): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun deleteKondisiKesehatan(reqId: String): Boolean {
        TODO("Not yet implemented")
    }

}
