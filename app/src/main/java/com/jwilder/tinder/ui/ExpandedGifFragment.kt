package com.jwilder.tinder.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.jwilder.tinder.databinding.FragmentExpandedGifBinding

class ExpandedGifFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentExpandedGifBinding.inflate(inflater, container, false)
        return binding.root
    }
}