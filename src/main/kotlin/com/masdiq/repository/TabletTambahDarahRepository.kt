package com.masdiq.repository

import com.masdiq.model.tabletTambahDarah.TabletTambahDarah

interface TabletTambahDarahRepository {
    suspend fun getTablet(id: String): TabletTambahDarah?

    suspend fun createOrUpdateTablet(t: TabletTambahDarah): Boolean

    suspend fun deleteTablet(tId: String): Boolean
}