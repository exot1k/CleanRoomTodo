package com.exotik.cleanroomtodo.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.exotik.cleanroomtodo.R
import com.exotik.cleanroomtodo.databinding.FragmentStartBinding
import com.exotik.cleanroomtodo.domain.models.DomainNoteModel
import com.exotik.cleanroomtodo.presentation.adapters.NoteAdapter
import com.exotik.cleanroomtodo.viewmodel.NoteViewModel
import com.exotik.cleanroomtodo.viewmodel.NoteViewModelFactory
import java.io.Serializable

class StartFragment : Fragment() {

    lateinit var binding: FragmentStartBinding
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: NoteAdapter

    private val noteViewModel: NoteViewModel by viewModels<NoteViewModel>() {
        NoteViewModelFactory(
            activity!!.applicationContext
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStartBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        recyclerView = binding.notesRV
        adapter = NoteAdapter(onDel = deleteNote, onClickItemView = navToDetail)

        recyclerView.adapter = adapter

        noteViewModel.noteLiveTest.observe(this, {
            adapter.setList(it.asReversed())
        })

        binding.addNoteButton.setOnClickListener {
            findNavController().navigate(R.id.action_startFragment_to_noteCreateFragment)
        }
    }

    private val navToDetail: (DomainNoteModel) -> Unit = {
        val noteBundle = Bundle()

        noteBundle.putSerializable(
            "note",
            it
        )

        findNavController()
            .navigate(
                R.id.action_startFragment_to_noteViewFragment, noteBundle
            )
    }

    private val deleteNote: (Int) -> Unit = {
        noteViewModel.delNote(it)
    }


}