package com.ashunevich.android_retrofit2_test_kt.di


import com.ashunevich.android_retrofit2_test_kt.MainActivity
import dagger.Component
import javax.inject.Singleton


@Component(modules = [NetworkModule::class, UrlModule::class])
@Singleton
interface AppComponent {
    fun inject(mainActivity: MainActivity)
}