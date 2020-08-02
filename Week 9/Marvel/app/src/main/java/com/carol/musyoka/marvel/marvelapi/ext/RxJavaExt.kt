package com.carol.musyoka.marvel.marvelapi.ext

import io.reactivex.Completable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

fun <T> Single<T>.combinedObserveOnScheduleOn() = subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
fun Completable.combinedObserveOnScheduleOn() = subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())