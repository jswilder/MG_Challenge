package com.jwilder.tinder.ui.callback

import androidx.recyclerview.widget.DiffUtil
import com.jwilder.tinder.remote.Gif

/**
 * Item callback to determine if two instances of [Gif] are the same for the ListAdapter
 */
class MovieItemDiffCallback : DiffUtil.ItemCallback<Gif>() {
    override fun areItemsTheSame(oldItem: Gif, newItem: Gif) = oldItem == newItem

    override fun areContentsTheSame(oldItem: Gif, newItem: Gif) = oldItem == newItem
}