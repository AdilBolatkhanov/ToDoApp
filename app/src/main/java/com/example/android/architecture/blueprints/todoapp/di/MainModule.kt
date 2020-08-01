package com.example.android.architecture.blueprints.todoapp.di

import androidx.lifecycle.SavedStateHandle
import com.example.android.architecture.blueprints.todoapp.feature.presentation.addedittask.AddEditTaskViewModel
import com.example.android.architecture.blueprints.todoapp.feature.data.source.remote.FakeTasksRemoteDataSource
import com.example.android.architecture.blueprints.todoapp.feature.data.source.DefaultTasksRepository
import com.example.android.architecture.blueprints.todoapp.feature.data.source.TasksDataSource
import com.example.android.architecture.blueprints.todoapp.feature.domain.TasksRepository
import com.example.android.architecture.blueprints.todoapp.feature.data.source.local.TasksLocalDataSource
import com.example.android.architecture.blueprints.todoapp.feature.presentation.statistics.StatisticsViewModel
import com.example.android.architecture.blueprints.todoapp.feature.presentation.taskdetail.TaskDetailViewModel
import com.example.android.architecture.blueprints.todoapp.feature.presentation.tasks.TasksViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val mainModule = module {
    single<TasksDataSource>{ TasksLocalDataSource(tasksDao = get())}

    single<TasksRepository>{
        DefaultTasksRepository(tasksRemoteDataSource = FakeTasksRemoteDataSource,
                tasksLocalDataSource = get())
    }

    viewModel { (handle: SavedStateHandle) -> TasksViewModel(handle, tasksRepository = get()) }

    viewModel { TaskDetailViewModel(tasksRepository = get()) }

    viewModel { StatisticsViewModel(tasksRepository = get()) }

    viewModel { AddEditTaskViewModel(tasksRepository = get()) }
}