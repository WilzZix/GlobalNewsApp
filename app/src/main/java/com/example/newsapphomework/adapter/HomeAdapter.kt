package com.example.newsapphomework.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newsapphomework.R
import com.example.newsapphomework.model.Article
import kotlinx.android.synthetic.main.item.view.*

class HomeAdapter : RecyclerView.Adapter<HomeAdapter.ViewHolder>() {

    private val data = ArrayList<Article>()

    fun setData(d: List<Article>) {
        data.clear()
        data.addAll(d)
        notifyItemRangeInserted(this.data.size - d.size, data.size)
    }

    inner class ViewHolder(var view: View) : RecyclerView.ViewHolder(view) {

        fun bindView(data: Article) {
            view.newsDateTextView.text = data.publishedAt
            view.newsDescriptionTextView.text = data.description
            Glide.with(view.context)
                .load(data.urlToImage)
                .override(400, 400)
                .centerCrop()
                .into(view.imageView)
            view.newsDescriptionTextView.setOnClickListener {


//                val i = Intent(Intent.ACTION_VIEW, Uri.parse(data.url))
//                startActivity(i)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(data[position])
    }

    override fun getItemCount() = data.size


}