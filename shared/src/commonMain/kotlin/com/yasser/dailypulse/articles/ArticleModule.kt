package com.yasser.dailypulse.articles

import com.yasser.dailypulse.articles.data.ArticlesDataSource
import com.yasser.dailypulse.articles.data.ArticlesRepository
import com.yasser.dailypulse.articles.data.remote.ArticleService
import com.yasser.dailypulse.articles.domain.usecase.GetArticlesUseCase
import com.yasser.dailypulse.articles.presentation.ArticlesViewModel
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.dsl.module

val articlesModule = module {
    single { ArticleService(get()) }
    single { GetArticlesUseCase(get()) }
    single { ArticlesViewModel(get()) }
    single { ArticlesDataSource(get()) }
    single { ArticlesRepository(get(),get()) }
    single<HttpClient> {
       HttpClient{
            install(ContentNegotiation){
                json(Json {
                    prettyPrint = true
                    isLenient = true
                    ignoreUnknownKeys = true
                })
            }
        }
    }
}