package com.example.recyclerapp.bindable.view_holder

import android.view.View
import android.view.ViewGroup
import com.example.DoubleClick
import com.example.DoubleClickListener
import com.example.recyclerapp.R
import com.example.recyclerapp.UserModel
import com.example.recyclerapp.bindable.inflate
import com.example.recyclerapp.databinding.ItemUserBinding

class UserViewHolder(
    parent: ViewGroup,
    private val onClick: (item: UserModel) -> Unit,
    private val onLongClick: (itemId: String) -> Unit,
    private val onDoubleClick: (position: Int) -> Unit,
) : BaseUserViewHolder(parent.inflate(R.layout.item_user)) {

    private val binding = ItemUserBinding.bind(itemView)

    override fun bind(item: UserModel) {
        binding.textId.text = item.id
        binding.textName.text = item.name
        binding.root.setOnLongClickListener { onLongClick(item.id); true }
        binding.root.setOnClickListener(DoubleClick(object : DoubleClickListener {
            override fun onSingleClick(view: View?) {
                onClick(item)
            }

            override fun onDoubleClick(view: View?) {
                this@UserViewHolder.onDoubleClick(adapterPosition)
            }
        }))

    }
}