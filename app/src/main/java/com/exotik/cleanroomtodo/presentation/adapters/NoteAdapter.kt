package com.exotik.cleanroomtodo.presentation.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.exotik.cleanroomtodo.R
import com.exotik.cleanroomtodo.databinding.NoteItemBinding
import com.exotik.cleanroomtodo.domain.models.DomainNoteModel

class NoteAdapter(
    private val onDel: (position: Int) -> Unit,
    private val onClickItemView: (note: DomainNoteModel) -> Unit
) : RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {
    private var noteList: List<DomainNoteModel> = emptyList()

    class NoteViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        private val binding = NoteItemBinding.bind(item)

        fun bind(note: DomainNoteModel, onDel: (position: Int) -> Unit) =
            with(binding) {
                titleItem.text = note.title
                delButton.setOnClickListener {
                    onDel.invoke(note.id)
                }
            }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.note_item, parent, false)
        return NoteViewHolder(view)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {

        holder.bind(note = noteList[position], onDel)
    }

    override fun getItemCount(): Int {
        return noteList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: MutableList<DomainNoteModel>) {
        noteList = list
        notifyDataSetChanged()
    }

    override fun onViewAttachedToWindow(holder: NoteViewHolder) {
        super.onViewAttachedToWindow(holder)
        holder.itemView.setOnClickListener {
            onClickItemView.invoke(noteList[holder.adapterPosition])
        }
    }

    override fun onViewDetachedFromWindow(holder: NoteViewHolder) {
        super.onViewDetachedFromWindow(holder)
        holder.itemView.setOnClickListener(null)
    }
}