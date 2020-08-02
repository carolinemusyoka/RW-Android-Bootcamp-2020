package com.carol.musyoka.marvel.marvelapi.splash

import io.reactivex.Completable
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class TimerSplash @Inject constructor() : ITimerSplash {
    override fun timerForSplashScreen(): Completable = Completable.timer(TIMER_SPLASH, TimeUnit.SECONDS)

    companion object {
        private const val TIMER_SPLASH = 3L
    }
}