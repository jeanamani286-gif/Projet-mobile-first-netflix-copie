package com.example.streamingapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class EpisodeAdapter(
    private val episodes: List<Episode>,
    private val onItemClick: (Episode) -> Unit
) : RecyclerView.Adapter<EpisodeAdapter.EpisodeViewHolder>() {

    class EpisodeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvEpisodeNumber: TextView = itemView.findViewById(R.id.tvEpisodeNumber)
        val tvEpisodeTitle: TextView = itemView.findViewById(R.id.tvEpisodeTitle)
        val tvEpisodeDuration: TextView = itemView.findViewById(R.id.tvEpisodeDuration)
        val tvEpisodeDescription: TextView = itemView.findViewById(R.id.tvEpisodeDescription)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EpisodeViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_episode, parent, false)
        return EpisodeViewHolder(view)
    }

    override fun onBindViewHolder(holder: EpisodeViewHolder, position: Int) {
        val episode = episodes[position]
        holder.tvEpisodeNumber.text = episode.episodeNumber.toString()
        holder.tvEpisodeTitle.text = episode.title
        holder.tvEpisodeDuration.text = episode.duration
        holder.tvEpisodeDescription.text = episode.description
        holder.itemView.setOnClickListener {
            onItemClick(episode)
        }
    }

    override fun getItemCount(): Int = episodes.size
}
