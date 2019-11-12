package com.example.oaapp.di

import com.example.oaapp.di.auth.AuthFragmentBuildersModule
import com.example.oaapp.di.auth.AuthModule
import com.example.oaapp.di.auth.AuthScope
import com.example.oaapp.di.auth.AuthViewModelModule
import com.example.oaapp.ui.auth.AuthActivity
import com.example.oaapp.ui.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuildersModule {

    @AuthScope
    @ContributesAndroidInjector(
        modules = [AuthModule::class, AuthFragmentBuildersModule::class, AuthViewModelModule::class]
    )
    abstract fun contributeAuthActivity(): AuthActivity

    @ContributesAndroidInjector
    abstract fun cotrinuteMainActivity(): MainActivity

}