package com.ashunevich.android_retrofit2_test_kt.recview

import android.content.Context
import android.content.Intent
import androidx.test.core.app.ApplicationProvider
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

private const val BASIC_SAMPLE_PACKAGE = "com.ashunevich.android_retrofit2_test_kt.recview"
private const val LAUNCH_TIMEOUT = 5000L
private const val buttonText = "GET"
private const val buttonClassName = "android.widget.Button"
private const val recyclerViewClassName = "androidx.recyclerview.widget.RecyclerView"
private const val textViewClassName = "android.widget.TextView"

@RunWith(AndroidJUnit4ClassRunner::class)
class RecyclerViewAutomator {

    private lateinit var device: UiDevice

    @Before
    fun start(){
        device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())

        val context = ApplicationProvider.getApplicationContext<Context>()
        val intent = context.packageManager.getLaunchIntentForPackage(
            BASIC_SAMPLE_PACKAGE)?.apply {
            // Clear out any previous instances
            addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
        }
        context.startActivity(intent)
    }

    @Test
    fun clickAndGetRealResponse(){

        device.wait(
            Until.hasObject(By.pkg(BASIC_SAMPLE_PACKAGE).depth(0)),
            LAUNCH_TIMEOUT
        )

        val getButton: UiObject = device.findObject(
            UiSelector().text(buttonText).className(buttonClassName)
        )
        getButton.click()
        Thread.sleep(400)

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