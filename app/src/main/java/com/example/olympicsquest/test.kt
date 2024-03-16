package com.example.olympicsquest

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier



@Composable
fun TestAppelApi(activitiesState: ActivitiesState){
    Column(){
        when (activitiesState) {
            is ActivitiesState.Success -> {
                val activitiesData = activitiesState.activitiesData
                Text(
                    text = "${activitiesData.name.toString()}"

                )
                Text(
                    text = "${activitiesData.lat}, ${activitiesData.lon}",

                )

            }

            else -> {}
        }
    }
}
@Composable
fun HomeScreen(activitiesViewModel: ActivitiesViewModel) {
    val activitiesState by activitiesViewModel.activitiesState.collectAsState()
    Surface(modifier = Modifier.verticalScroll(rememberScrollState())) {
        Column(
            modifier = Modifier
                .fillMaxWidth())
        {
            TestAppelApi(activitiesState = activitiesState)

        }
    }
}

//val activitiesviewModel: ActivitiesViewModel by viewModels()



//ActivitiesScreen(activitiesViewModel = activitiesviewModel)
//activitiesviewModel.fetchActivitiesData(city = "Ahmedabad")
@ExperimentalMaterial3Api
@Composable
fun ActivitiesScreen(activitiesView:ActivitiesViewModel) {
    val activitiesState by activitiesView.activitiesState.collectAsState()
    HomeScreen(activitiesView)
}


