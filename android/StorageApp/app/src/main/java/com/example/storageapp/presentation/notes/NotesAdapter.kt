package com.example.storageapp.presentation.notes

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.storageapp.domain.model.NoteModel

class NoteDiffUtils : DiffUtil.ItemCallback<NoteModel>() {
    override fun areItemsTheSame(oldItem: NoteModel, newItem: NoteModel): Boolean = oldItem.id == newItem.id
    override fun areContentsTheSame(oldItem: NoteModel, newItem: NoteModel): Boolean = oldItem == newItem
}

class NotesAdapter(
    private val onNoteClick: (NoteModel) -> Unit,
) : ListAdapter<NoteModel, NoteViewHolder>(NoteDiffUtils()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = NoteViewHolder(parent, onNoteClick)
    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) = holder.bind(getItem(position))
}

