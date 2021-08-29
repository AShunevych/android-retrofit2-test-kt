package com.ashunevich.android_retrofit2_test_kt.di

class ProdBuilder: ComponentBuilder {
    override fun build(networkModule: NetworkModule): AppComponent {
        return  DaggerAppComponent.builder().build()
    }
}