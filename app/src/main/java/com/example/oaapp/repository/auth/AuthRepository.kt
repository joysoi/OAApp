package com.example.oaapp.repository.auth

import com.example.oaapp.api.auth.OpenApiAuthService
import com.example.oaapp.persistence.AccountPropertiesDao
import com.example.oaapp.persistence.AuthTokenDao
import com.example.oaapp.session.SessionManager

class AuthRepository
constructor(
    val authTokenDao: AuthTokenDao,
    val accountPropertiesDao: AccountPropertiesDao,
    val openApiAuthService: OpenApiAuthService,
    val sessionManager: SessionManager
) {

}