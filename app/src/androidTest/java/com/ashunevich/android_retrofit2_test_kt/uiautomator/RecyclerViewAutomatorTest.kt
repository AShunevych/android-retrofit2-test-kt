package com.ashunevich.android_retrofit2_test_kt.uiautomator

import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.junit.runner.RunWith
import androidx.test.platform.app.InstrumentationRegistry.getInstrumentation
import androidx.test.uiautomator.UiDevice
import androidx.test.uiautomator.UiObject
import org.junit.Test
import androidx.test.uiautomator.UiSelector
import androidx.test.uiautomator.UiScrollable
import com.ashunevich.android_retrofit2_test_kt.DependencyTest
import com.ashunevich.android_retrofit2_test_kt.ItemJSON
import org.junit.Before

private const val buttonText = "GET"
private const val buttonClassName = "android.widget.Button"
private const val recyclerViewClassName = "androidx.recyclerview.widget.RecyclerView"
private const val textViewClassName = "android.widget.TextView"

@RunWith(AndroidJUnit4ClassRunner::class)
class RecyclerViewAutomatorTest : DependencyTest() {

    private lateinit var mDevice: UiDevice

    @Before
    fun start() {
        mDevice = UiDevice.getInstance(getInstrumentation())

        for (i in 0..8) {
            mockList.add(ItemJSON("some fact$i", i))
        }

        mockWebServer.expect().withPath("/posts").andReturn(200, mockList).always()
    }

    @Test
    fun testRecView() {
        val getButton: UiObject = mDevice.findObject(
            UiSelector().text(buttonText).className(buttonClassName)
        )
        getButton.click()

        val parent = UiScrollable(
            UiSelector().className
                (recyclerViewClassName)
        )

        parent.getChildByText(
            UiSelector().className(textViewClassName),
            "some fact8", true
        )
    }
}