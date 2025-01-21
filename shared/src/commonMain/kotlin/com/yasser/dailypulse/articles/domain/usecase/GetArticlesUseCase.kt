package com.yasser.dailypulse.articles.domain.usecase

import com.yasser.dailypulse.articles.data.remote.ArticleService
import com.yasser.dailypulse.articles.domain.model.Article
import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlinx.datetime.todayIn
import kotlinx.datetime.TimeZone
import kotlinx.datetime.daysUntil
import kotlinx.datetime.toLocalDateTime
import kotlin.math.abs

class GetArticlesUseCase(private val service: ArticleService) {
    suspend fun getArticles():List<Article>{
      return  service.fetchArticles().map {
            it.copy(publishedAt = getDaysAgo(it.publishedAt))
        }
    }

    private fun getDaysAgo(date:String):String{

        val today = Clock.System.todayIn(TimeZone.currentSystemDefault())
        val days = today.daysUntil(
            Instant.parse(date).toLocalDateTime(TimeZone.currentSystemDefault()).date
        )

        val result = when{
            abs(days) == 0 -> "Today"
            abs(days) == 1 -> "Yesterday"
            else -> "${abs(days)} days ago"
        }

        return result
    }
}