@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.olympicsquest

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

val Black=Color(0xff000000)

@Composable
fun SportProfileImage(image: String, modifier: Modifier=Modifier) {

    if (image == "basket") {
        Image(
            painter = painterResource(R.drawable.basketballprofile),
            contentDescription = null, contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(130.dp)
                .offset(x = 22.dp, y = 160.dp)
        )
    } else if (image == "athletisme") {
        Image(
            painter = painterResource(R.drawable.athletismeprofile),
            contentDescription = null, contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(130.dp)
                .offset(x = 22.dp, y = 160.dp)
        )
    } else if (image == "tir a l'arc") {
        Image(
            painter = painterResource(R.drawable.arcprofile),
            contentDescription = null, contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(130.dp)
                .offset(x = 22.dp, y = 160.dp)
        )
    } else if (image == "badminton") {
        Image(
            painter = painterResource(R.drawable.badmintonprofile),
            contentDescription = null, contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(130.dp)
                .offset(x = 22.dp, y = 160.dp)
        )
    } else if (image == "bmx") {
        Image(
            painter = painterResource(R.drawable.bmxprofile),
            contentDescription = null, contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(130.dp)
                .offset(x = 22.dp, y = 160.dp)
        )
    } else if (image == "boxe") {
        Image(
            painter = painterResource(R.drawable.boxeprofile),
            contentDescription = null, contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(130.dp)
                .offset(x = 22.dp, y = 160.dp)
        )
    } else if (image == "break") {
        Image(
            painter = painterResource(R.drawable.breakingprofile),
            contentDescription = null, contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(130.dp)
                .offset(x = 22.dp, y = 160.dp)
        )
    } else if (image == "cyclisme") {
        Image(
            painter = painterResource(R.drawable.cyclismeprofile),
            contentDescription = null, contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(130.dp)
                .offset(x = 22.dp, y = 160.dp)
        )
    }
    else if(image=="escalade")
    {
        Image(
            painter = painterResource(R.drawable.escaladeprofile),
            contentDescription = null,contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(130.dp)
                .offset(x = 22.dp, y = 160.dp)
        )
    }
}

@Composable
fun BackgroundSportPage(sport : String?,epreuve : String?,session : String?,date : String?,lieu : String?,startTime : String?,endTime : String?,geo_point : String?,navController: NavHostController,modifier: Modifier = Modifier) {
    var image = R.drawable.basketball
    if(sport == "Basketball" || sport == "Basketball (Phase finale)"){
        image = R.drawable.basketball

    }
    if(sport == "Badminton"){
        image = R.drawable.badminton
    }
    if(sport == "Archery"){
        image = R.drawable.tiralarc

    }
    if(sport == "Athletisme"){
        image = R.drawable.athletisme
    }
    if(sport == "Boxe"){
        image = R.drawable.boxe
    }
    if(sport == "Breaking"){
        image = R.drawable.breaking
    }
    if(sport == "Cyclisme sur route"){
        image = R.drawable.cyclismesurroute

    }
    if(sport == "BMX Freestyle"){
        image = R.drawable.bmxfreestyle
    }
    if(sport == "Escalade"){
        image = R.drawable.escalade
    }
    Image(
        painter = painterResource(image),
        contentDescription = null,
        modifier = modifier
            .width(285.dp)
            .height(100.dp)
    )
    Box {
        Image(
            painter = painterResource(image),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Black)
                .height(225.dp)
                .offset(y = -25.dp)
        )
        Box(
            modifier = Modifier
                .offset(y = 130.dp)
                .background(Color.White, RoundedCornerShape(50.dp))
                .height(675.dp)
                .fillMaxWidth()
        )
        Text(
            text = "Informations : ",
            modifier = Modifier
                .fillMaxWidth()
                .offset(175.dp, 160.dp),
            style = TextStyle(
                fontSize = 20.sp,
                fontFamily = paris2024,
                fontWeight = FontWeight.ExtraBold,
                color = Black
            )
        )
        Text(
            text = lieu.toString(),
            modifier = Modifier
                .fillMaxWidth()
                .offset(175.dp, 185.dp),
            style = TextStyle(
                fontSize = 20.sp,
                fontFamily = paris2024,
                fontWeight = FontWeight.Normal,
                color = Black
            )
        )
        Text(
            text = "man/women",
            modifier = Modifier
                .fillMaxWidth()
                .offset(175.dp, 210.dp),
            style = TextStyle(
                fontSize = 20.sp,
                fontFamily = paris2024,
                fontWeight = FontWeight.Normal,
                color = Black
            )
        )
        Text(
            text = "Olympics/paralympics",
            modifier = Modifier
                .fillMaxWidth()
                .offset(175.dp, 235.dp),
            style = TextStyle(
                fontSize = 20.sp,
                fontFamily = paris2024,
                fontWeight = FontWeight.Normal,
                color = Black
            )
        )
        Text(
            text = "Qualifications/finals",
            modifier = Modifier
                .fillMaxWidth()
                .offset(175.dp, 260.dp),
            style = TextStyle(
                fontSize = 20.sp,
                fontFamily = paris2024,
                fontWeight = FontWeight.Normal,
                color = Black
            )
        )
        Text(
            text = "Quests nearby :",
            modifier = Modifier
                .fillMaxWidth()
                .offset(17.dp, 355.dp),
            style = TextStyle(
                fontSize = 20.sp,
                fontFamily = paris2024,
                fontWeight = FontWeight.ExtraBold,
                color = Black
            )
        )
        Image(
            painter = painterResource(R.drawable.back),
            contentDescription = null,
            modifier = Modifier
                .size(40.dp)
                .offset(x = 20.dp, y = 20.dp)

        )
        SportProfileImage(image = "basket")

    }
    //Component_Place(text = Place("Arc de Triomphe","Place de l'étoile","4.5/5","Historical Monument"), image ="arche" )
    //DropDown()


}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DropDown(){
    val list = listOf("One", "Two", "Three", "Four", "Five")

    var selectedText by remember { mutableStateOf(list[0]) }

    var isExpanded by remember {
        mutableStateOf(false)
    }

    Box(
    modifier = Modifier
        .width(100.dp)
        .height(50.dp)
        .offset(15.dp, 8.dp)
    ) { ExposedDropdownMenuBox(
        expanded = isExpanded,
        onExpandedChange = { isExpanded = !isExpanded}
        ) {
            TextField(modifier=Modifier.menuAnchor(),value  = selectedText, onValueChange = {}, readOnly = true, trailingIcon ={ExposedDropdownMenuDefaults.TrailingIcon(
            expanded = isExpanded)}
            )
            ExposedDropdownMenu(expanded = isExpanded, onDismissRequest = { isExpanded=false}) {
                list.forEachIndexed { index,text ->
                    DropdownMenuItem(
                        text={Text(text=text, modifier = Modifier.offset(2.dp,2.dp),style = TextStyle(
                                fontSize = 20.sp,//faire class avec nom pour mettre bonne endroit taille et font
                            fontFamily = paris2024,
                            fontWeight = FontWeight.Normal,
                            color = Black))},
                        onClick = {
                            selectedText=list[index]
                            isExpanded = false
                        },
                        contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding
                    )
                }
            
            }
        }
    }
}



@Preview(showBackground=true)
@Composable
fun Sport_Page_Preview(){
    lateinit var navController: NavHostController
    navController = rememberNavController()
    SetupNavGraph(navController = navController)
    BackgroundSportPage("basket", "Finals", "Session","01/01/24","Parc des Princes","14h15","16h","2.253076, 48.841319", navController)
}