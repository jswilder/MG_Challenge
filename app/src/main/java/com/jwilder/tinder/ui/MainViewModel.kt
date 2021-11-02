package com.jwilder.tinder.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jwilder.tinder.repository.GifRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: GifRepository
) : ViewModel() {

    init {
        fetchGifs()
    }

    private fun fetchGifs() {
        viewModelScope.launch {
            val res = repository.fetchTrendingGifs()
            if (res.isSuccessful) {
                Log.d(TAG, res.body().toString())
            } else {
                Log.d(TAG, "${res.message()} FAILED **")
            }
        }
    }

    companion object {
        val TAG = "JEREMY**"
    }
}