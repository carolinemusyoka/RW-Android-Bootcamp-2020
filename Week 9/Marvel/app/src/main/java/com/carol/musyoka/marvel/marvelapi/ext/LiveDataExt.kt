package com.carol.musyoka.marvel.marvelapi.ext

import androidx.lifecycle.LiveDataReactiveStreams
import io.reactivex.BackpressureStrategy
import io.reactivex.subjects.BehaviorSubject
import io.reactivex.subjects.PublishSubject

fun <T> BehaviorSubject<T>.toLiveData() = LiveDataReactiveStreams.fromPublisher(this.toFlowable(BackpressureStrategy.MISSING))
fun <T> PublishSubject<T>.toLiveData() = LiveDataReactiveStreams.fromPublisher(this.toFlowable(BackpressureStrategy.MISSING))