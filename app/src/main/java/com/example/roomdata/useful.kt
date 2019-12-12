package com.example.roomdata

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "useful")
class useful (
    @PrimaryKey(autoGenerate = true) val id:Int,
    val name:String,
    val age:Int
)

