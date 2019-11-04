package com.example.oaapp.session

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import com.example.oaapp.persistence.AuthTokenDao

class SessionManager
constructor(
    val authTokenDao: AuthTokenDao,
    val application: Application
) {

}