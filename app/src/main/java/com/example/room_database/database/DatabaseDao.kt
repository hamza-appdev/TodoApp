package com.example.roomdatabase_pratice.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface databaseDao {
    //Add data
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addtask(dataModel: dataModel)

    //get Tasks
    @Query("SELECT * FROM My_Table")
    fun getAllTask(): LiveData<List<dataModel>>

    //Delete Tasks
    @Query("DELETE FROM My_Table WHERE id =:taskid")
    suspend fun deletetask(taskid:Int)

    //Edit Tasks
    @Query("UPDATE My_Table SET name=:taskname, description =:taskdes WHERE id =:taskid")
    suspend fun edittask(taskid:Int,taskname: String,taskdes: String)

}