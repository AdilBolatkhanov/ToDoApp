
package com.example.android.architecture.blueprints.todoapp.feature.data.source

import androidx.lifecycle.LiveData
import com.example.android.architecture.blueprints.todoapp.feature.data.Result
import com.example.android.architecture.blueprints.todoapp.feature.data.Task

/**
 * Main entry point for accessing tasks data.
 */
interface TasksDataSource {

    fun observeTasks(): LiveData<Result<List<Task>>>

    suspend fun getTasks(): Result<List<Task>>

    suspend fun refreshTasks()

    fun observeTask(taskId: String): LiveData<Result<Task>>

    suspend fun getTask(taskId: String): Result<Task>

    suspend fun refreshTask(taskId: String)

    suspend fun saveTask(task: Task)

    suspend fun completeTask(task: Task)

    suspend fun completeTask(taskId: String)

    suspend fun activateTask(task: Task)

    suspend fun activateTask(taskId: String)

    suspend fun clearCompletedTasks()

    suspend fun deleteAllTasks()

    suspend fun deleteTask(taskId: String)
}
