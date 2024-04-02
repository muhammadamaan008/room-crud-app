package com.example.roompractice.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.example.roompractice.R
import com.example.roompractice.viewmodel.UserViewModel
import com.example.roompractice.databinding.FragmentUpdateBinding
import com.example.roompractice.model.User
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UpdateFragment : Fragment() {
    private lateinit var binding: FragmentUpdateBinding
    private val args: UpdateFragmentArgs by navArgs()
    private lateinit var userViewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_update, container, false
        )

        binding.apply {
            editText1.setText(args.currentUser.firstName)
            editText2.setText(args.currentUser.lastName)
            updateButton.setOnClickListener {
                updateBtnClicked(args.currentUser.uid)
            }
        }
        return binding.root
    }

    private fun updateBtnClicked(uid: Int) {
        userViewModel = ViewModelProvider(
            requireActivity(),

        )[UserViewModel::class.java]
        userViewModel.update(
            User(
                firstName = binding.editText1.text.toString(),
                lastName = binding.editText2.text.toString(),
                uid = uid
            )
        )
        println("Added")
    }
}