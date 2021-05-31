package tj.livo.newsapp.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import tj.livo.newsapp.models.Articles

@Dao
interface NewsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addNews(articles: Articles)

    @Query("SELECT * FROM news")
    fun getAllNews() : LiveData<List<Articles>>
}
