package com.example.movieappmad24

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.movieappmad24.navigation.*

class MainActivity : ComponentActivity() {

    override fun onCreate(state: Bundle?) {
        super.onCreate(state)
        displayLog("onCreate")
        setContent { Navigation() }
    }

    override fun onStart() {
        super.onStart()
        displayLog("onStart")
    }

    override fun onResume() {
        super.onResume()
        displayLog("onResume")
    }

    override fun onPause() {
        super.onPause()
        displayLog("onPause")
    }

    override fun onStop() {
        super.onStop()
        displayLog("onStop")
    }

    override fun onRestart() {
        super.onRestart()
        displayLog("onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        displayLog("onDestroy")
    }

    private fun displayLog(lifecycleEvent: String) {
        Log.i("MainScreen", "$lifecycleEvent called.")
    }
}