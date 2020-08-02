package com.carol.musyoka.marvel.marvelapi.di

import android.app.Application
import com.carol.musyoka.marvel.marvelapi.api.NetworkOptions
import com.carol.musyoka.marvel.marvelapi.characters.CharactersFragment
import com.carol.musyoka.marvel.marvelapi.imageloader.PicassoModule
import com.carol.musyoka.marvel.marvelapi.main.MainActivity
import com.carol.musyoka.marvel.marvelapi.splash.SplashActivity
import com.carol.musyoka.marvel.marvelapi.splash.SplashModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class,
    ViewModelModule::class,
    SplashModule::class,
    PicassoModule::class])
interface AppComponent {
    fun inject(app: Application)

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: Application,@BindsInstance networkOptions: NetworkOptions): AppComponent
    }

    fun inject(activity: SplashActivity)
    fun inject(activity: MainActivity)

    fun inject(fragment: CharactersFragment)
}