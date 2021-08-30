package com.ashunevich.android_retrofit2_test_kt.recview


import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.ashunevich.android_retrofit2_test_kt.DependencyTest
import com.ashunevich.android_retrofit2_test_kt.ItemJSON
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4ClassRunner::class)
class RecyclerViewTest : DependencyTest() {

    @Test
    fun clickAndGetResponce() {
        for (i in 0..8) {
            mockList.add(ItemJSON("somefact" + i, i))
        }

        mockWebServer.expect().withPath("/posts").andReturn(200, mockList).always()

        mainScreenRobot {
            tapIsDisplayed()
            tapGetButton()
        }
        recViewTest {
            recViewIsDisplayed()
            recViewHasSomeText("somefact8")
        }
    }
}