package com.yasser.dailypulse.articles.presentation

import com.yasser.dailypulse.BaseViewModel
import com.yasser.dailypulse.articles.data.remote.ArticleService
import com.yasser.dailypulse.articles.domain.model.Article
import com.yasser.dailypulse.articles.domain.usecase.GetArticlesUseCase
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json

class ArticlesViewModel : BaseViewModel() {
    private val _articlesState: MutableStateFlow<ArticlesState> = MutableStateFlow(ArticlesState())
    val articlesState: StateFlow<ArticlesState> get() = _articlesState

    private val articlesUseCase:GetArticlesUseCase
    init {
        val httpClient = HttpClient{
            install(ContentNegotiation){
                json(Json {
                    prettyPrint = true
                    isLenient = true
                    ignoreUnknownKeys = true
                })
            }
        }
        val service = ArticleService(httpClient)
        articlesUseCase = GetArticlesUseCase(service)
        getArticles()
    }

    private fun getArticles() {
        scope.launch {
            _articlesState.update { it.copy(isLoading = true) }
            val articles = articlesUseCase.getArticles()
            _articlesState.update { it.copy(articles = articles, isLoading = false) }
        }
    }
}