package com.ashunevich.android_retrofit2_test_kt.di

import dagger.Module
import dagger.Provides

@Module
class UrlModule {
    @Provides
    @BaseUrl
    fun provideBaseUrl(): String = "https://my-json-server.typicode.com/AShunevych/retrofitJSONTest/"
}