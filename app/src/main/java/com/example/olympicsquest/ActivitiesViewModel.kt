package com.example.olympicsquest

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

sealed class ActivitiesState{
    object Loading:ActivitiesState()
    data class Success(val activitiesData:ActivitiesResponse):ActivitiesState()
    data class Error(val message:String):ActivitiesState()

}
class ActivitiesViewModel : ViewModel() {
    private val _activitiesState = MutableStateFlow<ActivitiesState>(ActivitiesState.Loading)
    val activitiesState: StateFlow<ActivitiesState> = _activitiesState

    fun fetchActivitiesData(city:String) {
        viewModelScope.launch {
            try {
                val response = ActivitiesApi.activitiesService.getActivities(
                    //apiKey = "c4c9834ef0a048e1a4f45144231605",
                    city = city
                )
                _activitiesState.value = ActivitiesState.Success(response)
            } catch (e: Exception) {
                _activitiesState.value = ActivitiesState.Error("Failed to fetch Activities data.")
            }
        }
    }
}