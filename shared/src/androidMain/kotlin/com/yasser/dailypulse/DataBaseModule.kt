package com.yasser.dailypulse

import org.koin.dsl.module
import yasser.dailypulse.db.DailyPulseDatabase


val dataBaseModule = module {
    single {
        DBDriverFactory(get()).createDriver()
    }

    single { DailyPulseDatabase(get()) }
}