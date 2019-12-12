package com.example.roomdata

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [useful::class], version = 1)
abstract class UsefulDatabase:RoomDatabase() {
    abstract fun usefulDao() : usefulDao

    companion object{
        //Singleton prevents multiple instances of the database
        //opening at the same time
        @Volatile var INSTANCE : UsefulDatabase? = null

        fun getDatabase(context: Context): UsefulDatabase{
            val tempDB = INSTANCE
            if(tempDB != null){
                return tempDB
            }
            //Create an instance of the datsbase
            synchronized(this){
                val instance = Room.databaseBuilder(context, UsefulDatabase::class.java, "useful_db").build()
                INSTANCE = instance
                return instance
            }
        }
    }
}