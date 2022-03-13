package com.ashunevich.android_retrofit2_test_kt.recview



import androidx.recyclerview.widget.RecyclerView
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.rule.ActivityTestRule
import com.ashunevich.android_retrofit2_test_kt.MainActivity
import com.ashunevich.android_retrofit2_test_kt.R
import com.ashunevich.android_retrofit2_test_kt.di.DiApp
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4ClassRunner::class)
class RecyclerViewTest{

    @get:Rule
    val mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun clickAndGetRealResponse(){
        mainScreenRobot{
            tapIsDisplayed()
            tapGetButton()
        }
        Thread.sleep(2000)
        recViewTest{
            recViewIsDisplayed()
            recViewHasSomeText("hello8")
        }
    }

}