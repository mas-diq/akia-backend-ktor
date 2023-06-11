package com.masdiq.model

import com.masdiq.data.tabletTambahDarah.TabletTambahDarah
import org.bson.types.ObjectId
import org.litote.kmongo.eq

val tabletTD = DATABASE.getCollection<TabletTambahDarah>()

suspend fun getTablet(id: String): TabletTambahDarah? {
    return tabletTD.findOneById(id)
}

suspend fun createOrUpdateTablet(t: TabletTambahDarah): Boolean {
    val tabletExists = tabletTD.findOneById(t.id) != null

    return if (tabletExists) {
        tabletTD.updateOneById(t.id, t).wasAcknowledged()
    } else {
        t.id = ObjectId().toString()
        tabletTD.insertOne(t).wasAcknowledged()
    }
}

suspend fun deleteTablet(tId: String): Boolean {
    val tabletDelete = tabletTD.findOne(TabletTambahDarah::id eq tId)
    tabletDelete?.let { tablet ->
        return tabletTD.deleteOneById(tablet.id).wasAcknowledged()
    } ?: return false
}