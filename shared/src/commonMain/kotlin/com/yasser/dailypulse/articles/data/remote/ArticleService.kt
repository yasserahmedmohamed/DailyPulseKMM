package com.yasser.dailypulse.articles.data.remote

import com.yasser.dailypulse.articles.data.dto.ArticlesResponse
import com.yasser.dailypulse.articles.domain.model.Article
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class ArticleService(private val httpClient:HttpClient) {

    private val country = "us"
    private val category = "business"
    private val apiKey = "add you api key here"

    suspend fun fetchArticles():List<Article> {
       val response:ArticlesResponse = httpClient.get("https://newsapi.org/v2/top-headlines?country=$country&category=$category&apiKey=$apiKey").body()

        return response.articles?.map { it.toDomain() } ?: emptyList()
    }
}