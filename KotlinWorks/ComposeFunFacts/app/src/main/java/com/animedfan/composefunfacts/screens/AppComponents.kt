package com.animedfan.composefunfacts.screens

import android.webkit.WebSettings.TextSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.animedfan.composefunfacts.R
import com.animedfan.composefunfacts.data.UserDataUiEvents
import java.nio.file.WatchEvent

@Composable
fun TopBar(value: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = value,
            color = Color.Black,
            fontSize = 24.sp,
            fontWeight = FontWeight.Medium
        )

        Spacer(modifier = Modifier.weight(1f))

        Image(
            modifier = Modifier.size(45.dp),
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "some random logo"
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TopBarPreview() {
    TopBar("")
}

@Composable
fun TextComponent(textValue: String, textSize: TextUnit, colorValue: Color = Color.Black) {
    Text(
        text = textValue,
        fontSize = textSize,
        color = colorValue,
        fontWeight = FontWeight.Light
    )
}

@Preview(showBackground = true)
@Composable
fun TextComponentPreview() {
    TextComponent(
        "AnimeDFan",
        20.sp
    )
}

@Composable
fun TextfieldComponent(onTextChanged: (name: String) -> Unit) {
    var currentValue by remember {
        mutableStateOf("")
    }
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = currentValue,
        onValueChange = {
            currentValue = it
            onTextChanged(it)
        },
        placeholder = {
            Text(text = "Enter your name", fontSize = 18.sp)
        },
        textStyle = TextStyle.Default.copy(fontSize = 24.sp),
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Done
        )

    )
}

@Preview(showBackground = true)
@Composable
fun TextfieldComponentPreview() {
    TextfieldComponent {}
}


@Composable
fun AnimalCard(image:Int, selected: Boolean, animalSelected: (animalName:String) -> Unit) {
    Card (
        modifier = Modifier
            .background(Color.White)
            .padding(18.dp)
            .size(130.dp),
        elevation = CardDefaults.cardElevation(15.dp)
    ){
        Box(
            modifier = Modifier
                .border(
                    width = 2.75.dp,
                    color = if (selected) Color.Green else Color.Transparent,
                    shape = RoundedCornerShape(15.dp)
                )
                .background(Color.White)
//                .padding(18.dp)
                .size(130.dp),
        ) {
            Image(
                modifier = Modifier
                    .background(Color.White)
                    .wrapContentWidth()
                    .wrapContentHeight()
                    .clickable {
                        val animalName = if(image == R.drawable.cat) "Cat" else "Dog"
                        animalSelected(animalName)
                    },
                painter = painterResource(id = image),
                contentDescription = "Animal Image"
            )
        }
    }
    
}

@Preview
@Composable
fun AnimalCardPreview() {
    AnimalCard(R.drawable.cat,true, {""})
}