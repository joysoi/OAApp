package com.example.oaapp.ui

import com.example.oaapp.session.SessionManager
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

abstract class BaseActivity: DaggerAppCompatActivity(){

    private val TAG: String = "AppDebug"


    @Inject
    lateinit var sessionManager: SessionManager
}
