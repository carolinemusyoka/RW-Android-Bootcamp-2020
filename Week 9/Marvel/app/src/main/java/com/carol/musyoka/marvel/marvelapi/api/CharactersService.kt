package com.carol.musyoka.marvel.marvelapi.api

import com.carol.musyoka.marvel.marvelapi.characters.model.CharactersDTO
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface CharactersService {

    @GET("/v1/public/characters")
    fun getCharacters(
        @Query("apikey")
        apiKey: String,
        @Query("hash")
        hash: String,
        @Query("ts")
        timestamp: Long,
        @Query("offset")
        offset: Int
    ): Single<CharactersDTO>
}