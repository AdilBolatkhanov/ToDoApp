
package com.example.android.architecture.blueprints.todoapp.feature

import android.app.Application
import com.example.android.architecture.blueprints.todoapp.BuildConfig
import com.example.android.architecture.blueprints.todoapp.di.databaseModule
import com.example.android.architecture.blueprints.todoapp.di.mainModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import timber.log.Timber
import timber.log.Timber.DebugTree

/**
 * An application that lazily provides a repository. Note that this Service Locator pattern is
 * used to simplify the sample. Consider a Dependency Injection framework.
 *
 * Also, sets up Timber in the DEBUG BuildConfig. Read Timber's documentation for production setups.
 */
class TodoApplication : Application() {


    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@TodoApplication)
            modules(databaseModule, mainModule)
        }
        if (BuildConfig.DEBUG) Timber.plant(DebugTree())
    }
}
