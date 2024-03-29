package com.example.olympicsquest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.olympicsquest.ui.theme.OlympicsQuestTheme
import com.google.firebase.FirebaseApp

class MainActivity : ComponentActivity() {
    lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OlympicsQuestTheme {
                Surface(Modifier.fillMaxSize()) {
                    FirebaseApp.initializeApp(this)

                    navController = rememberNavController()
                    SetupNavGraph(navController = navController)
                }
            }
        }
    }
}



val paris2024 = FontFamily(
    Font(R.font.paris2024, FontWeight.Normal),
    //Font(R.font.sf_pro_display_bold, FontWeight.Bold),
    //Font(R.font.sf_pro_display_light, FontWeight.Light)
)

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    OlympicsQuestTheme {
        Greeting("Android")
    }
}