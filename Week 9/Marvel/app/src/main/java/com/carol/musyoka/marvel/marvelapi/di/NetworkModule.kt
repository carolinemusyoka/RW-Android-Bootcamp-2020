package com.carol.musyoka.marvel.marvelapi.di

import com.carol.musyoka.marvel.marvelapi.api.AppAPI
import com.carol.musyoka.marvel.marvelapi.api.MarvelAPI
import com.carol.musyoka.marvel.marvelapi.characters.CharactersRepoService
import com.carol.musyoka.marvel.marvelapi.characters.CharactersRepository
import dagger.Binds
import dagger.Module
import dagger.Reusable

@Module
internal abstract class NetworkModule {
    @Binds
    @Reusable
    internal abstract fun providesMarvelAPI(marvelAPI: MarvelAPI): AppAPI

    @Binds
    @Reusable
    internal abstract fun providesCharactersRepository(charactersRepository: CharactersRepository): CharactersRepoService
}