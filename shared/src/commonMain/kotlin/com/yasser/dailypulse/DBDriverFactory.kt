package com.yasser.dailypulse

import app.cash.sqldelight.db.SqlDriver

expect class DBDriverFactory {
    fun createDriver(): SqlDriver
}