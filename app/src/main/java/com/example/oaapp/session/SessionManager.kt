package com.example.oaapp.session

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import com.example.oaapp.persistence.AuthTokenDao
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SessionManager
@Inject
constructor(
    val authTokenDao: AuthTokenDao,
    val application: Application
) {

}