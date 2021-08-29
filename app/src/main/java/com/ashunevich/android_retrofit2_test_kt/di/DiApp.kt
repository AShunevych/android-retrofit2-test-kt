package com.ashunevich.android_retrofit2_test_kt.di

import android.app.Application

class DiApp :Application() {

    companion object{
        lateinit var component: AppComponent
    }

    override fun onCreate(){
        super.onCreate()
        component = getComponentBuilder().build(NetworkModule())
    }

    fun getComponentBuilder(): ComponentBuilder{
        return try {
            Class
                .forName("com.ashunevich.android_retrofit2_test_kt.di.AndroidTestBuilder")
                .newInstance() as ComponentBuilder
        } catch (e: Exception) {
            return ProdBuilder()
        }
    }
}