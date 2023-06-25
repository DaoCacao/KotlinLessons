package com.example.recyclerapp.bindable

interface Bindable<T> {
    fun bind(item: T)
}