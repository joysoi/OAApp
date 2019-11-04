package com.example.oaapp.ui.auth

import androidx.lifecycle.ViewModel
import com.example.oaapp.repository.auth.AuthRepository

class AuthViewModel
constructor(
    val authRepository: AuthRepository
) : ViewModel() {

}