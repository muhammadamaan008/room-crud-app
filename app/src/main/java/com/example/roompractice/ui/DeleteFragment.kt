package com.example.roompractice.ui

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import com.example.roompractice.R
import com.example.roompractice.viewmodel.UserViewModel
import com.example.roompractice.model.User
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DeleteFragment : DialogFragment() {
    private lateinit var item: User
    private lateinit var userViewModel: UserViewModel

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog =
        AlertDialog.Builder(requireContext())
            .setTitle("Delete")
            .setMessage(getString(R.string.message_text))
            .setPositiveButton(getString(R.string.ok_btn_text)) { _, _ ->
                    userViewModel = ViewModelProvider(
                        requireActivity(),
                    )[UserViewModel::class.java]
                    userViewModel.delete(item)
            }
            .setNegativeButton(getString(R.string.cancel_btn_text)) { _, _ ->
                dismiss()
            }
            .create()

    fun setUser(user: User) {
        item = user
    }
}