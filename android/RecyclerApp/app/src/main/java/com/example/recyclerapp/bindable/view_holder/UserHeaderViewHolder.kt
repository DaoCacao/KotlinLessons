package com.example.recyclerapp.bindable.view_holder

import android.view.ViewGroup
import android.widget.Toast
import com.example.recyclerapp.R
import com.example.recyclerapp.UserModel
import com.example.recyclerapp.bindable.inflate
import com.example.recyclerapp.databinding.ItemUserHeaderBinding

class UserHeaderViewHolder(parent: ViewGroup) : BaseUserViewHolder(parent.inflate(R.layout.item_user_header)) {

    private val binding = ItemUserHeaderBinding.bind(itemView)

    override fun bind(item: UserModel) {
        binding.textName.text = item.name
        binding.root.setOnClickListener { Toast.makeText(itemView.context, "Header ${item.name}", Toast.LENGTH_SHORT).show() }
    }
}