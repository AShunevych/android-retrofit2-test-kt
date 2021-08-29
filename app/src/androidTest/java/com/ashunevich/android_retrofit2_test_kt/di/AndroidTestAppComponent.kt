package com.ashunevich.android_retrofit2_test_kt.di

import com.ashunevich.android_retrofit2_test_kt.DependencyTest
import dagger.Component
import javax.inject.Singleton

@Component(
    modules = [NetworkModule::class,UrlMockModule::class])
@Singleton
interface AndroidTestAppComponent:AppComponent {
    fun inject(exmapleDI:DependencyTest)
}