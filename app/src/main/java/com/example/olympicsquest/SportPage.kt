package com.example.olympicsquest

import androidx.activity.ComponentActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
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
fun BackgroundSportPage(modifier: Modifier = Modifier) {

    Box {
        Image(
            painter = painterResource(R.drawable.basketball2),
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
            text = "Address ",
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




}



@Preview(showBackground=true)
@Composable
fun Sport_Page_Preview(){
    BackgroundSportPage()
}