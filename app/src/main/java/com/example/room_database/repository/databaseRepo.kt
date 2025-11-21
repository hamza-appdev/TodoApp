package com.example.room_database.repository

import androidx.lifecycle.LiveData
import com.example.roomdatabase_pratice.database.dataModel
import com.example.roomdatabase_pratice.database.databaseDao

class databaseRepo(val databaseDao: databaseDao) {
    val  allTask: LiveData<List<dataModel>> = databaseDao.getAllTask()

    suspend fun addTask(dataModel: dataModel) = databaseDao.addtask(dataModel = dataModel)

    suspend fun editTask(taskid:Int,taskname: String,taskdes: String)= databaseDao.edittask(taskid,taskname, taskdes)

    suspend fun deleteTask(taskid:Int)= databaseDao.deletetask(taskid)

}