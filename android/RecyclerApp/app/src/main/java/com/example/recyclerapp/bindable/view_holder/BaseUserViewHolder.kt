package com.example.recyclerapp.bindable.view_holder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerapp.UserModel
import com.example.recyclerapp.bindable.Bindable

abstract class BaseUserViewHolder(view: View) : RecyclerView.ViewHolder(view), Bindable<UserModel>