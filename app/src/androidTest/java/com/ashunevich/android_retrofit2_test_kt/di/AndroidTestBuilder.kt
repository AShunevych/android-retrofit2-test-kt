package com.ashunevich.android_retrofit2_test_kt.di



class AndroidTestBuilder : ComponentBuilder{
    override fun build(networkModule: NetworkModule): AppComponent {
        return DaggerAndroidTestAppComponent
            .builder().build()
}}