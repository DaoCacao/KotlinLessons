package com.example.storageapp.presentation.notes

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.example.storageapp.databinding.ActivityNotesBinding
import com.example.storageapp.di.provideNotesPresenter
import com.example.storageapp.domain.model.NoteModel

class NotesActivity : AppCompatActivity(), Notes.View {

    private val binding by lazy { ActivityNotesBinding.inflate(layoutInflater) }

    private val adapter by lazy { NotesAdapter(onNoteClick = ::onNoteClick) }
    private val presenter: Notes.Presenter by lazy { provideNotesPresenter(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.recyclerNotes.adapter = adapter
        presenter.loadData()
    }

    override fun showLoading() {
        // changeState(State.Loading)
        binding.progressLoading.isVisible = true
        binding.textError.isVisible = false
        binding.recyclerNotes.isVisible = false
    }

    override fun showNotes(notes: List<NoteModel>) {
        // changeState(State.Loaded)
        binding.progressLoading.isVisible = false
        binding.textError.isVisible = false
        binding.recyclerNotes.isVisible = true
        adapter.submitList(notes)
    }


    override fun showError() {
        // changeState(State.Error)
        binding.progressLoading.isVisible = false
        binding.textError.isVisible = true
        binding.recyclerNotes.isVisible = false
    }

    private fun onNoteClick(note: NoteModel) = Unit

    private fun changeState(state: State) {
        binding.progressLoading.isVisible = state == State.Loading
        binding.textError.isVisible = state == State.Error
        binding.recyclerNotes.isVisible = state == State.Loaded
    }
}

enum class State {
    Loading,
    Loaded,
    Error
}
