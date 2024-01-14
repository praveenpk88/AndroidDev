package com.animedfan.composefunfacts.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.animedfan.composefunfacts.R
import com.animedfan.composefunfacts.data.UserDataUiEvents

@Composable
fun UserInputScreen(navController: UserInputViewModel) {
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(18.dp)
        ) {
            TopBar("Hi There \uD83D\uDE0A")

            Spacer(modifier = Modifier.size(20.dp))

            TextComponent(
                "Let's Learn about you !",
                24.sp
            )

            Spacer(modifier = Modifier.size(12.dp))

            TextComponent(
                "This app will prepare a details page based  on the input provided by you !",
                17.sp
            )

            Spacer(modifier = Modifier.size(45.dp))

            TextComponent(textValue = "Name", textSize = 18.sp)

            Spacer(modifier = Modifier.size(5.dp))

            TextfieldComponent(onTextChanged = {
                UserInputViewModel.onEvent(
                    UserDataUiEvents.UserNameEntered(it)
                )
            }
            )
            Spacer(modifier = Modifier.size(20.dp))

            TextComponent(textValue = "What do you like", textSize = 18.sp)

//            Spacer(modifier = Modifier.size(10.dp))

            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                val userInputViewModel = UserInputViewModel()
                AnimalCard(
                    image = R.drawable.cat, animalSelected = {
                        userInputViewModel.onEvent(
                            UserDataUiEvents.AnimalSelected(it)
                        )
                    }, selected = userInputViewModel.uiState.value.animalSelected == "Cat"
                )
                AnimalCard(
                    image = R.drawable.dog, animalSelected = {
                        userInputViewModel.onEvent(
                            UserDataUiEvents.AnimalSelected(it)
                        )
                    }, selected = userInputViewModel.uiState.value.animalSelected == "Dog"
                )
            }
        }
    }

}

@Preview
@Composable
fun UserInputScreenPreview() {
    UserInputScreen(UserInputViewModel())
}

