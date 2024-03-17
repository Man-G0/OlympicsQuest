package com.example.olympicsquest

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class Place(val name: String, val address: String, val ratings: String, val description: String)

@Composable
fun IconPlace(image: String, modifier: Modifier=Modifier)
{
    if(image=="arche")
    {
        Image(painter = painterResource(id = R.drawable.arch),
            contentDescription = null,
            modifier= Modifier
                .offset(45.dp, 5.dp)
                .size(60.dp))
    }
    else if (image=="ticket")
    {
        Image(painter = painterResource(id = R.drawable.ticket),
            contentDescription = null,
            modifier= Modifier
                .offset(45.dp, 5.dp)
                .size(60.dp))
    }
    else if (image=="museum")
    {
        Image(painter = painterResource(id = R.drawable.museum),
            contentDescription = null,
            modifier= Modifier
                .offset(45.dp, 5.dp)
                .size(60.dp))
    }
}

@Composable
fun TextAndBack(text : Place)
{
    Image(painter = painterResource(id = R.drawable.greyback),
        contentDescription = null, modifier = Modifier.size(150.dp)
        )
    Text(text.name,
        modifier= Modifier
            .offset(42.dp, 65.dp),textAlign = TextAlign.Center,
        style= TextStyle(fontSize = 10.sp, fontFamily = paris2024, fontWeight = FontWeight.Normal,color= Black
        )
    )

    Text(text.address,
        modifier= Modifier
            .offset(42.dp, 80.dp),textAlign = TextAlign.Center,
        style= TextStyle(fontSize = 10.sp, fontFamily = paris2024, fontWeight = FontWeight.Normal,color= Black
        )
    )

    Text(text.ratings,
        modifier= Modifier
            .offset(63.dp, 95.dp),
        style= TextStyle(fontSize = 10.sp, fontFamily = paris2024, fontWeight = FontWeight.Normal,color= Black
        )
    )
    Text(text.description,
        modifier= Modifier
            .offset(35.dp,110.dp), textAlign = TextAlign.Start,
        style= TextStyle(fontSize = 10.sp, fontFamily = paris2024, fontWeight = FontWeight.Normal,color= Black
        )
    )

}

@Composable
fun Component_Place(text:Place, image:String)
{
    TextAndBack(text = text)
    IconPlace(image = image)
}

@Preview(showBackground = false)
@Composable
fun Place_Preview()
{
    Component_Place(text = Place("Arc de Triomphe","Place de l'étoile","4.5/5","Cultural activity"), image ="arche" )
}