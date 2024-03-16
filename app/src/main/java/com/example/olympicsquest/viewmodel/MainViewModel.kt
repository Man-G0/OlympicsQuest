package com.example.olympicsquest.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.olympicsquest.model.Sport
import com.example.olympicsquest.sealed.DataState
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class MainViewModel : ViewModel() {
    val response : MutableState<DataState> = mutableStateOf(DataState.Empty)
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




}