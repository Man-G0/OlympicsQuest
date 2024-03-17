package com.example.olympicsquest

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import android.content.res.Resources
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.res.ResourcesCompat
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import com.example.olympicsquest.model.Sport
import com.example.olympicsquest.sealed.DataState
import com.example.olympicsquest.ui.theme.OlympicsQuestTheme
import com.example.olympicsquest.viewmodel.MainViewModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import java.io.BufferedReader
import java.io.File
import java.io.IOException
import java.io.InputStreamReader
import java.nio.charset.Charset
import com.google.firebase.database.*
import androidx.lifecycle.viewmodel.compose.viewModel

class HomePage(navController: NavHostController) : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OlympicsQuestTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ContentHomePage()
                }

            }
        }
    }


}
@Composable
private fun ShowLazyList(sports: MutableList<Sport>) {
    LazyColumn(Modifier.offset(15.dp)){
        items(sports){each ->

            Button(sport = each)

        }
    }
}
@Composable
fun SetData(viewModel: MainViewModel) {
    when(val result=viewModel.response.value){
        is DataState.Loading->{
            Box(modifier = Modifier.fillMaxSize()
            ){
                CircularProgressIndicator()
            }

        }is DataState.Success->{
        ShowLazyList(result.data)
    }is DataState.Failure->{
        Box(modifier = Modifier.fillMaxSize()
        ){
            Text(text= result.message)
        }
    }else -> {
        Box(modifier = Modifier.fillMaxSize()
        ){
            Text(text= "Error Fetching Data")
        }
    }
    }
}
@Composable
fun ContentHomePage(){
    BackgroundHomePage()
    SetData(viewModel())
}

@Composable
fun BackgroundHomePage(modifier: Modifier = Modifier) {
    Box{
        Image(
            painter = painterResource(R.drawable.jo),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(225.dp)
                .offset(y = -25.dp)
        )
        Box(
            modifier = Modifier
                .offset(y = 150.dp)
                .background(Color.White, RoundedCornerShape(30.dp))
                .height(675.dp)
                .fillMaxWidth()
                    )

    }
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview3() {
    OlympicsQuestTheme {
        //Greeting3("Android")
        BackgroundHomePage()
    }
}
