package com.carol.musyoka.marvel.marvelapi.characters

import com.carol.musyoka.marvel.marvelapi.api.AppAPI
import com.carol.musyoka.marvel.marvelapi.api.CharactersService
import com.carol.musyoka.marvel.marvelapi.api.NetworkOptions
import com.carol.musyoka.marvel.marvelapi.characters.model.CharactersDTO
import io.reactivex.Single
import javax.inject.Inject

class CharactersRepository @Inject constructor(
    private val marvelAPI: AppAPI,
    private val options: NetworkOptions
) : CharactersRepoService {

    override fun getCharacters(): Single<CharactersDTO> =
        marvelAPI.createRetrofitClient()
            .create(CharactersService::class.java)
            .getCharacters(apiKey = options.apiKey, hash = options.hash, offset = options.offSet, timestamp = options.timeStamp)
}