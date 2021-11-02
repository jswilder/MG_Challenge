package com.jwilder.tinder.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.hilt.navigation.fragment.hiltNavGraphViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.jwilder.tinder.R
import com.jwilder.tinder.databinding.FragmentMainBinding
import com.jwilder.tinder.remote.Gif
import com.jwilder.tinder.ui.MainViewModel
import com.jwilder.tinder.ui.adapter.GifListAdapter
import com.jwilder.tinder.util.NavigationEvent
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment() {

    private val viewModel: MainViewModel by hiltNavGraphViewModels(R.id.nav_graph)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentMainBinding.inflate(inflater, container, false)

        // Init Recycler
        binding.gifRecyclerView.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = GifListAdapter(
                context
            ) { item -> onItemClick(item) }
        }

        viewModel.gifList.observe(viewLifecycleOwner, Observer { list ->
            (binding.gifRecyclerView.adapter as GifListAdapter).submitList(list)
        })

        viewModel.navigationSingleLiveEvent.observe(viewLifecycleOwner, Observer {
            when (it) {
                is NavigationEvent.NavigateToExpandedGifFragment -> findNavController().navigate(R.id.action_mainFragment_to_expandedGifFragment)
            }
        })

        return binding.root
    }

    private fun onItemClick(gif: Gif) {
        viewModel.navigateToExpandedFragment(gif)
    }
}