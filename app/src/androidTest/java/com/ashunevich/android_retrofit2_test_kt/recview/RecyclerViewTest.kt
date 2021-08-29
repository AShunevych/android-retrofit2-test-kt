package com.ashunevich.android_retrofit2_test_kt.recview


import android.os.CountDownTimer
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.ashunevich.android_retrofit2_test_kt.MainActivity
import com.ashunevich.android_retrofit2_test_kt.R
import com.ashunevich.android_retrofit2_test_kt.di.DiApp
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4ClassRunner::class)
class RecyclerViewTest{
    var recyclerView: RecyclerView? = null

    @get:Rule
    var activityRule: ActivityScenarioRule<MainActivity>
            = ActivityScenarioRule(MainActivity::class.java)


    @Before
    fun setup(){
        activityRule.scenario.onActivity { activity: MainActivity ->
            recyclerView = activity.findViewById(R.id.recView)
        }
    }

    @Test
    fun clickAndGetRealResponse(){
        mainScreenRobot{
            tapIsDisplayed()
            tapGetButton()
        }

        val timer = object: CountDownTimer(60000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                Log.d("ADAPTER_ITEM_COUNT", recyclerView?.adapter?.itemCount.toString())
            }
            override fun onFinish() {
                recViewTest{
                    recViewIsDisplayed()
                    recViewHasSomeText("hello8")
                }
            }
        }
        timer.start()
    }

}