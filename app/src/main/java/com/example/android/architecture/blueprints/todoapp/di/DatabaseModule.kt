package com.example.android.architecture.blueprints.todoapp.di

import android.app.Application
import androidx.room.Room
import com.example.android.architecture.blueprints.todoapp.feature.data.source.local.TasksDao
import com.example.android.architecture.blueprints.todoapp.feature.data.source.local.ToDoDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val databaseModule = module {
    fun provideDatabase(application: Application):ToDoDatabase{
        return Room.databaseBuilder(application.applicationContext, ToDoDatabase::class.java, "Tasks.db")
                .build()
    }

    fun provideTasksDao(database: ToDoDatabase):TasksDao{
        return database.taskDao()
    }

    single { provideDatabase(application = androidApplication()) }
    single { provideTasksDao(get()) }
}