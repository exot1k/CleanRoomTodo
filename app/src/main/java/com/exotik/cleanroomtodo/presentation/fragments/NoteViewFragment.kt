package com.exotik.cleanroomtodo.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.exotik.cleanroomtodo.R
import com.exotik.cleanroomtodo.databinding.FragmentNoteViewBinding
import com.exotik.cleanroomtodo.domain.models.DomainNoteModel


class NoteViewFragment : Fragment() {
    lateinit var binding: FragmentNoteViewBinding
    lateinit var currNote: DomainNoteModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentNoteViewBinding.inflate(layoutInflater, container, false)
        currNote = arguments?.getSerializable("note") as DomainNoteModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        binding.descriptionText.text = currNote.descriptor
        binding.titleText.text = currNote.title
        binding.backButton.setOnClickListener {
            findNavController().navigate(R.id.action_noteViewFragment_to_startFragment)
        }
    }

}