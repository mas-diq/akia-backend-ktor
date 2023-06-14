package com.masdiq.repository.tabletTambahDarah

import com.masdiq.model.tabletTambahDarah.TabletTambahDarah
import com.masdiq.repository.DATABASE
import org.bson.types.ObjectId
import org.litote.kmongo.eq

val tabletTD = DATABASE.getCollection<TabletTambahDarah>()

class TabletTambahDarahImplement : TabletTambahDarahRepository {

    override suspend fun getTabletTambahDarah(reqId: String): TabletTambahDarah? {
        return tabletTD.findOneById(reqId)
    }

    override suspend fun createOrUpdateTabletTambahDarah(tabletTambahDarah: TabletTambahDarah): Boolean {
        val tabletExists = tabletTD.findOneById(tabletTambahDarah.id) != null

        return if (tabletExists) {
            tabletTD.updateOneById(tabletTambahDarah.id, tabletTambahDarah).wasAcknowledged()
        } else {
            tabletTambahDarah.id = ObjectId().toString()
            tabletTD.insertOne(tabletTambahDarah).wasAcknowledged()
        }
    }

    override suspend fun deleteTabletTambahDarah(reqId: String): Boolean {
        val tabletDelete = tabletTD.findOne(TabletTambahDarah::id eq reqId)
        tabletDelete?.let { tablet ->
            return tabletTD.deleteOneById(tablet.id).wasAcknowledged()
        } ?: return false
    }
}