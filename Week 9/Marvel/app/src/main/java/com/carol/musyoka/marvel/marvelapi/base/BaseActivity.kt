package com.carol.musyoka.marvel.marvelapi.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.carol.musyoka.marvel.HarrypotterAPIApplication

abstract class BaseActivity: AppCompatActivity() {

    protected fun getComponentActivity() = HarrypotterAPIApplication.instance.getComponent()
    protected var layoutRes: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutRes)
    }
}