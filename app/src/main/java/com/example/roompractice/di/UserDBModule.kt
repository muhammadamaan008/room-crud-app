package com.example.roompractice.di

import android.content.Context
import androidx.room.Room
import com.example.roompractice.database.AppDatabase
import com.example.roompractice.model.User
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class UserDBModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context) = Room.databaseBuilder(
                        context,
                        AppDatabase::class.java,
                        "userdb"
                    ).allowMainThreadQueries()
        .fallbackToDestructiveMigration()
        .build()

    @Provides
    @Singleton
    fun providesDao(database: AppDatabase) = database.userDao()

    @Provides
    fun provideEntity() = User()
}