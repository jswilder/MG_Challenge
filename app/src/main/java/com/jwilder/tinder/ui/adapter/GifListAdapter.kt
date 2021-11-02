package com.jwilder.tinder.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.jwilder.tinder.R
import com.jwilder.tinder.remote.Gif
import com.jwilder.tinder.ui.callback.MovieItemDiffCallback
import com.jwilder.tinder.ui.viewholder.GifViewHolder

/**
 * Simple [ListAdapter] implementation for the Movie RecyclerView
 *
 * @param [context] Used to provide the [GifViewHolder] with the context it needs to fetch an
 * image with Glide
 */
class GifListAdapter(private val context: Context, private val onClick: (Gif) -> Unit ) :
    ListAdapter<Gif, GifViewHolder>(MovieItemDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = GifViewHolder(
        LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_gif_list_item, parent, false)
    )

    override fun onBindViewHolder(holder: GifViewHolder, position: Int) {
        holder.bindTo(getItem(position), context, onClick)
    }
}