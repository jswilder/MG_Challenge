package com.jwilder.tinder.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jwilder.tinder.remote.Gif
import com.jwilder.tinder.repository.GifRepository
import com.jwilder.tinder.util.NavigationEvent
import com.jwilder.tinder.util.SingleLiveEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: GifRepository
) : ViewModel() {

    init {
        fetchGifs()
    }

    /**
     * Backing field for the list of Gifs
     */
    private val _gifList = MutableLiveData<List<Gif>>()
    val gifList: LiveData<List<Gif>>
        get() = _gifList

    val navigationSingleLiveEvent: LiveData<NavigationEvent>
        get() = _navigationSingleLiveEvent
    private val _navigationSingleLiveEvent = SingleLiveEvent<NavigationEvent>()

    val selectedGif: LiveData<Gif>
        get() = _selectedGif
    private val _selectedGif = MutableLiveData<Gif>()

    private fun fetchGifs() {
        viewModelScope.launch(Dispatchers.IO) {
            val res = repository.fetchTrendingGifs()
            if (res.isSuccessful) {
                Log.d(TAG, res.body().toString())
                _gifList.postValue(res.body()?.data)
            } else {
                Log.d(TAG, res.message())
            }
        }
    }

    fun navigateToExpandedFragment(gif: Gif) {
        _selectedGif.postValue(gif)
        _navigationSingleLiveEvent.postValue(NavigationEvent.NavigateToExpandedGifFragment)
    }

    companion object {
        val TAG = MainViewModel::class.simpleName
    }
}