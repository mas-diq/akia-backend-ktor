package com.masdiq.repository.tabletTambahDarah

import com.masdiq.model.tabletTambahDarah.TabletTambahDarah
import com.masdiq.repository.DATABASE
import org.bson.types.ObjectId
import org.litote.kmongo.eq

private val colTabletTambahDarah = DATABASE.getCollection<TabletTambahDarah>()

class TabletTambahDarahImplement : TabletTambahDarahRepository {
    override suspend fun getAllTabletTambahDarah(): List<TabletTambahDarah> {
        return colTabletTambahDarah.find().toList()
    }

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
        dataDelete?.let { data ->
            return colTabletTambahDarah.deleteOneById(data.id).wasAcknowledged()
        } ?: return false
    }

    override suspend fun searchTabletTambahDarah(reqId: String): List<TabletTambahDarah> {
        return if (reqId.isEmpty()) {
            emptyList()
        } else {
            return colTabletTambahDarah.find(TabletTambahDarah::userId eq reqId).toList()
        }
    }
}