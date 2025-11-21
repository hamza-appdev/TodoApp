package com.example.roomdatabase_pratice.database

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "My_Table")
data class dataModel(
    @PrimaryKey(autoGenerate = true)
    val id:Int =0,
    val name: String="",
    val description: String=""
)