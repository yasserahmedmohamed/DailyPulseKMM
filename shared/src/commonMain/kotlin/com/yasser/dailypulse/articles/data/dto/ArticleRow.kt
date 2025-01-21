package com.yasser.dailypulse.articles.data.dto

import com.yasser.dailypulse.articles.domain.model.Article
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ArticleRow(
    @SerialName("content")
    val content: String?,
    @SerialName("description")
    val description: String?,
    @SerialName("publishedAt")
    val publishedAt: String?,
    @SerialName("title")
    val title: String?,
    @SerialName("url")
    val url: String?,
    @SerialName("urlToImage")
    val urlToImage: String?
){

    fun toDomain(): Article {
        return Article(
            content = content ?: "",
            description = description ?: "",
            publishedAt = publishedAt ?: "",
            title = title ?: "",
            urlToImage = urlToImage ?: "",
            urlToArticle = url ?: ""
        )
    }
}
