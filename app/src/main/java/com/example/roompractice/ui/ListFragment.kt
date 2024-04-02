package com.example.roompractice.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.roompractice.R
import com.example.roompractice.viewmodel.UserViewModel
import com.example.roompractice.databinding.FragmentListBinding
import com.example.roompractice.model.User
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListFragment : Fragment() {
    private lateinit var binding: FragmentListBinding
    private lateinit var userViewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_list, container, false
        )

        fetchData()

        binding.fab.setOnClickListener { addClicked() }

        return binding.root
    }

    private fun addClicked() {
        findNavController().navigate(R.id.listFragment_to_addFragment)
    }

    private fun fetchData() {
        userViewModel = ViewModelProvider(
            requireActivity(),
        )[UserViewModel::class.java]
        userViewModel.getAllUsers().observe(viewLifecycleOwner, Observer {
            setAdapter(it)
        })
    }

    private fun setAdapter(users: List<User>) {
        binding.apply {
            recyclerView.setLayoutManager(LinearLayoutManager(requireContext()))
            val adapter = UserAdapter(users)
            recyclerView.adapter = adapter
            recyclerView.setHasFixedSize(true)
        }
    }
}