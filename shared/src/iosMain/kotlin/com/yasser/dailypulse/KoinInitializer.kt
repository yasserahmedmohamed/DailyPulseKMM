package com.yasser.dailypulse

import com.yasser.dailypulse.articles.presentation.ArticlesViewModel
import com.yasser.sharedKoinModule
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.context.startKoin

fun initKoin() {
    val modules = sharedKoinModule+ DataBaseModule

    startKoin {
        modules(modules)
    }
}

class ArticleInjector : KoinComponent {
    val articlesViewModel: ArticlesViewModel by inject()
}