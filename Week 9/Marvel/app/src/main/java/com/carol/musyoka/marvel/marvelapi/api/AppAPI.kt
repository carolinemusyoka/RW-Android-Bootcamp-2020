package com.carol.musyoka.marvel.marvelapi.api

import retrofit2.Retrofit

interface AppAPI {
    fun createRetrofitClient(): Retrofit
}