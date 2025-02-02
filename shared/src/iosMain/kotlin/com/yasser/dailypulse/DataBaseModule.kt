package com.yasser.dailypulse

import org.koin.dsl.module
import yasser.dailypulse.db.DailyPulseDatabase

val DataBaseModule = module {
    single {
        DBDriverFactory().createDriver()
    }

    single { DailyPulseDatabase(get()) }
}