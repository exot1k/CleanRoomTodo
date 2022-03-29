package com.exotik.cleanroomtodo.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.exotik.cleanroomtodo.R
import com.exotik.cleanroomtodo.databinding.FragmentCreateBinding
import com.exotik.cleanroomtodo.viewmodel.NoteViewModel
import com.exotik.cleanroomtodo.viewmodel.NoteViewModelFactory


class NoteCreateFragment : Fragment() {

    lateinit var binding: FragmentCreateBinding
    private val noteViewModel: NoteViewModel by viewModels<NoteViewModel>() {
        NoteViewModelFactory(
            activity!!.applicationContext
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCreateBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        binding.addButton.setOnClickListener {
            noteViewModel.saveNote(
                title = binding.titleText.text.toString(),
                description = binding.descriptionText.text.toString()
            )
            findNavController().navigate(R.id.action_noteCreateFragment_to_startFragment)
        }
    }

}