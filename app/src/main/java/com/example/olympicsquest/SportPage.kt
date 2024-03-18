@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.olympicsquest

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DropdownMenu
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
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
import com.example.olympicsquest.model.Sport

val Black=Color(0xff000000)



@Composable
fun BackgroundSportPage(sport : String?,epreuve : String?,session : String?,date : String?,lieu : String?,startTime : String?,endTime : String?,geo_point : String?,navController: NavHostController,modifier: Modifier = Modifier) {
    var image = R.drawable.basketball
    var icon = R.drawable.basketballprofile
    if(sport == "Basketball 3x3"){
        image = R.drawable.basketball
        icon = R.drawable.basketballthreeprofile
    }
    if(sport=="Basketball (Phase finale)"){
        image=R.drawable.basketball
        icon=R.drawable.basketballprofile
    }
    if(sport == "Badminton"){
        image = R.drawable.badminton
        icon = R.drawable.badmintonprofile
    }
    if(sport == "Archery"){
        image = R.drawable.tiralarc
        icon = R.drawable.arcprofile
    }
    if(sport == "Athletisme"){
        image = R.drawable.athletisme
        icon = R.drawable.athletismeprofile
    }
    if(sport == "Boxe"){
        image = R.drawable.boxe
        icon = R.drawable.boxeprofile
    }
    if(sport == "Breaking"){
        image = R.drawable.breaking

        icon = R.drawable.breakingprofile
    }
    if(sport == "Cyclisme sur route"){
        image = R.drawable.cyclismesurroute

        icon = R.drawable.cyclismeprofile

    }
    if(sport == "BMX Freestyle"){
        image = R.drawable.bmxfreestyle
        icon = R.drawable.bmxprofile
    }
    if(sport == "Escalade"){
        image = R.drawable.escalade
        icon = R.drawable.escaladeprofile
    }

    Image(
        painter = painterResource(image),
        contentDescription = null,
        modifier = modifier
            .width(285.dp)
            .height(100.dp)
    )
    Box(Modifier.fillMaxSize()) {

        Image(
            painter = painterResource(image),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .scale(1.3f)
                .background(Color.Black)
                .height(225.dp)
                .offset(y = -25.dp)
        )
        Box(modifier.fillMaxSize(),contentAlignment = Alignment.BottomCenter){
            Box(
                modifier = Modifier
                    .background(Color.White, RoundedCornerShape(30.dp))
                    .height(720.dp)
                    .fillMaxWidth()

                )
        }
        Text(
            text = sport.toString().capitalize(),
            modifier = Modifier
                .fillMaxWidth()
                .offset(70.dp, 27.dp),
            style = TextStyle(
                fontSize = 20.sp,
                fontFamily = paris2024,
                fontWeight = FontWeight.ExtraBold,
                color = Color.White
            )
        )
        Text(
            text = session.toString().capitalize(),
            modifier = Modifier
                .fillMaxWidth()
                .offset(70.dp, 75.dp),
            style = TextStyle(
                fontSize = 20.sp,
                fontFamily = paris2024,
                fontWeight = FontWeight.Normal,
                color = Color.White
            )
        )
        Text(
            text = "Epreuve :",
            modifier = Modifier
                .fillMaxWidth()
                .offset(17.dp, 300.dp),
            style = TextStyle(
                fontSize = 20.sp,
                fontFamily = paris2024,
                fontWeight = FontWeight.ExtraBold,
                color = Black
            )
        )
        Box(modifier = Modifier
            .width(360.dp)
            .height(100.dp))
        {
            Text(
                text = epreuve.toString().capitalize(),
                modifier = Modifier
                    .fillMaxWidth()
                    .offset(17.dp, 320.dp),
                style = TextStyle(
                    fontSize = 20.sp,
                    fontFamily = paris2024,
                    fontWeight = FontWeight.Normal,
                    color = Black
                )
            )
        }

        Text(
            text = date.toString().capitalize(),
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
            text = "Start : ",
            modifier = Modifier
                .fillMaxWidth()
                .offset(70.dp, 50.dp),
            style = TextStyle(
                fontSize = 18.sp,
                fontFamily = paris2024,
                fontWeight = FontWeight.Normal,
                color = Color.White
            )
        )
        Text(
            text = startTime.toString(),
            modifier = Modifier
                .fillMaxWidth()
                .offset(120.dp, 50.dp),
            style = TextStyle(
                fontSize = 18.sp,
                fontFamily = paris2024,
                fontWeight = FontWeight.Normal,
                color = Color.White
            )
        )
        Text(
            text = "End : ",
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
            text = endTime.toString(),
            modifier = Modifier
                .fillMaxWidth()
                .offset(220.dp, 260.dp),
            style = TextStyle(
                fontSize = 20.sp,
                fontFamily = paris2024,
                fontWeight = FontWeight.Normal,
                color = Black
            )
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
            text = "Olympics",
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
            text = "Quests nearby :",
            modifier = Modifier
                .fillMaxWidth()
                .offset(17.dp, 480.dp),
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
                .clickable { navController.popBackStack() }

        )
        Image(
            painter = painterResource(icon),
            contentDescription = null,contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(130.dp)
                .offset(x = 22.dp, y = 160.dp)
        )
        //SportProfileImage(image = sport.toString())

    }
    Box(modifier.offset(x = 22.dp, y = 200.dp)){
        ShowLazyListActivities( Sport(date.toString(),epreuve.toString(),geo_point.toString(),startTime.toString(),endTime.toString(),lieu.toString(),session.toString(),sport.toString()),2,  navController)
    }
   //Component_Place(text = Place("Arc de Triomphe","Place de l'étoile","4.5/5","Historical Monument"), image ="arche" )
    DropDown()


}
@OptIn(ExperimentalMaterial3Api::class)
// Le but de cette fonction était de faire un filtre drop down qui quand la valeur selectionné il filtre en fonction de ce lieu (museum,activity et monument)
//Cette fonction ne marche malheureusement pas
@Composable
fun DropDown(){
    val list = listOf("Museum", "Monument", "Activity")

    var selectedText by remember { mutableStateOf(list[0]) }

    var isExpanded by remember {
        mutableStateOf(false)
    }

    Box(
    modifier = Modifier
        .width(20.dp)
        .height(50.dp)
        .offset(15.dp, 420.dp)
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
                        text={Text(text=text, modifier = Modifier)},
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
    var navController: NavHostController
    navController= rememberNavController()
    BackgroundSportPage("Basketball 3x3", "Finals", "Session","01-01-24","Parc des Princes","14h15","16h","2.253076, 48.841319", navController)
}