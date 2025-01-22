package com.yasser.dailypulse.android

import com.yasser.dailypulse.articles.presentation.ArticlesViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val viewModelsModule = module {
    viewModel { ArticlesViewModel(get()) }
}