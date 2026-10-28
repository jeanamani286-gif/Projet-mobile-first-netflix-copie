package com.example.streamingapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PosterAdapter(
    private var items: List<Content>,
    private val onItemClick: (Content) -> Unit
) : RecyclerView.Adapter<PosterAdapter.PosterViewHolder>() {

    class PosterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivPoster: ImageView = itemView.findViewById(R.id.ivPoster)
        val tvTitle: TextView = itemView.findViewById(R.id.tvTitle)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PosterViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_poster, parent, false)
        return PosterViewHolder(view)
    }

    override fun onBindViewHolder(holder: PosterViewHolder, position: Int) {
        val content = items[position]
        holder.tvTitle.text = content.title
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
