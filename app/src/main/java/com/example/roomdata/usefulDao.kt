package com.example.roomdata

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface usefulDao {
    @Insert
    suspend fun insertUseful(useful: useful)

    @Query("SELECT * FROM useful")
    suspend fun getAllUseful(): LiveData<List<useful>>

    @Query("SELECT * FROM useful WHERE id = :useful_id")
    suspend fun getAUseful(useful_id: Int)

    @Update
    suspend fun updateUseful(useful: useful)

    @Delete
    suspend fun deleteUseful(useful: useful)
}