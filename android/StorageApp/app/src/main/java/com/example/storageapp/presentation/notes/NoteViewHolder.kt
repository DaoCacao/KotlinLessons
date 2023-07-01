package com.example.storageapp.presentation.notes

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.storageapp.R
import com.example.storageapp.databinding.ItemNoteBinding
import com.example.storageapp.domain.model.NoteModel

class NoteViewHolder(
    parent: ViewGroup,
    private val onClick: (NoteModel) -> Unit,
) : ViewHolder(parent.inflate(R.layout.item_note)) {

    private val binding = ItemNoteBinding.bind(itemView)

    fun bind(note: NoteModel) {
        binding.textTitle.text = note.title
        binding.root.setOnClickListener { onClick(note) }
    }
}

fun ViewGroup.inflate(@LayoutRes id: Int) = LayoutInflater.from(context).inflate(id, this, false)