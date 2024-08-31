package com.example.rickandmorty.ui.characterList

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.rickandmorty.ui.components.CharacterItem
import com.example.rickandmorty.viewmodel.CharacterListViewModel

@Composable
fun CharacterListScreen(
    onCharacterClick: (Int) -> Unit,
    viewModel: CharacterListViewModel = hiltViewModel()
) {
    val characters by viewModel.characters.collectAsState()

    LazyColumn {
        items(characters) { character ->
            CharacterItem(character = character, onClick = { onCharacterClick(character.id) })
        }
    }
}
