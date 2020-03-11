package com.example.androidespressotestwithfragment

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {

    val TAG = MainActivity::class.java.simpleName
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initTest()
        Log.d(TAG, "ON CREATE")
    }

    private fun initTest() {
        replaceFragment(ListFragment(), false)
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "ON Start")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "ON Resume")
    }

    override fun onPostResume() {
        super.onPostResume()
        Log.d(TAG, "ON Post Resume")
    }


    override fun onStop() {
        super.onStop()
        Log.d(TAG, "ON Stop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "ON Destroy")
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        Log.d(TAG, "onActivityResult:$requestCode")
    }

    private fun init() {
        val listFragment = ListFragment()
        replaceFragment(listFragment, false)
    }

    fun replaceFragment(fragment: Fragment, isAddToBackStack: Boolean = true) {
        supportFragmentManager.beginTransaction().apply {
            if (isAddToBackStack) {
                addToBackStack(fragment::class.java.name)
            }
            replace(R.id.container, fragment, fragment::class.java.name)
        }.commitAllowingStateLoss()
    }
}
