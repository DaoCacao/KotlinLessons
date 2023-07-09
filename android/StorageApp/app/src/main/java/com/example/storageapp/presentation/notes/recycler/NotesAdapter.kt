package com.example.storageapp.presentation.notes

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.storageapp.presentation.model.NoteHolderModel
import com.example.storageapp.presentation.notes.recycler.NoteViewHolder

class NoteDiffUtils : DiffUtil.ItemCallback<NoteHolderModel>() {
    override fun areItemsTheSame(oldItem: NoteHolderModel, newItem: NoteHolderModel): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: NoteHolderModel, newItem: NoteHolderModel): Boolean =
        oldItem == newItem
}

class NotesAdapter(
    private val onNoteClick: (NoteHolderModel) -> Unit,
    private val onLongNoteClick: (NoteHolderModel) -> Unit,
    private val onCheckBoxClick: (NoteHolderModel) -> Unit
) : ListAdapter<NoteHolderModel, NoteViewHolder>(NoteDiffUtils()) {
    private var deleteState = false


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        NoteViewHolder(parent, onNoteClick, onCheckBoxClick, onLongNoteClick, this)

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) = if (!deleteState) {
        holder.bind(getItem(position))
        holder.hideCheckBox()
        holder.check(false)
    } else {
        holder.bind(getItem(position))
        holder.showCheckBox()
    }


    fun setDeleteState(deleteState: Boolean) {
        this.deleteState = deleteState
        notifyDataSetChanged()
    }
}

