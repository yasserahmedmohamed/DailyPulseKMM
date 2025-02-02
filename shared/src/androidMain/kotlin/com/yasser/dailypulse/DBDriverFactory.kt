package com.yasser.dailypulse

import android.content.Context
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import yasser.dailypulse.db.DailyPulseDatabase

actual class DBDriverFactory(private val context: Context) {

    actual fun createDriver(): SqlDriver {
        return AndroidSqliteDriver(DailyPulseDatabase.Schema, context, "daily_pulse.db")
    }
}