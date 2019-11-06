package com.example.oaapp.ui.auth

import androidx.lifecycle.ViewModel
import com.example.oaapp.repository.auth.AuthRepository
import javax.inject.Inject

class AuthViewModel
@Inject
constructor(
    val authRepository: AuthRepository
) : ViewModel() {

}