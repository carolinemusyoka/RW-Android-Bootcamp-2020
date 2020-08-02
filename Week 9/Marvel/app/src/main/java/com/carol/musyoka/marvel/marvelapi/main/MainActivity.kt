package com.carol.musyoka.marvel.marvelapi.main

import android.os.Bundle
import com.carol.musyoka.marvel.R
import com.carol.musyoka.marvel.marvelapi.base.BaseActivity
import com.carol.musyoka.marvel.marvelapi.characters.CharactersFragment

class MainActivity : BaseActivity() {

    init {
        layoutRes = R.layout.activity_main
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getComponentActivity()
            .inject(this)
        initView()
    }

    private fun initView() {
        supportFragmentManager.beginTransaction()
            .add(R.id.mainContainer, CharactersFragment.createCharactersFragment())
            .commit()
    }
}
