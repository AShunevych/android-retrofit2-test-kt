package com.ashunevich.android_retrofit2_test_kt.di

import android.util.Log
import androidx.annotation.NonNull
import dagger.Module
import dagger.Provides
import io.fabric8.mockwebserver.DefaultMockServer
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import javax.inject.Singleton

@Module
class UrlMockModule {


    @Provides
    @BaseUrl
    fun provideBaseUrl(mockServer: DefaultMockServer): String = runBlocking(Dispatchers.IO) {
        mockServer.url("/")
    }

    @Singleton
    @Provides
    fun providesMockWebServer():DefaultMockServer = runBlocking ( Dispatchers.IO ){
        val createMockWebServer = DefaultMockServer()
        createMockWebServer.start()
        createMockWebServer
    }



}