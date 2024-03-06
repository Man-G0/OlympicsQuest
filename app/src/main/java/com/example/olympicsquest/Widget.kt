package com.example.olympicsquest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.olympicsquest.ui.theme.OlympicsQuestTheme

class Widget : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OlympicsQuestTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting2("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting2(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Composable
fun ButtonImage(sport : String, modifier: Modifier = Modifier){

    if(sport == "Basketball"){
        Image(
            painter = painterResource(R.drawable.basketball),
            contentDescription = null,
            modifier = Modifier
                .width(285.dp)
                .height(100.dp)
        )
    }
    if(sport == "Badminton"){
        Image(
            painter = painterResource(R.drawable.badminton),
            contentDescription = null,
            modifier = Modifier
                .width(285.dp)
                .height(100.dp)
        )
    }
    if(sport == "Tir à l'arc"){
        Image(
            painter = painterResource(R.drawable.tiralarc),
            contentDescription = null,
            modifier = Modifier
                .width(285.dp)
                .height(100.dp)
        )
    }
    if(sport == "Athletisme"){
        Image(
            painter = painterResource(R.drawable.athletisme),
            contentDescription = null,
            modifier = Modifier
                .width(285.dp)
                .height(100.dp)
        )
    }
    if(sport == "Boxe"){
        Image(
            painter = painterResource(R.drawable.boxe),
            contentDescription = null,
            modifier = Modifier
                .width(285.dp)
                .height(100.dp)
        )
    }
    if(sport == "Breaking"){
        Image(
            painter = painterResource(R.drawable.breaking),
            contentDescription = null,
            modifier = Modifier
                .width(285.dp)
                .height(100.dp)
        )
    }
    if(sport == "Cyclisme sur route"){
        Image(
            painter = painterResource(R.drawable.cyclismesurroute),
            contentDescription = null,
            modifier = Modifier
                .width(285.dp)
                .height(100.dp)
        )
    }
    if(sport == "BMX fresstyle"){
        Image(
            painter = painterResource(R.drawable.bmxfreestyle),
            contentDescription = null,
            modifier = Modifier
                .width(285.dp)
                .height(100.dp)
        )
    }
    if(sport == "Escalade"){
        Image(
            painter = painterResource(R.drawable.escalade),
            contentDescription = null,
            modifier = Modifier
                .width(285.dp)
                .height(100.dp)
        )
    }
}
@Composable
fun Button(sport : String, time : String, cession : String, modifier: Modifier = Modifier){

}
@Preview(showBackground = false)
@Composable
fun GreetingPreview2() {
    OlympicsQuestTheme {
        //Greeting2("Android")
        ButtonImage(sport = "Escalade")
    }
}