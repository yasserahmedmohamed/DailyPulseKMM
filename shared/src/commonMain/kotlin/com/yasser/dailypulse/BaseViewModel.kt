package com.yasser.dailypulse

import kotlinx.coroutines.CoroutineScope

expect open class BaseViewModel {
    val scope:CoroutineScope
}