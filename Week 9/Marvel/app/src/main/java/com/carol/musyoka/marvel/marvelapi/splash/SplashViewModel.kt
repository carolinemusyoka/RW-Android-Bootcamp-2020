package com.carol.musyoka.marvel.marvelapi.splash

import androidx.lifecycle.LiveData
import com.carol.musyoka.marvel.marvelapi.base.BaseViewModel
import com.carol.musyoka.marvel.marvelapi.ext.combinedObserveOnScheduleOn
import com.carol.musyoka.marvel.marvelapi.ext.toLiveData
import io.reactivex.subjects.PublishSubject
import javax.inject.Inject

class SplashViewModel @Inject constructor(
    private val splashTimer: ITimerSplash
) : BaseViewModel() {

    private val _viewState: PublishSubject<SplashViewState> = PublishSubject.create()
    var viewState: LiveData<SplashViewState> = _viewState.toLiveData()

     fun launchMainScreen() {
        splashTimer.timerForSplashScreen()
            .combinedObserveOnScheduleOn()
            .doOnComplete {
                _viewState.onNext(SplashViewState(isFinished = true))
            }.doOnSubscribe {
                _viewState.onNext(SplashViewState(isFinished = false))
            }
            .subscribe()
            .addToViewModelCompositeDisposable()
    }

    data class SplashViewState(val isFinished: Boolean)
}
