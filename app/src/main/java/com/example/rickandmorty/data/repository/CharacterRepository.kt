package com.example.rickandmorty.data.repository

import com.example.rickandmorty.data.model.CharacterDetail
import com.example.rickandmorty.data.remote.CharacterApi
import javax.inject.Inject

class CharacterRepository @Inject constructor(
    private val api: CharacterApi
) {
    suspend fun getCharacters() = api.getCharacters()
    suspend fun getCharacterById(id: Int) = api.getCharacterById(id)
}