package com.ashunevich.android_retrofit2_test_kt.recview

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnItem
import androidx.test.espresso.contrib.RecyclerViewActions.scrollTo
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import org.hamcrest.Matcher

open class BasicRobot {

    fun tapBy(matcher: Matcher<View>): ViewInteraction = Espresso.onView(matcher)
        .perform(ViewActions.click())

    fun sleep(time: Long = 60000) = Thread.sleep(time)

    fun viewIsDisplayed(matcher: Matcher<View>): ViewInteraction? = Espresso.onView(matcher).check(
        ViewAssertions.matches(
            ViewMatchers.isDisplayed()
        )
    )

    fun recViewHasText(string:String,matcher: Matcher<View>) : ViewInteraction? =
        Espresso.onView(matcher)
            .perform(actionOnItem<RecyclerView.ViewHolder>
                (hasDescendant(withText(string)), ViewActions.scrollTo()))
}