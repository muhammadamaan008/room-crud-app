package com.example.roompractice.model

import com.example.roompractice.database.UserDao
import javax.inject.Inject


class UserRepository @Inject constructor(private val userDao: UserDao) {

    fun getAllUsers() = userDao.getAll()

    suspend fun insert(user: User) = userDao.insert(user)

    suspend fun update(user: User) = userDao.update(user)

    suspend fun delete(user: User) = userDao.delete(user)
}