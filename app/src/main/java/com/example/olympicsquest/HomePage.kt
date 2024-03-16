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
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.res.ResourcesCompat
import androidx.navigation.NavHostController
import com.example.olympicsquest.ui.theme.OlympicsQuestTheme
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import java.io.BufferedReader
import java.io.File
import java.io.IOException
import java.io.InputStreamReader
import java.nio.charset.Charset
import com.google.firebase.database.*



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
                    //Greeting3("Android")
                }
            }
        }
    }
}
data class Sport(
    val name: String,
    val startTime : String,
    val endTime : String,
    val cession : String,
    val localisation : String) {
    override fun toString(): String {
        return "Sport(name='$name', startTime='$startTime', endTime='$endTime', cession='$cession', localisation='$localisation')"
    }
}

private val sports: MutableList<Sport> = mutableListOf()
private val database = FirebaseDatabase.getInstance()
private val myRef = database.reference
// Récupérer les données depuis Firebase

@Composable
fun ReadCalendrier(){
    val context = LocalContext.current
    val resources = context.resources
    val inputStream = resources.openRawResource(R.raw.calendrier_jo)
    val reader = BufferedReader(InputStreamReader(inputStream, Charset.forName("UTF-8")))

    try {
        reader.readLine() // Skip the first line
        var line: String
        while (reader.readLine().also { line = it } != null) {
            val tokens = line.split(";")
            val event = Sport(
                name = tokens[0],
                startTime = tokens[1],
                endTime = tokens[2],
                cession = tokens[3],
                localisation = tokens[4]
            )
            sports.add(event)
            Log.d("HomePage", "Just created: $event")
        }
    } catch (e: IOException) {
        //Log.d("HomePage", "Error reading calendrier file on line $line", e)
        e.printStackTrace()
    } finally {
        reader.close()
    }
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
