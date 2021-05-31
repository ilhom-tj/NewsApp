package tj.livo.newsapp.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import tj.livo.newsapp.models.Articles

@Database(entities = (arrayOf(Articles::class)), version = 1)
abstract class NewsDataBase : RoomDatabase() {


    abstract fun daoNewsApp() : NewsDao
    companion object {
        @Volatile
        private var INSTANCE: NewsDataBase? = null
        fun getInstance(context: Context): NewsDataBase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        NewsDataBase::class.java,
                        "note_data_database"
                    ).build()
                }
                return instance
            }
        }
    }
}

