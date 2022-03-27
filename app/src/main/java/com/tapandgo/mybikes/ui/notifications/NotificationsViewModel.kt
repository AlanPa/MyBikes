package com.tapandgo.mybikes.ui.notifications

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tapandgo.mybikes.repository.MyBikesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NotificationsViewModel @Inject constructor(
private val repository: MyBikesRepository
) : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is notifications Fragment"
    }
    val text: LiveData<String> = _text

    fun retrieveStationInfo() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val result = repository.getStationInfo()
                _text.postValue("Name : ${result.name}\nAddress : ${result.address}")
            } catch (e: Exception) {
                _text.postValue("${e.message}")
            }
        }
    }
}