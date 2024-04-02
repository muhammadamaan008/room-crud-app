package com.example.roompractice

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.roompractice.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setSupportActionBar(binding.myToolbar)
        lifecycleScope.launch {
            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
                val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
                insets
            }
        }
        setAppBar()


//        lifecycleScope.launch(Dispatchers.IO) {
//            val db = AppDatabase.getInstance(this@MainActivity)
//            val userDao = db.userDao()
//            userDao.insert(User(firstName = "Amaan", lastName = "Sharafat", uid = 0))
//            val users: List<User> = userDao.getAll()
//            users.forEach(){ user ->
//                println(user.firstName)
//            }


//            val temp = userDao.findByName("Amaan","Sharafat")
//            println(temp)

//            val temp2 = User(uid = 2,firstName = "Bilal", lastName = "Sharafat")
//            userDao.update(temp2)

//            userDao.delete(User(firstName = "Amaan", lastName = "Sharafat", uid = 1))
//        }


    }


    private fun setAppBar(){
        val navHostFragment =
            supportFragmentManager.findFragmentById(binding.fragmentContainerView.id) as NavHostFragment
        val navController = navHostFragment.navController
        setupActionBarWithNavController(navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        return findNavController(binding.fragmentContainerView.id).navigateUp() || super.onSupportNavigateUp()
    }
}