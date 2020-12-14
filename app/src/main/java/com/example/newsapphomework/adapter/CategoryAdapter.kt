package com.example.newsapphomework.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.newsapphomework.R
import com.example.newsapphomework.model.Article
import kotlinx.android.synthetic.main.business_category_item.view.*


class CategoryAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var items = ArrayList<Article>()

    //
//    fun setData(d: List<Article>) {
//        items.clear()
//        items.addAll(d)
//        notifyItemRangeInserted(this.items.size-d.size,items.size)
//    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.business_category_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ViewHolder -> {
                holder.run { bind(items[position]) }
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun submitList(article: List<Article>) {
        items.clear()
        items.addAll(article)
        notifyItemRangeInserted(this.items.size - article.size, items.size)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imageViewNewsNewsItem: ImageView = itemView.ImageViewNewsItem
        private val dateTextVIew: TextView = itemView.date_TV
        private val title: TextView = itemView.TitleTV

        fun bind(article: Article) {
            dateTextVIew.text = article.publishedAt
            title.text = article.title

            val requestOptions = RequestOptions()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)

            Glide.with(itemView.context)
                .applyDefaultRequestOptions(requestOptions)
                .load(article.urlToImage)
                .override(250, 200)
                .into(imageViewNewsNewsItem)
        }
    }

}