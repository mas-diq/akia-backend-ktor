package com.masdiq.repository.tabletTambahDarah

import com.masdiq.model.tabletTambahDarah.TabletTambahDarah
import com.masdiq.repository.DATABASE
import org.bson.types.ObjectId
import org.litote.kmongo.eq

val colTabletTambahDarah = DATABASE.getCollection<TabletTambahDarah>()

class TabletTambahDarahImplement : TabletTambahDarahRepository {

    override suspend fun getTabletTambahDarah(reqId: String): TabletTambahDarah? {
        return colTabletTambahDarah.findOneById(reqId)
    }

    override suspend fun createOrUpdateTabletTambahDarah(tabletTambahDarah: TabletTambahDarah): Boolean {
        val dataFound = colTabletTambahDarah.findOneById(tabletTambahDarah.id) != null

        return if (dataFound) {
            colTabletTambahDarah.updateOneById(tabletTambahDarah.id, tabletTambahDarah).wasAcknowledged()
        } else {
            tabletTambahDarah.id = ObjectId().toString()
            colTabletTambahDarah.insertOne(tabletTambahDarah).wasAcknowledged()
        }
    }

    override suspend fun deleteTabletTambahDarah(reqId: String): Boolean {
        val dataDelete = colTabletTambahDarah.findOne(TabletTambahDarah::id eq reqId)
        dataDelete?.let { tablet ->
            return colTabletTambahDarah.deleteOneById(tablet.id).wasAcknowledged()
        } ?: return false
    }
}