package com.example.olympicsquest.viewmodel

import android.app.Application
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.olympicsquest.model.Sport
import com.example.olympicsquest.sealed.DataState
import com.google.firebase.FirebaseApp
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class MainViewModel : ViewModel() {
    val response : MutableState<DataState> = mutableStateOf(DataState.Empty)
    private val _searchText = MutableStateFlow("")
    val searchText = _searchText.asStateFlow()

    private val _isSearching = MutableStateFlow(false)
    val isSearching = _isSearching.asStateFlow()
    private val _sports = MutableStateFlow(fetchtempList())
    val Sports  = _sports.map { it.toList() }
    val sports = searchText
        .combine(Sports){ text, sports ->
            if(text.isBlank()){
                sports
            }else{
                sports.filter {
                    it.doesMatchSearchQuery(text)
                }
            }
        }
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000),
            _sports.value
        )

    fun onSearchTextChange(text: String){
        _searchText.value = text
    }

    init {

        fetchDataFromFirebase()
    }

    private fun fetchDataFromFirebase() {
        val tempList = mutableListOf<Sport>()
        response.value = DataState.Loading
        FirebaseDatabase.getInstance().getReference()
            .addListenerForSingleValueEvent(object : ValueEventListener{
                override fun onDataChange(snapshot: DataSnapshot) {
                    for(DataSnap in snapshot.children){
                        val sportItem = DataSnap.getValue(Sport::class.java)
                        if(sportItem!=null){
                            tempList.add(sportItem)
                        }
                    }
                    response.value=DataState.Success(tempList)
                }

                override fun onCancelled(error: DatabaseError) {
                    response.value = DataState.Failure(error.message)
                }
            })

    }
    private fun fetchtempList(): MutableList<Sport> {
        val tempList = mutableListOf<Sport>()
        response.value = DataState.Loading
        FirebaseDatabase.getInstance().getReference()
            .addListenerForSingleValueEvent(object : ValueEventListener{
                override fun onDataChange(snapshot: DataSnapshot) {
                    for(DataSnap in snapshot.children){
                        val sportItem = DataSnap.getValue(Sport::class.java)
                        if(sportItem!=null){
                            tempList.add(sportItem)
                        }
                    }
                    response.value=DataState.Success(tempList)
                }

                override fun onCancelled(error: DatabaseError) {
                    response.value = DataState.Failure(error.message)
                }
            })
        return tempList
    }




}