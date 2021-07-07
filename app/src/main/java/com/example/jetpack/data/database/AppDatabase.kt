package com.example.jetpack.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.jetpack.R
import com.example.jetpack.data.database.dao.PostDao
import com.example.jetpack.data.model.PostDTO

@Database(
    entities = [PostDTO::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun postDao(): PostDao

    companion object {
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            if (INSTANCE == null) {
                synchronized(this) {
                    if (INSTANCE == null) {
                        INSTANCE =
                            Room.databaseBuilder(
                                context,
                                AppDatabase::class.java,
                                context.getString(R.string.database_name)
                            )
                                .allowMainThreadQueries()
                                .build()
                    }
                }
            }
            return INSTANCE as AppDatabase
        }
    }
}