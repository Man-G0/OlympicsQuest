package com.example.olympicsquest

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

data class Place(val name: String, val address: String, val ratings: String, val description: String)

@Composable
fun IconPlace(image: String, modifier: Modifier=Modifier)
{
    if(image=="monument")
    {
        Image(painter = painterResource(id = R.drawable.arch),
            contentDescription = null,
            modifier= Modifier
                .size(100.dp))
    }
    else if (image=="activity")
    {
        Image(painter = painterResource(id = R.drawable.ticket),
            contentDescription = null,
            modifier= Modifier
                .size(100.dp))
    }
    else if (image=="museum")
    {
        Image(painter = painterResource(id = R.drawable.museum),
            contentDescription = null,
            modifier= Modifier
                .size(100.dp))
    }
}

@Composable
fun TextAndBack(site : TouristSite, image : String)
{
    Box( modifier = Modifier.size(300.dp), Alignment.Center){
        Image(painter = painterResource(id = R.drawable.greyback),
            contentDescription = null, modifier = Modifier.size(300.dp)
        )

        Column(
            Modifier
                .width(240.dp), horizontalAlignment = Alignment.CenterHorizontally){

            IconPlace(image = image)
            var sizeText = 5.dp
            Text(site.nom_carto,textAlign = TextAlign.Center,modifier = Modifier.padding(sizeText),
                style= TextStyle(fontSize = 18.sp, fontFamily = paris2024, fontWeight = FontWeight.Normal,color= Black,textAlign = TextAlign.Center
                )
            )

            Text(site.adresse +", "+ site.insee,
                modifier = Modifier.padding(sizeText),
                textAlign = TextAlign.Center,
                style= TextStyle(fontSize = 18.sp, fontFamily = paris2024, fontWeight = FontWeight.Normal,color= Black, textAlign = TextAlign.Center
                )
            )

            Text(site.typo_niv3,
                modifier = Modifier.padding(sizeText),
                style= TextStyle(fontSize = 18.sp, fontFamily = paris2024, fontWeight = FontWeight.Normal,color= Black,textAlign = TextAlign.Center
                )
            )

        }
    }



}

@Composable
fun Component_Place(site : TouristSite, image:String, navController: NavHostController, modifier: Modifier = Modifier)
{
    TextAndBack(site,image)
}

@Preview(showBackground = false)
@Composable
fun Place_Preview()
{
    var navController: NavHostController = rememberNavController()
    Component_Place(TouristSite(geo_point_2d = GeoPoint2D(15.0,15.0), GeoShape("Museum",GeoPoint2D(15.0,15.0),""), "75","18 rue Albert", "Paris", "75512","Arc de Triomphe", "Diffusion du spectacle vivant","15"),image ="monument",navController )
}

