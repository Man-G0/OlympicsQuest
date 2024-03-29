package com.example.olympicsquest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.olympicsquest.sealed.DataState
import com.example.olympicsquest.ui.theme.OlympicsQuestTheme
import com.example.olympicsquest.viewmodel.MainViewModel

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
                    //ContentHomePage(navController = navController)
                }

            }
        }
    }


}
@Composable
private fun ShowLazyList(navController: NavHostController) {
    val viewModel = viewModel<MainViewModel>()
    val searchText by viewModel.searchText.collectAsState()
    val filteredSports by viewModel.sports.collectAsState()
    val isSearching by viewModel.isSearching.collectAsState()


    Box(Modifier.fillMaxSize()){
        Image(
            painter = painterResource(R.drawable.jo),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(225.dp)
                .offset(y = -25.dp)
        )
        TextField(value = searchText,
            onValueChange = viewModel::onSearchTextChange,
            modifier = Modifier
                .offset(x = 50.dp, y = 50.dp)
                .background(Color.White, RoundedCornerShape(50.dp))
                .height(50.dp)
                .width(300.dp),
            placeholder = {Text(text = "Search...")})
        Box(
            modifier = Modifier
                .offset(y = 150.dp)
                .background(Color.White, RoundedCornerShape(30.dp))
                .fillMaxSize()
        )
        {
            if(isSearching){
                Box(modifier = Modifier.fillMaxSize()){
                    CircularProgressIndicator(
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
            }else{
                LazyColumn(modifier = Modifier.fillMaxSize().offset(y= 30.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(30.dp),
                    contentPadding = PaddingValues(top = 30.dp, bottom = 200.dp),
                ){
                    items(filteredSports){each ->

                        Button(sport = each, navController)

                    }
                }
            }

        }

    }

}
@Composable
fun SetData(viewModel: MainViewModel,navController: NavHostController ) {
    when(val result=viewModel.response.value){
        is DataState.Loading->{
            Box(modifier = Modifier.fillMaxSize()
            ){
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Center)
                )
            }

        }is DataState.Success->{
        ShowLazyList(navController)
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
fun ContentHomePage(navController: NavHostController){

    SetData(viewModel(),navController)
}
//je veux push

@Composable
fun BackgroundHomePage(modifier: Modifier = Modifier) {
    Box(Modifier.fillMaxSize()){
        Image(
            painter = painterResource(R.drawable.jo),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(225.dp)
                .offset(y = -25.dp)
        )
        Box(modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter){
            Box(
                modifier = Modifier
                    .background(Color.White, RoundedCornerShape(30.dp))
                    .height(700.dp)
                    .fillMaxWidth()
            )
        }


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
