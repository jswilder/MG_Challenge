package com.jwilder.tinder.ui.viewholder

import android.content.Context
import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.jwilder.tinder.R
import com.jwilder.tinder.remote.Gif

class GifViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val gifImageView: ImageView = view.findViewById(R.id.gifImageView)

    fun bindTo(gif: Gif, context: Context, onClick: (Gif) -> Unit) {
        Glide.with(context)
            .load(gif.url)
            .placeholder(R.drawable.giphy)
            .load(R.drawable.giphy)
            .into(gifImageView)

        gifImageView.setOnClickListener {
            onClick(gif)
        }
    }
}