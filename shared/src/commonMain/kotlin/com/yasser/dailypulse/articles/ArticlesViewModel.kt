package com.yasser.dailypulse.articles

import com.yasser.dailypulse.BaseViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ArticlesViewModel : BaseViewModel() {
    private val _articlesState: MutableStateFlow<ArticlesState> = MutableStateFlow(ArticlesState())
    val articlesState: StateFlow<ArticlesState> get() = _articlesState

    init {
        getArticles()
    }

    private fun getArticles() {
        scope.launch {
            _articlesState.update { it.copy(isLoading = true) }
            delay(1000)
           _articlesState.update { it.copy(articles = mockArticles, isLoading = false) }
        }
    }

    private val mockArticles = listOf(
        Article(
            title = "Stock market today: Live updates - CNBC",
            description = "Futures were higher in premarket trading as Wall Street tried to regain its footing.",
            publishedAt = "2023-11-09",
            urlToImage = "https://image.cnbcfm.com/api/v1/image/107326078-1698758530118-gettyimages-1765623456-wall26362_igj6ehhp.jpeg?v=1698758587&w=1920&h=1080",
            urlToArticle = "",
            content = ""

        ),
        Article(
            title = "Best iPhone Deals (2023): Carrier Deals, Unlocked iPhones",
            description = "Apple's smartphones rarely go on sale, but if you’re looking to upgrade (or you're gift shopping), here are a few cost-saving options.",
            publishedAt = "2023-11-09",
            urlToImage = "https://media.wired.com/photos/622aa5c8cca6acf55fb70b57/191:100/w_1280,c_limit/iPhone-13-Pro-Colors-SOURCE-Apple-Gear.jpg",
            urlToArticle = "",
            content = ""
        ),
        Article(
            title = "Samsung details ‘Galaxy AI’ and a feature that can translate phone calls in real time",
            description = "In a new blog post, Samsung previewed what it calls “a new era of Galaxy AI” coming to its smartphones and detailed a feature that will use artificial intelligence to translate phone calls in real time.",
            publishedAt = "2023-11-09",
            urlToImage = "https://cdn.vox-cdn.com/thumbor/Ocz_QcxUdtaexp1pPTMygaqzbR8=/0x0:2000x1333/1200x628/filters:focal(1000x667:1001x668)/cdn.vox-cdn.com/uploads/chorus_asset/file/24396795/DSC04128_processed.jpg",
            urlToArticle = "",
            content = ""
        ),
    )
}