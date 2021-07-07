package com.example.jetpack.data.database.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.jetpack.data.model.PostDTO

@Dao
interface PostDao : BaseDao<PostDTO> {

    @Query("SELECT * FROM post")
    suspend fun all(): List<PostDTO>

    @Query("DELETE FROM post")
    suspend fun deleteAll()

}