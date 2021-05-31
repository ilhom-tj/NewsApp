package tj.livo.newsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import tj.livo.newsapp.adapters.NewsRecycler
import tj.livo.newsapp.models.NewsResponse
import tj.livo.newsapp.network.RetrofitInstance

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: NewsRecycler
    private lateinit var viewModel : MainActViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.news)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = NewsRecycler(this)
        recyclerView.adapter = adapter

        viewModel = ViewModelProvider(
            this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(this.application)
        )
            .get(MainActViewModel::class.java)
        viewModel.listOfNews.observe(this){
            adapter.setData(it)

        }
        var category : String = "politics"
        RetrofitInstance().api().getListOfHeadLine(category).enqueue(object : Callback<NewsResponse>{
            override fun onResponse(call: Call<NewsResponse>, response: Response<NewsResponse>) {
                if (response.isSuccessful){
                    Log.e("ART", response.body()!!.articles.size.toString())
                    response.body()?.articles?.forEach {
                        var art  = it
                        art.type = category
                        viewModel.addArticle(art)
                    }
                }
            }

            override fun onFailure(call: Call<NewsResponse>, t: Throwable) {

            }

        })
    }
}