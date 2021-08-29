package com.ashunevich.android_retrofit2_test_kt.recview

import android.view.View
import androidx.test.espresso.matcher.ViewMatchers
import com.ashunevich.android_retrofit2_test_kt.R
import org.hamcrest.Matcher

fun mainScreenRobot(func: MainScreenTest.() -> Unit) = MainScreenTest().apply { func() }

class MainScreenTest : BasicRobot() {
    private val getButton: Matcher<View> = ViewMatchers.withId(R.id.getButton)

    fun tapIsDisplayed() = viewIsDisplayed(getButton)

    fun tapGetButton() = tapBy(getButton)

}