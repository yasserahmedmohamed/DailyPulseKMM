package com.yasser.dailypulse.articles.presentation

import com.yasser.dailypulse.articles.domain.model.Article

data class ArticlesState(
    val articles: List<Article> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)
