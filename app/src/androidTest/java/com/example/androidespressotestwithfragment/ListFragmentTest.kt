package com.example.androidespressotestwithfragment

import androidx.fragment.app.FragmentManager
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.rule.ActivityTestRule
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class ListFragmentTest {
    @Rule
    @JvmField
    val activityRule = ActivityTestRule<MainActivity>(MainActivity::class.java)
    lateinit var activity: MainActivity
    lateinit var fragmentManager: FragmentManager
    lateinit var listFragment: ListFragment

    @Before
    fun setUp() {
        activity = activityRule.activity
        fragmentManager = activity.supportFragmentManager
        listFragment =
            fragmentManager.findFragmentByTag(ListFragment::class.java.name) as ListFragment
    }

    @Test
    fun testListFragmentNotNull() {
        Assert.assertNotNull(listFragment)
    }

    @Test
    fun testInitialListLoaded() {
        Espresso.onView(ViewMatchers.withId(R.id.container)).check(
            ViewAssertions.matches(
                isDisplayed()
            )
        )
        activity.runOnUiThread {
            val listFragment =
                fragmentManager.findFragmentByTag(ListFragment::class.java.name)
            Assert.assertNotNull(listFragment)
        }
        Espresso.onView(ViewMatchers.withId(R.id.rvItemList)).check(
            ViewAssertions.matches(
                isDisplayed()
            )
        )
    }

    @Test
    fun testListHasAllItemLoaded() {
        val itemList = ItemDataUtil.getSampleData()
        Espresso.onView(ViewMatchers.withId(R.id.container)).check(
            ViewAssertions.matches(
                isDisplayed()
            )
        )
        activity.runOnUiThread {
            val listFragment =
                fragmentManager.findFragmentByTag(ListFragment::class.java.name)
            Assert.assertNotNull(listFragment)
        }
        Espresso.onView(ViewMatchers.withId(R.id.rvItemList))
            .perform(RecyclerViewActions.scrollToPosition<ItemViewHolder>(itemList.size - 1))
        Espresso.onView(ViewMatchers.withText("100")).check(ViewAssertions.matches(isDisplayed()))
    }

    @Test
    fun testItemClick() {
        Espresso.onView(ViewMatchers.withId(R.id.container)).check(
            ViewAssertions.matches(
                isDisplayed()
            )
        )
        activity.runOnUiThread {
            val listFragment =
                fragmentManager.findFragmentByTag(ListFragment::class.java.name)
            Assert.assertNotNull(listFragment)
        }
        Espresso.onView(ViewMatchers.withId(R.id.rvItemList))
            .perform(RecyclerViewActions.actionOnItemAtPosition<ItemViewHolder>(0, click()))
        activity.runOnUiThread {
            val detailsFragment =
                fragmentManager.findFragmentByTag(DetailsFragment::class.java.name)
            Assert.assertNotNull(detailsFragment)
        }
    }

    @Test
    fun testDetailScreenReceivedDataOnItemClick() {
        testItemClick()
        activity.runOnUiThread {
            val detailsFragment =
                fragmentManager.findFragmentByTag(DetailsFragment::class.java.name)
            Assert.assertNotNull(detailsFragment)
            val data = detailsFragment?.arguments?.getParcelable<ItemData>("data")
            Assert.assertNotNull(data)
        }
    }


    @Test
    fun testBackPress() {
        testItemClick()
        Espresso.pressBack()
        activity.runOnUiThread {
            val fragment =
                fragmentManager.findFragmentById(R.id.container)
            Assert.assertNotNull(fragment)
            Assert.assertTrue(fragment is ListFragment)
        }
    }


}