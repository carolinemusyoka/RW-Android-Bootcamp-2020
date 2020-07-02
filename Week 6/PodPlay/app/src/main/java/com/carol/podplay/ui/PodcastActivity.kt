package com.carol.podplay.ui

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import androidx.appcompat.widget.SearchView
import com.carol.podplay.R
import com.carol.podplay.repository.ItunesRepo
import com.carol.podplay.service.ItunesService
import kotlinx.android.synthetic.main.activity_podcast.*

class PodcastActivity : AppCompatActivity() {

    val TAG = javaClass.simpleName
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_podcast)
        
        val TAG = javaClass.simpleName
        val itunesService = ItunesService.instance
        val itunesRepo = ItunesRepo(itunesService)


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflator = menuInflater
        inflator.inflate(R.menu.menu_search,menu)

        val searchMenuItem = menu?.findItem(R.id.search_item)
        val searchView = searchMenuItem?.actionView as SearchView

        val searchManager = getSystemService(Context.SEARCH_SERVICE)
        as SearchManager

        searchView.setSearchableInfo(
            searchManager.getSearchableInfo(componentName)
        )
        return true

        setupToolbar()
    }
    private fun performSearch(term:String){
        val itunesService = ItunesService.instance
        val itunesRepo = ItunesRepo(itunesService)
        
        itunesRepo.searchByTerm(term){
            Log.i(TAG, "Results = $it")
        }
    }
    private fun handleIntent(intent: Intent){
       if (Intent.ACTION_SEARCH == intent.action) {
           val query = intent.getStringExtra(SearchManager.QUERY) ?:
                   return
           performSearch(query)
       }
       fun onNewIntent(intent: Intent) {
           super.onNewIntent(intent)
           setIntent(intent)
           handleIntent(intent)
       }
    }

    private fun setupToolbar(){
        setSupportActionBar(toolbar)
    }
}
