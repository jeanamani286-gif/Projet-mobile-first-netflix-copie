package com.example.streamingapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SearchAdapter(
    private var items: List<Content>,
    private val onItemClick: (Content) -> Unit
) : RecyclerView.Adapter<SearchAdapter.SearchViewHolder>() {

    class SearchViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivPoster: ImageView = itemView.findViewById(R.id.ivPoster)
        val tvTitle: TextView = itemView.findViewById(R.id.tvTitle)
        val tvSubtitle: TextView = itemView.findViewById(R.id.tvSubtitle)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_search_result, parent, false)
        return SearchViewHolder(view)
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        val content = items[position]
        holder.tvTitle.text = content.title
        holder.tvSubtitle.text = "${content.genre} • ${content.year}"
        holder.ivPoster.setImageResource(content.posterResId)
        holder.itemView.setOnClickListener {
            onItemClick(content)
        }
    }

    override fun getItemCount(): Int = items.size

    fun updateData(newItems: List<Content>) {
        items = newItems
        notifyDataSetChanged()
    }
}
