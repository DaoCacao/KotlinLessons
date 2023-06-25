package com.example.recyclerapp.bindable

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.recyclerapp.UserModel
import com.example.recyclerapp.bindable.diff_util.UserDiffUtil
import com.example.recyclerapp.bindable.view_holder.BaseUserViewHolder
import com.example.recyclerapp.bindable.view_holder.UserHeaderViewHolder
import com.example.recyclerapp.bindable.view_holder.UserViewHolder

class BindableAdapter(
    private val onUserClick: (user: UserModel) -> Unit,
    private val onUserLongClick: (userId: String) -> Unit,
) : ListAdapter<UserModel, BaseUserViewHolder>(UserDiffUtil()) {

    private val viewTypeHeader = 0
    private val viewTypeUser = 1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseUserViewHolder {
        return when (viewType) {
            0 -> UserHeaderViewHolder(parent)
            1 -> UserViewHolder(
                parent = parent,
                onClick = onUserClick,
                onLongClick = onUserLongClick,
                onDoubleClick = { position -> onUserClick(getItem(position)) },
            )
            else -> error("Invalid view type $viewType")
        }
    }

    override fun getItemViewType(position: Int) = if (position == 0) viewTypeHeader else viewTypeUser

    override fun onBindViewHolder(holder: BaseUserViewHolder, position: Int) = holder.bind(getItem(position))
}

