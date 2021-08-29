package com.ashunevich.android_retrofit2_test_kt

import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.ashunevich.android_retrofit2_test_kt.di.*
import io.fabric8.mockwebserver.DefaultMockServer
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject
import androidx.test.internal.runner.junit4.statement.UiThreadStatement.runOnUiThread


@RunWith(AndroidJUnit4ClassRunner::class)
open class DependencyTest {


    val mockList = mutableListOf<ItemJSON>()
    var responseList = mutableListOf<ItemJSON>()

    @Inject lateinit var webApi: WebApi
    @Inject lateinit var mockWebServer: DefaultMockServer

    @get:Rule
    var activityRule: ActivityScenarioRule<MainActivity>
            = ActivityScenarioRule(MainActivity::class.java)

    @Before
    fun setup(){
        (DiApp.component as AndroidTestAppComponent).inject(this)
    }

    @Test
    fun listResponse(){
        for (i in 0..2) {
            mockList.add(ItemJSON("somefact"+i, i ))
        }

        mockWebServer.expect().withPath("/posts").
                    andReturn(200,mockList).always()

        val call: Call<MutableList<ItemJSON>> = webApi.getPosts()
        call.enqueue(object : Callback<MutableList<ItemJSON>> {
            override fun onResponse(call: Call<MutableList<ItemJSON>>,
                                    response: Response<MutableList<ItemJSON>>
                ) {
                    response.body()?.let { responseList.addAll(it) }
                }
                override fun onFailure(call: Call<MutableList<ItemJSON>>, t: Throwable) {
                    t.printStackTrace()
                }
            })


        Thread.sleep(2000)

        Log.d("RESPONSE_ITEM_AT_0",responseList[0].title.toString())
        Log.d("RESPONSE_ITEM_AT_1",responseList[1].title.toString())

       /* Log.d("RESPONSE_SIZE_TAG",responseList.size.toString())
        assertThat(responseList.size, equalTo(mockList.size))*/

    }

    @Test
    fun singleItemResponse(){
        val item = ItemJSON("SomeCoolFact",1)
        mockWebServer.expect().withPath("/item").andReturn(200,item).once()

        val call: Call<ItemJSON> = webApi.getSingleItem()
        call.enqueue(object : Callback<ItemJSON> {
            override fun onResponse(
                call: Call<ItemJSON>,
                response: Response<ItemJSON>
            ) {
                response.body()?.let { responseList.add(it) }
            }
            override fun onFailure(call: Call<ItemJSON>, t: Throwable) {
                t.printStackTrace()
            }
        })


        Log.d("RECEIVED_ITEM_TEXT",responseList[0].title.toString())
        Log.d("RECEIVED_ITEM_NUMBER",responseList[0].id.toString())

    }
}

