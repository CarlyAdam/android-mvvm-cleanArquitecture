package com.carlyadam.kotlin

import android.app.Application
import com.carlyadam.kotlin.data.api.model.ApiService
import com.carlyadam.kotlin.di.AppModule
import com.carlyadam.kotlin.repository.PersonRepository
import com.carlyadam.kotlin.utilities.NetworkConnectionInterceptor
import com.carlyadam.kotlin.viewmodel.PersonViewModelFactory
import org.acra.ACRA
import org.acra.ReportingInteractionMode
import org.acra.annotation.ReportsCrashes
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

@ReportsCrashes(mailTo = "jacincab1995@gmail.com",
    mode = ReportingInteractionMode.TOAST,
    resToastText = R.string.crash_text)
class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            // Android context
            androidContext(this@MyApplication)
            // modules
            modules(AppModule.myModule)
        }
        //ACRA.init(this)
    }


}