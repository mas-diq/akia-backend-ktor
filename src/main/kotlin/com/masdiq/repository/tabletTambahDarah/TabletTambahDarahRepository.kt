package com.masdiq.repository.tabletTambahDarah

import com.masdiq.model.tabletTambahDarah.TabletTambahDarah

interface TabletTambahDarahRepository {
    suspend fun getAllTabletTambahDarah(): List<TabletTambahDarah>

    suspend fun getTabletTambahDarah(reqId: String): TabletTambahDarah?

    suspend fun createOrUpdateTabletTambahDarah(tabletTambahDarah: TabletTambahDarah): Boolean

    suspend fun deleteTabletTambahDarah(reqId: String): Boolean
}