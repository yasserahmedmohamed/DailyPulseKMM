package com.yasser.dailypulse.articles.domain.model

data class Article(
    val title: String,
    val description: String,
    val urlToArticle: String,
    val urlToImage: String,
    val publishedAt: String,
    val content: String
)