package com.example.jetpack.di

import android.content.Context
import com.example.jetpack.data.database.AppDatabase
import com.example.jetpack.data.database.dao.PostDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DBModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase =
        AppDatabase.getDatabase(context)

    @Singleton
    @Provides
    fun providePostDao(appDatabase: AppDatabase): PostDao =
        appDatabase.postDao()

}