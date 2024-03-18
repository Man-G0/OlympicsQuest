package com.example.olympicsquest

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.olympicsquest.model.Sport
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.IOException

data class GeoPoint2D(
    val lon: Double,
    val lat: Double
)

data class GeoShape(
    val type: String,
    val geometry: GeoPoint2D,
    val properties: Any
)

data class TouristSite(
    val geo_point_2d: GeoPoint2D,
    val geo_shape: GeoShape,
    val dep: String,
    val adresse: String,
    val nomcom: String,
    val insee: String,
    val nom_carto: String,
    val typo_niv3: String,
    val objectid: String
)

suspend fun fetchDataFromApi(apiURLend: String): List<TouristSite> = withContext(Dispatchers.IO) {
    val client = OkHttpClient()
    val request = Request.Builder()
        .url(apiURLend)
        .build()

    try {
        client.newCall(request).execute().use { response ->
            if (!response.isSuccessful) throw IOException("Unexpected code $response")

            val gson = Gson()
            val json = response.body?.string()
            val responseJson = gson.fromJson(json, Any::class.java)
            val results = (responseJson as? Map<*, *>)?.get("results") as? List<*>

            // Ajout d'une reconstruction du Json, car présence de virgules dans l'adresse = crash du chargement des données
            // En fait c'est les string qui ne marchent pas : ajout de "" autour des strings
            val correction = mutableListOf<String>()
            results?.forEach { site ->
                val adressIndex = site.toString().indexOf("adresse=") +8
                val finAdressIndex = site.toString().indexOf("nomcom=")-2
                val nomcomIndex = site.toString().indexOf("nomcom=") +7
                val finnomcomIndex = site.toString().indexOf("insee=")-2
                val nom_cartoIndex = site.toString().indexOf("nom_carto=")+10
                val finnom_cartoIndex = site.toString().indexOf("typo_niv3=")-2
                val typo_niv3Index = site.toString().indexOf("typo_niv3=")+10
                val fintypo_niv3Index = site.toString().indexOf("objectid=")-2
                val correct = site.toString().substring(0, adressIndex)+"\""+site.toString().substring(adressIndex,finAdressIndex)+"\""+site.toString().substring(finAdressIndex,nomcomIndex)+"\""+site.toString().substring(nomcomIndex,finnomcomIndex)+"\""+site.toString().substring(finnomcomIndex,nom_cartoIndex)+"\""+site.toString().substring(nom_cartoIndex,finnom_cartoIndex)+"\""+site.toString().substring(finnom_cartoIndex,typo_niv3Index)+"\""+site.toString().substring(typo_niv3Index,fintypo_niv3Index)+"\""+site.toString().substring(fintypo_niv3Index)
                //println(correct)
                correction.add(correct)
            }
            //return@use correction
            return@use correction.mapNotNull { gson.fromJson(it, TouristSite::class.java) }
        }
    } catch (e: IOException) {
        e.printStackTrace()
        return@withContext emptyList()
    }
}

fun printTouristSites(touristSites: List<TouristSite>?) {
    if (touristSites.isNullOrEmpty()) {
        println("No tourist sites found or error occurred while fetching data.")
    } else {
        touristSites.forEach { site ->
            println("Name: ${site.nom_carto}")
            println("Coordinates: ${site.geo_point_2d.lat}, ${site.geo_point_2d.lon}")
            println("Address: ${site.adresse}")
            println("-----")
        }
        /*touristSites.forEach { site ->
            println(site)}*/
    }
}

fun FetchNearTouristSitesFromAPI(geo_point : String,distance : Int):List <TouristSite> {
    var touristSites = listOf <TouristSite>()
    kotlinx.coroutines.runBlocking {
        var index = geo_point.indexOf(", ")
        var lat = geo_point.substring(0,index)
        var lon = geo_point.substring(index+2)
        var url = "https://data.iledefrance.fr/api/explore/v2.1/catalog/datasets/principaux-sites-touristiques-en-ile-de-france0/records?where=distance(geo_point_2d%2C%20geom%27POINT("+lon+"%20"+lat+")%27%2C%20"+distance+"km)&limit=20"
        touristSites = fetchDataFromApi(url)
        printTouristSites(touristSites)
    }
    return touristSites
}
@Composable
fun ShowLazyListActivities(sport : Sport, distance : Int, navController: NavHostController) {

    var coordinates = sport.geo_point
    var nearTouristSites = FetchNearTouristSitesFromAPI(coordinates, distance)
    var dist = distance
    while(nearTouristSites.isNullOrEmpty() ){
        nearTouristSites = FetchNearTouristSitesFromAPI(coordinates, dist++)
    }
    Box(modifier = Modifier
        .fillMaxSize()
        .offset(y = 30.dp)){
        LazyRow(state = rememberLazyListState(), modifier = Modifier
            //.background(Color.Blue)
            .fillMaxSize()
            .verticalScroll(rememberScrollState()), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(20.dp), contentPadding = PaddingValues(start =  25.dp, end = 50.dp)){

            items(nearTouristSites){each ->
                var image = ""
                if(each.typo_niv3 == "Offices du tourisme et syndicats d'initiative" ||each.typo_niv3 == "Centre de congrès et parc d'exposition"||each.typo_niv3 =="Musée et écomusée"||each.typo_niv3 =="Diffusion de l'art (autre que musée)"){
                    image = "museum"
                }
                else if(each.typo_niv3 =="Diffusion du spectacle vivant"||each.typo_niv3 == "Espace de loisirs, espace récréatif"){
                    image = "activity"
                }
                else{
                    image = "monument"
                }

                Component_Place(each, image, navController,Modifier.scale(1.2f))
            }
        }
    }
}

