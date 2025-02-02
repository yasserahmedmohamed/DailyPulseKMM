package com.yasser.dailypulse

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import yasser.dailypulse.db.DailyPulseDatabase

actual class DBDriverFactory {
    actual fun createDriver(): SqlDriver {
        return NativeSqliteDriver(DailyPulseDatabase.Schema, "daily_pulse.db")
    }
}