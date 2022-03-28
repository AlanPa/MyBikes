package com.tapandgo.mybikes.ui.map

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tapandgo.mybikes.model.Station
import com.tapandgo.mybikes.repository.MyBikesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MapViewModel @Inject constructor(
private val repository: MyBikesRepository
) : ViewModel() {

    // Mutable live data
    private val _stationList = MutableLiveData<List<Station>>()
    // Variables bind with the view
    val stationList: LiveData<List<Station>> = _stationList

    init {
        retrieveStations()
    }

    /**
     * Get station list
     */
    private fun retrieveStations() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                _stationList.postValue(repository.getStations())
            } catch (e: Exception) {
                _stationList.postValue(emptyList())
            }
        }
    }
}