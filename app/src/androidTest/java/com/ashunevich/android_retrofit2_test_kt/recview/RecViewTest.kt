package com.ashunevich.android_retrofit2_test_kt.recview

import android.view.View
import androidx.test.espresso.matcher.ViewMatchers.*
import com.ashunevich.android_retrofit2_test_kt.R
import org.hamcrest.Matcher


fun recViewTest(func: RecViewTest.() -> Unit) = RecViewTest().apply { func() }

class RecViewTest : BasicRobot() {
    private val recyclerView: Matcher<View> = withId(R.id.recView)

   fun recViewIsDisplayed() = viewIsDisplayed(recyclerView)

    fun recViewHasSomeText(string: String) = recViewHasText(string,recyclerView)

    fun sleepIdle() = sleep()
}