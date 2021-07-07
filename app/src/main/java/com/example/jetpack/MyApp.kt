package com.example.jetpack

import android.app.Application
import android.content.Context
import com.facebook.stetho.Stetho
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MyApp : Application() {

    companion object {
        private lateinit var myApp: MyApp

        val appContext: Context
            get() = myApp.applicationContext
    }

    override fun onCreate() {
        super.onCreate()
        myApp = this
        initStetho()
        initFirebaseCrashlytics()
    }

    /**
     * For debugging & testing database and shared preferences
     */
    private fun initStetho() {
        if (BuildConfig.DEBUG) {
            Stetho.initializeWithDefaults(this)
        }
    }

    /**
     * Enabling crashlytics for reporting crashes on firebase
     */
    private fun initFirebaseCrashlytics() {
//        FirebaseApp.initializeApp(this)
//        FirebaseCrashlytics.getInstance().setCrashlyticsCollectionEnabled(true)
    }

}