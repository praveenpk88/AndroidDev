package com.animedfan.composefunfacts.screens

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.animedfan.composefunfacts.data.UserInputScreenState
import com.animedfan.composefunfacts.data.UserDataUiEvents

class UserInputViewModel: ViewModel() {
    var uiState = mutableStateOf(UserInputScreenState())

    fun onEvent(event: UserDataUiEvents){
        when(event){
            is UserDataUiEvents.UserNameEntered -> {
                uiState.value = uiState.value.copy(
                    nameEntered = event.name
                )
            }
            is UserDataUiEvents.AnimalSelected -> {
                uiState.value = uiState.value.copy(
                    animalSelected = event.animalValue
                )
            }
        }
    }

    companion object {
        fun onEvent(userNameEntered: UserDataUiEvents.UserNameEntered) {

        }
    }
}