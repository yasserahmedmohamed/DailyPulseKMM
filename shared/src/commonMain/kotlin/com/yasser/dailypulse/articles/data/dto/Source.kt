package com.yasser.dailypulse.articles.data.dto

import kotlinx.serialization.Serializable


@Serializable
data class Source(
    val id: String,
    val name: String
)