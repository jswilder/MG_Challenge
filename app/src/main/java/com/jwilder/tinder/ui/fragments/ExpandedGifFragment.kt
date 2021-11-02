package com.jwilder.tinder.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.hilt.navigation.fragment.hiltNavGraphViewModels
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.jwilder.tinder.R
import com.jwilder.tinder.databinding.FragmentExpandedGifBinding
import com.jwilder.tinder.ui.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ExpandedGifFragment : Fragment() {

    private val viewModel: MainViewModel by hiltNavGraphViewModels(R.id.nav_graph)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentExpandedGifBinding.inflate(inflater, container, false)

        viewModel.selectedGif.observe(viewLifecycleOwner, Observer { gif ->
            Glide.with(requireContext())
                .asGif()
                .load(gif.url)
                .placeholder(R.drawable.giphy)
                .into(binding.expandedGifImageView)
        })

        return binding.root
    }
}