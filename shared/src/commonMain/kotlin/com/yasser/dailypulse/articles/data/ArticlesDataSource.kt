package com.yasser.dailypulse.articles.data

import com.yasser.dailypulse.articles.domain.model.Article
import yasser.dailypulse.db.DailyPulseDatabase


class ArticlesDataSource(private val database: DailyPulseDatabase) {
    fun getArticles():List<Article> {
        return database.dailyPulseDataBaseQueries.selectAllArticles().executeAsList().map {
            Article(
                title = it.title,
                description = it.description ?: "",
                urlToArticle = it.urlToArticle ?: "",
                urlToImage = it.urlToImage ?: "",
                publishedAt = it.publishedAt    ?: "",
                content = it.content ?: ""
            )
        }
    }

    fun insertArticles(articles:List<Article>){
        database.dailyPulseDataBaseQueries.transaction {
            articles.forEach {
                database.dailyPulseDataBaseQueries.insertArticle(
                    title = it.title,
                    description = it.description,
                    urlToArticle = it.urlToArticle,
                    urlToImage = it.urlToImage,
                    publishedAt = it.publishedAt,
                    content = it.content
                )
            }
        }
    }


    fun deleteAllArticles(){
        database.dailyPulseDataBaseQueries.removeAllArticles()
    }
}