package com.example.olympicsquest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.olympicsquest.model.Sport
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
                    //Greeting2("Android")
                    //ButtonImage(sport = "Escalade")
                    Button(Sport("Basketball", "17:30", "16:30","Cession BK301", "Paris"))               }
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
fun ButtonImage(sport : Sport, modifier: Modifier = Modifier){

    if(sport.sport == "Basketball" || sport.sport == "Basketball (Phase finale)"|| sport.sport == "Basketball 3x3"){
        Image(
            painter = painterResource(R.drawable.basketball),
            contentDescription = null,
            modifier = Modifier
                .width(285.dp)
                .height(100.dp)
        )
    }
    if(sport.sport == "Badminton"){
        Image(
            painter = painterResource(R.drawable.badminton),
            contentDescription = null,
            modifier = Modifier
                .width(285.dp)
                .height(100.dp)
        )
    }
    if(sport.sport == "Archery"){
        Image(
            painter = painterResource(R.drawable.tiralarc),
            contentDescription = null,
            modifier = Modifier
                .width(285.dp)
                .height(100.dp)
        )
    }
    if(sport.sport == "Athletisme"){
        Image(
            painter = painterResource(R.drawable.athletisme),
            contentDescription = null,
            modifier = Modifier
                .width(285.dp)
                .height(100.dp)
        )
    }
    if(sport.sport == "Boxe"){
        Image(
            painter = painterResource(R.drawable.boxe),
            contentDescription = null,
            modifier = Modifier
                .width(285.dp)
                .height(100.dp)
        )
    }
    if(sport.sport == "Breaking"){
        Image(
            painter = painterResource(R.drawable.breaking),
            contentDescription = null,
            modifier = Modifier
                .width(285.dp)
                .height(100.dp)
        )
    }
    if(sport.sport == "Cyclisme sur route"){
        Image(
            painter = painterResource(R.drawable.cyclismesurroute),
            contentDescription = null,
            modifier = Modifier
                .width(285.dp)
                .height(100.dp)
        )
    }
    if(sport.sport == "BMX Freestyle"){
        Image(
            painter = painterResource(R.drawable.bmxfreestyle),
            contentDescription = null,
            modifier = Modifier
                .width(285.dp)
                .height(100.dp)
        )
    }
    if(sport.sport == "Escalade"){
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
fun Button(sport : Sport, modifier: Modifier = Modifier){
    Box{
        ButtonImage(sport = sport)
        Column(modifier = Modifier.padding(5.dp)) {
            Text(text = sport.sport,
                color = Color.White,
                fontFamily = paris2024,
                fontSize = 23.sp,
                //lineHeight = 70.sp,
                //letterSpacing = 0.37.sp
                modifier = modifier.offset(x=15.dp)
            )
            Text(text = sport.horaire_debut,
                color = Color.White,
                fontFamily = paris2024,
                fontSize = 17.sp,
                //lineHeight = 70.sp,
                //letterSpacing = 0.37.sp
                modifier = modifier.offset(x=15.dp)
                )
            Spacer(modifier = Modifier.height(12.dp))
            Text(text = sport.session,
                color = Color.White,
                fontFamily = paris2024,
                fontSize = 15.sp,
                //lineHeight = 70.sp,
                //letterSpacing = 0.37.sp
                modifier = modifier.offset(x=15.dp)
            )
        }
    }
}
@Preview(showBackground = false)
@Composable
fun GreetingPreview2() {
    OlympicsQuestTheme {
        //Greeting2("Android")
        Button(Sport("20/07/2024", "Basketball","48.862286, 2.313222", "16:30","17:30", "Paris", "Cession BK301"))
        //ButtonImage(sport = "Escalade")
    }
}