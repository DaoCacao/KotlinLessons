package com.example.storageapp.presentation.note

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.view.isVisible
import com.example.storageapp.R
import com.example.storageapp.databinding.ActivityNoteBinding
import com.example.storageapp.di.provideNotePresenter
import com.example.storageapp.presentation.notes.NotesActivity

class NoteActivity : AppCompatActivity(), NoteObject.View {

    private val binding by lazy { ActivityNoteBinding.inflate(layoutInflater) }
    private val presenter: NoteObject.Presenter by lazy { provideNotePresenter(this, this) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        presenter.getNote(intent.getStringExtra(NOTEID).toString())


        binding.ibtnGoBack.setOnClickListener {
            navigateToNotesActivity()
            presenter.updateNote(binding.Title.text.toString(), binding.Content.text.toString())
        }

        binding.fab.setOnClickListener {
            presenter.updateNote(binding.Title.text.toString(), binding.Content.text.toString() )
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.disposeGetNote()
    }

    companion object {
        fun navigateTo(thisContext: Context): Intent {
            return Intent(thisContext, NotesActivity::class.java)
        }

        const val NOTEID = "note id"
    }

    override fun showNote() {
        binding.progressBar.isVisible = false
        binding.Title.isVisible = true
        binding.Content.isVisible = true
    }

    override fun showError() {
        Toast.makeText(this, getString(R.string.somth_went_wrong), Toast.LENGTH_LONG).show()
        binding.progressBar.isVisible = false
    }

    override fun initializeNote(title: String, content: String) {
        showNote()
        binding.Title.setText(title)
        binding.Content.setText(content)
    }


    override fun showLoading() {
        binding.progressBar.isVisible = true
        binding.Title.isVisible = false
        binding.Content.isVisible = false
    }


    override fun navigateToNotesActivity() {
        startActivity(navigateTo(this))
    }
}