package com.tapandgo.mybikes.ui.notifications

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tapandgo.mybikes.repository.MyBikesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import javax.inject.Inject

@HiltViewModel
class MoreInfoViewModel @Inject constructor(
private val repository: MyBikesRepository
) : ViewModel() {

    // Mutable live data
    private val _stationName = MutableLiveData<String>()
    private val _address = MutableLiveData<String>()
    private val _lastUpdate = MutableLiveData<String>()
    private val _status = MutableLiveData<String>()
    private val _availableBikes = MutableLiveData<Int>()
    private val _availableStands = MutableLiveData<Int>()
    // Variables bind with the view
    val stationName: LiveData<String> = _stationName
    val address: LiveData<String> = _address
    val lastUpdate: LiveData<String> = _lastUpdate
    val status: LiveData<String> = _status
    val availableBikes: LiveData<Int> = _availableBikes
    val availableStands: LiveData<Int> = _availableStands

    /**
     * Get station information
     */
    fun retrieveStationInfo() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val result = repository.getStationInfo()
                _stationName.postValue(result.name)
                _address.postValue(result.address)
                _status.postValue(result.status)
                // Need to convert the data returned by the API to a Date
                val simpleDateFormat = SimpleDateFormat("dd/MM/yyyy HH:mm")
                val dateString = simpleDateFormat.format(result.lastUpdate)
                _lastUpdate.postValue(dateString)
                _availableStands.postValue(result.availableBikeStands)
                _availableBikes.postValue(result.availableBikes)

            } catch (e: Exception) {
                _address.postValue("Unknown")
                _lastUpdate.postValue("N/A")
            }
        }
    }
}