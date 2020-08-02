package com.carol.musyoka.marvel.marvelapi.characters

import com.carol.musyoka.marvel.marvelapi.characters.model.CharactersDTO
import io.reactivex.Single

interface CharactersRepoService {
    fun getCharacters(): Single<CharactersDTO>
}