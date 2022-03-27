package com.tapandgo.mybikes.ui.dashboard

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
class DashboardViewModel @Inject constructor(
    private val repository: MyBikesRepository
) : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is dashboard Fragment"
    }
    val text: LiveData<String> = _text

    init {
        retrieveStations()
    }

    private fun retrieveStations() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val listResult = repository.getStations()
                _text.postValue("${listResult.size} stations retrieved\nThe name of the first is: ${listResult.first().name}")
            } catch (e: Exception) {
                _text.postValue("${e.message}")
            }
        }
    }
}