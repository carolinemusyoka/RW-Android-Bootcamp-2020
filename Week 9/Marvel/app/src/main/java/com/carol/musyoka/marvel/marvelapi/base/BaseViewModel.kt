package com.carol.musyoka.marvel.marvelapi.base

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

open class BaseViewModel : ViewModel() {
    private val compositeDisposable = CompositeDisposable()

    override fun onCleared() {
        compositeDisposable.clear()
        compositeDisposable.dispose()
        super.onCleared()
    }

    protected fun Disposable.addToViewModelCompositeDisposable(): Disposable {
        compositeDisposable.add(this)
        return this
    }
}