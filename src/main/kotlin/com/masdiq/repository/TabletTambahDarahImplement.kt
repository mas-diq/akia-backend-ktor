package com.masdiq.repository

import com.masdiq.model.tabletTambahDarah.TabletTambahDarah
import org.bson.types.ObjectId
import org.litote.kmongo.eq

val tabletTD = DATABASE.getCollection<TabletTambahDarah>()

class TabletTambahDarahImplement : TabletTambahDarahRepository {

    override suspend fun getTablet(id: String): TabletTambahDarah? {
        return tabletTD.findOneById(id)
    }

    override suspend fun createOrUpdateTablet(t: TabletTambahDarah): Boolean {
        val tabletExists = tabletTD.findOneById(t.id) != null

        return if (tabletExists) {
            tabletTD.updateOneById(t.id, t).wasAcknowledged()
        } else {
            t.id = ObjectId().toString()
            tabletTD.insertOne(t).wasAcknowledged()
        }
    }

    override suspend fun deleteTablet(tId: String): Boolean {
        val tabletDelete = tabletTD.findOne(TabletTambahDarah::id eq tId)
        tabletDelete?.let { tablet ->
            return tabletTD.deleteOneById(tablet.id).wasAcknowledged()
        } ?: return false
    }
}