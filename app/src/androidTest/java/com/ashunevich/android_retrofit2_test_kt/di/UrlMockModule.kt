package com.ashunevich.android_retrofit2_test_kt.di

import com.jakewharton.espresso.OkHttp3IdlingResource
import dagger.Module
import dagger.Provides
import io.fabric8.mockwebserver.DefaultMockServer
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import okhttp3.OkHttpClient
import javax.inject.Singleton

@Module
class UrlMockModule {


    @Provides
    @BaseUrl
    fun provideBaseUrl(mockServer: DefaultMockServer): String = runBlocking(Dispatchers.IO) {
        mockServer.url("/")
    }

    @Provides
    @Singleton
    fun provideHttpIdlingResource(client:OkHttpClient):OkHttp3IdlingResource {
        return OkHttp3IdlingResource.create("OkHttp", client)
    }

    @Singleton
    @Provides
    fun providesMockWebServer():DefaultMockServer = runBlocking ( Dispatchers.IO ){
        val createMockWebServer = DefaultMockServer()
        createMockWebServer.start()
        createMockWebServer
    }



}