package com.example.room_database.viewmodel
import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.room_database.databaseimport.MyDatabase
import com.example.room_database.repository.databaseRepo
import com.example.roomdatabase_pratice.database.dataModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DatabaseViewModel(application: Application): AndroidViewModel(application) {
    val databaseRepository: databaseRepo
    val tasklist: LiveData<List<dataModel>>

    init {
        val databaseDao = MyDatabase.getDatabase(application).databasedao()
        databaseRepository = databaseRepo(databaseDao)
        tasklist = databaseRepository.allTask
    }

    fun addNewTask(databaseModel: dataModel) = viewModelScope.launch(Dispatchers.IO) {
        databaseRepository.addTask(databaseModel)
    }

    fun editTask(taskId:Int, taskName: String, taskDescription: String) = viewModelScope.launch(Dispatchers.IO) {
        databaseRepository.editTask(taskId,taskName,taskDescription)
    }

    fun removeTask(taskId:Int) = viewModelScope.launch(Dispatchers.IO) {
        databaseRepository.deleteTask(taskId)
    }

}
