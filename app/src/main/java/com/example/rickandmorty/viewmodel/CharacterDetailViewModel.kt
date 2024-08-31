package com.example.rickandmorty.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmorty.data.model.CharacterDetail
import com.example.rickandmorty.data.repository.CharacterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterDetailViewModel @Inject constructor(
    private val repository: CharacterRepository
) : ViewModel() {

    private val _characterDetail = MutableStateFlow<CharacterDetail?>(null)
    val characterDetail: StateFlow<CharacterDetail?> = _characterDetail

    fun fetchCharacterDetail(id: Int) {
        viewModelScope.launch {
            try {
                val response = repository.getCharacterById(id)
                _characterDetail.value = response
            } catch (e: Exception) {
                // Handle error
            }
        }
    }
}
