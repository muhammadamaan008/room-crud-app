package com.example.roompractice.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.roompractice.model.User
import com.example.roompractice.model.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(private val userRepository: UserRepository) : ViewModel() {
//    private val _usersLiveData = MutableLiveData<List<User>>()
//    val usersLiveData: LiveData<List<User>>
//        get() = _usersLiveData
//
//
//    fun getAllUsers() {
//        viewModelScope.launch(Dispatchers.IO) {
//            // Observe the LiveData returned by userRepository.getAllUsers()
//            userRepository.getAllUsers().observeForever { users ->
//                // Update _usersLiveData with the retrieved value
//                _usersLiveData.postValue(users)
//            }
//        }
//    }

    fun getAllUsers(): LiveData<List<User>> {
        return userRepository.getAllUsers()
    }

    fun insert(user: User) {
        viewModelScope.launch(Dispatchers.IO) {
            userRepository.insert(user)
        }
    }

    fun update(user: User) {
        viewModelScope.launch(Dispatchers.IO) {
            userRepository.update(user)
        }
    }

    fun delete(user: User) {
        viewModelScope.launch(Dispatchers.IO) {
            userRepository.delete(user)
        }
    }

}