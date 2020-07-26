package com.carol.musyoka.marvel.marvelapi.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.carol.musyoka.marvel.marvelapi.characters.CharactersViewModel
import com.carol.musyoka.marvel.marvelapi.splash.SplashViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
internal abstract class ViewModelModule {
    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(CharactersViewModel::class)
    internal abstract fun charactersViewModel(viewModel: CharactersViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SplashViewModel::class)
    internal abstract fun splashViewModel(viewModel: SplashViewModel): ViewModel

}