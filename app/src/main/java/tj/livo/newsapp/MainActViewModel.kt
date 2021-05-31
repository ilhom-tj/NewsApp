package tj.livo.newsapp

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import tj.livo.newsapp.db.NewsDataBase
import tj.livo.newsapp.models.Articles

class MainActViewModel(application: Application) : AndroidViewModel(application) {
    private val newsDataBase = NewsDataBase.getInstance(application)
    private val newsDao = newsDataBase.daoNewsApp()

    fun addArticle(articles: Articles) = GlobalScope.launch {
        newsDao.addNews(articles)
    }
    val listOfNews = newsDao.getAllNews()
}