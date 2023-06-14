package com.masdiq.di

import com.masdiq.repository.TabletTambahDarahImplement
import com.masdiq.repository.TabletTambahDarahRepository
import org.koin.dsl.module

val koinModule = module {
    single<TabletTambahDarahRepository> {
        TabletTambahDarahImplement()
    }
}