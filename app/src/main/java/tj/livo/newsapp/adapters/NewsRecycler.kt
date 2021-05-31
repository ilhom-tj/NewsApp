package tj.livo.newsapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import tj.livo.newsapp.R
import tj.livo.newsapp.models.Articles

class NewsRecycler(val contextAllRecommended: Context) : RecyclerView.Adapter<NewsRecycler.LastNewsViewHolder>() {

    var sportApiNews : List<Articles> = emptyList()

    fun setData(list: List<Articles>){
        sportApiNews = list
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LastNewsViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.item_all_rapidapi,
            parent, false)
        return LastNewsViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: LastNewsViewHolder, position: Int) {
        val currentItem =   sportApiNews.get(position)

    }

    override fun getItemCount(): Int {
        return sportApiNews.size
    }

    class LastNewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)  {


        val dateAllRecommended: TextView = itemView.findViewById(R.id.text)
    }

}