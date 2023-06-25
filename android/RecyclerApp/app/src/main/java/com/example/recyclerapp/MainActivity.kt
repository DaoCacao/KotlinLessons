package com.example.recyclerapp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerapp.bindable.BindableAdapter
import com.example.recyclerapp.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private lateinit var alert: AlertDialog

    //    private val adapter = KlimovAdapter()
    private val adapter = BindableAdapter(
//        onUserClick = presenter::onUserClick,
        onUserClick = ::onUserClick,
        onUserLongClick = ::onUserLongClick
    )

    private var list = List(100) { UserModel("$it", "Name $it, ${Random.nextInt(100)}") }
        set(value) {
            field = value
            adapter.submitList(value)
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

//        binding.recyclerUsers.adapter = adapter

        binding.inputSelector.setOnClickListener { showPopup() }

//        adapter.setItems(list)
        adapter.submitList(list)
    }

    private fun onUserClick(user: UserModel) {
        alert.dismiss()
        Toast.makeText(this, "${user.name}", Toast.LENGTH_SHORT).show()
    }

    private fun onUserLongClick(userId: String) {
        list = list.filter { it.id != userId }
    }

    private fun showPopup() {
        alert = AlertDialog.Builder(this)
            .setView(RecyclerView(this).apply {
                adapter = this@MainActivity.adapter
                layoutManager = LinearLayoutManager(this@MainActivity)
            })
            .show()
    }
}