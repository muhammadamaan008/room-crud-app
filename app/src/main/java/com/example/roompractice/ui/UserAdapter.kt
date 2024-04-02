package com.example.roompractice.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.roompractice.databinding.UserDataViewBinding
import androidx.appcompat.app.AppCompatActivity
import com.example.roompractice.R
import com.example.roompractice.model.User

class UserAdapter(private val dataList: List<User>): RecyclerView.Adapter<UserAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context),
            R.layout.user_data_view,parent,false ))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemData = dataList[position]
        holder.bind(itemData)
    }

    override fun getItemCount() = dataList.size

    inner class ViewHolder(private val binding: UserDataViewBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: User){
            binding.apply {
                model = item
                userData.apply {
                    setOnLongClickListener {
                        val deleteUserDialog = DeleteFragment()
                        deleteUserDialog.setUser(item)
                        deleteUserDialog.show((it.context as AppCompatActivity).supportFragmentManager,null)
                        true
                    }
                    setOnClickListener {
                        val action = ListFragmentDirections.actionListFragmentToUpdateFragment(item)
                        it.findNavController().navigate(action)
                    }
                }
            }
        }
    }
}