package com.example.androidespressotestwithfragment

import androidx.fragment.app.FragmentManager
import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.rule.ActivityTestRule
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityTest {

    @Rule
    @JvmField
    val activityRule = ActivityTestRule<MainActivity>(MainActivity::class.java)
    lateinit var activity: MainActivity
    lateinit var fragmentManager: FragmentManager

    @Before
    fun setUp() {
        activity = activityRule.activity
        fragmentManager = activity.supportFragmentManager
    }

    @Test
    fun checkActivityContextIsNotNull() {
        Assert.assertNotNull(activity)
    }

    @Test
    fun testInitialFragmentLoaded() {
        Espresso.onView(withId(R.id.container)).check(matches(isDisplayed()))
        activity.runOnUiThread {
            val listFragment =
                fragmentManager.findFragmentByTag(ListFragment::class.java.name)
            Assert.assertNotNull(listFragment)
        }
    }
}