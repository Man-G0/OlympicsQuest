package com.example.olympicsquest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
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
                    //Button(Sport("Basketball", "17:30", "16:30","Cession BK301", "Paris"))
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
fun ButtonImage(sport : Sport, navController: NavHostController, modifier: Modifier = Modifier){
    var modifier = Modifier.clickable {
        var date = sport.date.replace('/','-')
        var road = "sport_screen/${sport.sport}/${sport.epreuve}/${sport.session}/${date}/${sport.lieu}/${sport.horaire_debut}/${sport.horaire_fin}/${sport.geo_point}"
        navController.navigate(route = road) }
    var image = R.drawable.basketball

    if(sport.sport == "Basketball" || sport.sport == "Basketball (Phase finale)"){
        image = R.drawable.basketball

    }
    if(sport.sport == "Badminton"){
        image = R.drawable.badminton
    }
    if(sport.sport == "Archery"){
        image = R.drawable.tiralarc

    }
    if(sport.sport == "Athletisme"){
        image = R.drawable.athletisme
    }
    if(sport.sport == "Boxe"){
        image = R.drawable.boxe
    }
    if(sport.sport == "Breaking"){
        image = R.drawable.breaking
    }
    if(sport.sport == "Cyclisme sur route"){
        image = R.drawable.cyclismesurroute

    }
    if(sport.sport == "BMX Freestyle"){
        image = R.drawable.bmxfreestyle
    }
    if(sport.sport == "Escalade"){
        image = R.drawable.escalade
    }
    Image(
        painter = painterResource(image),
        contentDescription = null,
        modifier = modifier
            .width(285.dp)
            .height(100.dp)
    )
}
@Composable
fun Button(sport : Sport,navController: NavHostController, modifier: Modifier = Modifier){
    Box{
        ButtonImage(sport = sport,navController)
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
        lateinit var navController: NavHostController
        navController = rememberNavController()
        SetupNavGraph(navController = navController)
        Button(Sport("20/07/2024", "Basketball","48.862286, 2.313222", "16:30","17:30", "Paris", "Cession BK301"),navController)
        //ButtonImage(sport = "Escalade")
    }
}