package com.example.rickandmorty.data.remote

import com.example.rickandmorty.data.model.CharacterDetail
import com.example.rickandmorty.data.model.CharacterResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface CharacterApi {
    @GET("character")
    suspend fun getCharacters(): CharacterResponse

    @GET("character/{id}")
    suspend fun getCharacterById(@Path("id") id: Int): CharacterDetail
}