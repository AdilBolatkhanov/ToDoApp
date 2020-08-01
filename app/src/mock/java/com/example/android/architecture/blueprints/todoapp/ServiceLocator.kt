
package com.example.android.architecture.blueprints.todoapp

import androidx.annotation.VisibleForTesting
import com.example.android.architecture.blueprints.todoapp.feature.data.FakeTasksRemoteDataSource
import com.example.android.architecture.blueprints.todoapp.feature.domain.TasksRepository
import com.example.android.architecture.blueprints.todoapp.feature.data.source.local.ToDoDatabase
import kotlinx.coroutines.runBlocking
import org.koin.core.KoinComponent
import org.koin.core.inject



/**
 * A Service Locator for the [TasksRepository]. This is the mock version, with a
 * [FakeTasksRemoteDataSource].
 */
object ServiceLocator :KoinComponent{

    private val lock = Any()
    private val database: ToDoDatabase by inject()

    @VisibleForTesting
    fun resetRepository() {
        synchronized(lock) {
            runBlocking {
                FakeTasksRemoteDataSource.deleteAllTasks()
            }
            // Clear all data to avoid test pollution.
            database?.apply {
                clearAllTables()
                close()
            }
        }
    }
}
