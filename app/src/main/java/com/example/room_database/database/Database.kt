package com.example.room_database.databaseimport

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.roomdatabase_pratice.database.dataModel
import com.example.roomdatabase_pratice.database.databaseDao

@Database(entities = [dataModel::class], version = 1)
abstract class MyDatabase : RoomDatabase() {

    abstract fun databasedao(): databaseDao

    companion object {
        const val database_name = "Room database"
        @Volatile
        private var INSTANCE: MyDatabase? = null

        fun getDatabase(context: Context): MyDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
//                    context.applicationContext,
                    context = context,
                    MyDatabase::class.java,
                    database_name
                ).build()

                INSTANCE = instance
                instance
            }
        }
    }
}
