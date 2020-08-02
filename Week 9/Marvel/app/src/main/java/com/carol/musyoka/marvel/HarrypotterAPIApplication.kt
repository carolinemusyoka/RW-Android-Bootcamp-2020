package com.carol.musyoka.marvel

import android.app.Application
import com.carol.musyoka.marvel.marvelapi.api.NetworkOptions
import com.carol.musyoka.marvel.marvelapi.di.AppComponent
import com.carol.musyoka.marvel.marvelapi.utils.convertToMD5
import com.carol.musyoka.marvel.marvelapi.di.DaggerAppComponent

class HarrypotterAPIApplication : Application() {
    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        appComponent = DaggerAppComponent.factory().create(this, createNetworkOptions())
        appComponent.inject(this)
        super.onCreate()
        instance = this
    }

    @Synchronized fun getComponent(): AppComponent = appComponent

    private fun createNetworkOptions(): NetworkOptions =
        NetworkOptions(
            apiKey = BuildConfig.MARVEL_API_KEY,
            hash = createHash(),
            timeStamp = timeStamp(),
            offSet = 300)

    private fun createHash(): String {
        val apiKey = BuildConfig.MARVEL_API_KEY
        val privateKey = BuildConfig.MARVEL_PRIVATE_KEY
        val timeStamp = timeStamp()
        val hash = timeStamp.toString() + privateKey + apiKey

        return hash.convertToMD5()
    }

    private fun timeStamp(): Long = System.currentTimeMillis() / 1000

    companion object {
        lateinit var instance: HarrypotterAPIApplication
        private set
    }
}