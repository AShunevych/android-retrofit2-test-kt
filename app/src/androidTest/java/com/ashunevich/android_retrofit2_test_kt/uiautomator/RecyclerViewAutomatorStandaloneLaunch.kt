package com.ashunevich.android_retrofit2_test_kt.uiautomator

import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.UiDevice
import androidx.test.uiautomator.UiObject
import androidx.test.uiautomator.UiScrollable
import androidx.test.uiautomator.UiSelector
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

private const val buttonText = "GET"
private const val buttonClassName = "android.widget.Button"
private const val recyclerViewClassName = "androidx.recyclerview.widget.RecyclerView"
private const val textViewClassName = "android.widget.TextView"

@RunWith(AndroidJUnit4ClassRunner::class)
class RecyclerViewAutomatorStandalone {
    private var mDevice: UiDevice? = null


    @Before
    fun start(){
        mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())
    }

    @Test
    fun testRecView() {
        val launchAPP = mDevice?.findObject(UiSelector().description("android-retrofit2-test-kt"))
        launchAPP?.clickAndWaitForNewWindow()

        val getButton: UiObject = mDevice!!.findObject(
            UiSelector().text(buttonText).className(buttonClassName)
        )
        getButton.click()

        //
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