package com.example.rickandmorty.ui.characterDetail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.rickandmorty.viewmodel.CharacterDetailViewModel

@Composable
fun CharacterDetailScreen(
    characterId: Int,
    viewModel: CharacterDetailViewModel = hiltViewModel()
) {
    remember { viewModel.fetchCharacterDetail(characterId) }

    val characterDetail by viewModel.characterDetail.collectAsState()

    characterDetail?.let { character ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Image(
                painter = rememberImagePainter(character.image),
                contentDescription = character.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = character.name, style = MaterialTheme.typography.titleLarge)
            Text(text = "Status: ${character.status}", style = MaterialTheme.typography.bodyMedium)
            Text(text = "Species: ${character.species}", style = MaterialTheme.typography.bodyMedium)
            Text(text = "Gender: ${character.gender}", style = MaterialTheme.typography.bodyMedium)
            Text(text = "Origin: ${character.origin.name}", style = MaterialTheme.typography.bodyMedium)
            Text(text = "Location: ${character.location.name}", style = MaterialTheme.typography.bodyMedium)
        }
    }
}
