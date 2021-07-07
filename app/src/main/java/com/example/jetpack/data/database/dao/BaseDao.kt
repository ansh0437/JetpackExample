package com.example.jetpack.data.database.dao

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Update

interface BaseDao<T> {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(vararg data: T)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(data: List<T>)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(vararg data: T)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(data: List<T>)

    @Delete
    suspend fun delete(vararg data: T)

    @Delete
    suspend fun delete(data: List<T>)

}