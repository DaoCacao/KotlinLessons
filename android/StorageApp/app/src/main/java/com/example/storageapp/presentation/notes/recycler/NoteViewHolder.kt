package com.example.storageapp.presentation.notes.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.storageapp.R
import com.example.storageapp.databinding.ItemNoteBinding
import com.example.storageapp.domain.model.NoteModel

class NoteViewHolder(
    parent: ViewGroup,
    private val onClick: (NoteModel) -> Unit,
    private val onCheckBoxClick:(NoteModel) -> Unit,
    private val onLongNoteClick: (NoteModel) -> Unit

) : ViewHolder(parent.inflate(R.layout.item_note)),
    NoteViewHolderInterface {

    private val binding = ItemNoteBinding.bind(itemView)

    override fun bind(note: NoteModel) {
        binding.textTitle.text = note.title
        binding.root.setOnClickListener { onClick(note) }
        binding.root.setOnLongClickListener {
            onLongNoteClick(note)
            binding.selectionButton.isChecked=true
            return@setOnLongClickListener true
        }
        binding.selectionButton.setOnClickListener {
            onCheckBoxClick(note)
        }
    }

    override fun showCheckBox() {
        binding.selectionButton.isVisible = true
    }

    override fun uncheckAll() {
        binding.selectionButton.isChecked=false
    }
    override fun hideCheckBox() {
        binding.selectionButton.isVisible = false
    }

    override fun check(): Boolean {
        return binding.selectionButton.isChecked
    }
}


fun ViewGroup.inflate(@LayoutRes id: Int) = LayoutInflater.from(context).inflate(id, this, false)