package com.example.recyclerapp.bindable.diff_util

import androidx.recyclerview.widget.DiffUtil
import com.example.recyclerapp.UserModel

class UserDiffUtil : DiffUtil.ItemCallback<UserModel>() {
    override fun areItemsTheSame(oldItem: UserModel, newItem: UserModel) = oldItem.id == newItem.id
    override fun areContentsTheSame(oldItem: UserModel, newItem: UserModel) = oldItem == newItem
}