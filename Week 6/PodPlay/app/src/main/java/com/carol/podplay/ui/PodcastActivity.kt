package com.carol.podplay.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.carol.podplay.R
import com.carol.podplay.repository.ItunesRepo
import com.carol.podplay.service.ItunesService

class PodcastActivity : AppCompatActivity() {
    

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_podcast)
        
        val TAG = javaClass.simpleName
        val itunesService = ItunesService.instance
        val itunesRepo = ItunesRepo(itunesService)

        itunesRepo.searchByTerm("Android Developer"){
            Log.i(TAG,"Results = $it")
        }
    }
}
