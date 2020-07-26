package com.carol.musyoka.marvel.marvelapi.splash

import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.carol.musyoka.marvel.R
import com.carol.musyoka.marvel.marvelapi.base.BaseActivity
import com.carol.musyoka.marvel.marvelapi.main.MainActivity
import javax.inject.Inject

class SplashActivity : BaseActivity() {

    init {
        layoutRes = R.layout.activity_splash
    }

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var viewModel: SplashViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getComponentActivity()
            .inject(this)

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(SplashViewModel::class.java)
        viewModel.launchMainScreen()
        viewModel.viewState.observe(this, Observer {
           if(it.isFinished) {
               launchMainActivity()
           }
        })
    }

    private fun launchMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}
