package com.example.roompractice.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.roompractice.R
import com.example.roompractice.viewmodel.UserViewModel
import com.example.roompractice.databinding.FragmentAddBinding
import com.example.roompractice.model.User
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class AddFragment : Fragment() {
    private lateinit var binding: FragmentAddBinding
    private lateinit var userViewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_add, container, false
        )

        binding.submitButton.setOnClickListener {
            submitBtnClicked()
        }


        return binding.root
    }

    private fun submitBtnClicked() {
        userViewModel = ViewModelProvider(
            requireActivity(),
        )[UserViewModel::class.java]
        userViewModel.insert(
            User(
                firstName = binding.editText1.text.toString(),
                lastName = binding.editText2.text.toString(),
                uid = 0
            )
        )
        println("Added")

    }

}