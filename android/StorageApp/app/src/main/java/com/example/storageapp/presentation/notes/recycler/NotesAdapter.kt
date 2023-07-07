package com.example.storageapp.presentation.notes

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.storageapp.domain.model.NoteModel
import com.example.storageapp.presentation.notes.recycler.NoteViewHolder

class NoteDiffUtils : DiffUtil.ItemCallback<NoteModel>() {
    override fun areItemsTheSame(oldItem: NoteModel, newItem: NoteModel): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: NoteModel, newItem: NoteModel): Boolean =
        oldItem == newItem
}

class NotesAdapter(
    private val onNoteClick: (NoteModel) -> Unit,
    private val onLongNoteClick: (NoteModel) -> Unit
) : ListAdapter<NoteModel, NoteViewHolder>(NoteDiffUtils()) {

    private var deleteState = false
    private val checkSet = mutableSetOf<String>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        NoteViewHolder(parent, onNoteClick, onCheckBoxClick = ::onCheckBoxClick, onLongNoteClick)

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) = if (!deleteState) {
        holder.bind(getItem(position))
        holder.uncheckAll()
        holder.hideCheckBox()
    } else {
        holder.bind(getItem(position))
        holder.showCheckBox()
        if (holder.check()) {
            chooseCheckedNotes(position)
        } else {
            removePosition(getItem(position).id)
        }
    }


    private fun chooseCheckedNotes(position: Int) {
        checkSet.add(getItem(position).id)
    }

    private fun removePosition(id: String) {
        checkSet.remove(id)
    }

    fun clearCheckList() {
        checkSet.removeAll { true }
    }

    fun onCheckBoxClick(note: NoteModel) {
    }

    fun getCheckedPositions(): Set<String> {
        return checkSet
    }

    fun setDeleteState(deleteState: Boolean) {
        notifyDataSetChanged()
        this.deleteState = deleteState
    }

    companion object {
        const val INCREASE = "increase"
        const val DECREASE = "decrease"
    }
}

