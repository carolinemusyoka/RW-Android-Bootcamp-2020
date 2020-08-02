package com.carol.musyoka.marvel.marvelapi.splash

import io.reactivex.Completable

interface ITimerSplash {
    fun timerForSplashScreen(): Completable
}