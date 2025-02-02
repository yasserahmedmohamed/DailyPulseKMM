package com.yasser.dailypulse.articles.data

import com.yasser.dailypulse.articles.data.remote.ArticleService
import com.yasser.dailypulse.articles.domain.model.Article

class ArticlesRepository(
    private val dataSource: ArticlesDataSource,
    private val service: ArticleService
) {

    suspend fun getArticles(isRefresh:Boolean):List<Article> {
        val articlesDB = dataSource.getArticles()
        println("Got ${articlesDB.size} articles from DB")

        if (articlesDB.isEmpty()||isRefresh) {
            dataSource.deleteAllArticles()
            val articles = service.fetchArticles()
            dataSource.insertArticles(articles)
            return articles
        }

        return articlesDB
    }

}