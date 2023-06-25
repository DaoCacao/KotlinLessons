package com.example.recyclerapp.klimov

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerapp.R
import com.example.recyclerapp.UserModel
import com.example.recyclerapp.databinding.ItemUserBinding
import com.example.recyclerapp.databinding.ItemUserHeaderBinding

class KlimovAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val viewTypeHeader = 0
    private val viewTypeUser = 1

    private val list: MutableList<UserModel> = mutableListOf()

    // вызывается ТОЛЬКО при создании вью холдера
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            0 -> UserHeaderViewHolder(parent)
            1 -> UserViewHolder(parent)
            else -> error("Invalid view type $viewType")
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == 0) viewTypeHeader else viewTypeUser
    }

    override fun getItemCount(): Int = list.size

    // вызывается каждый раз когда нужно отобразить вью холдер
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is UserViewHolder -> holder.bind(list[position])
            is UserHeaderViewHolder -> holder.bind(list[position])
        }
    }

    fun setItems(list: List<UserModel>) {
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }
}

private class UserViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(parent.inflate(R.layout.item_user)) {
    private val binding = ItemUserBinding.bind(itemView)

    fun bind(item: UserModel) {
        binding.textId.text = item.id
        binding.textName.text = item.name
    }
}

private class UserHeaderViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(parent.inflate(R.layout.item_user_header)) {
    val binding = ItemUserHeaderBinding.bind(itemView)


    fun bind(item: UserModel) {
        binding.textName.text = item.name
    }
}

private fun ViewGroup.inflate(@LayoutRes layoutId: Int): View = LayoutInflater.from(context).inflate(layoutId, this, false)