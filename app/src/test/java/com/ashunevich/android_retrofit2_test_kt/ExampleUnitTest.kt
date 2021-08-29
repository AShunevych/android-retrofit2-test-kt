package com.ashunevich.android_retrofit2_test_kt

import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    val mockList= mutableListOf<ItemJSON>()


    @Test
    fun addition_isCorrect() {
        for (i in 0..2) {
            mockList.add(ItemJSON("somefact", i ))
        }

        val itemJson: ItemJSON = mockList[1]
        println(itemJson.id)
        println(itemJson.title)
    }
}