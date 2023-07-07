package com.example.storageapp.presentation.notes

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.example.storageapp.R
import com.example.storageapp.databinding.ActivityNotesBinding

import com.example.storageapp.di.provideNotesPresenter
import com.example.storageapp.domain.model.NoteModel
import com.example.storageapp.presentation.note.NoteActivity


class NotesActivity : AppCompatActivity(), NotesObject.View {
    private lateinit var filters: Filters
    private val binding by lazy { ActivityNotesBinding.inflate(layoutInflater) }
    private val adapter by lazy {
        NotesAdapter(
            onNoteClick = ::onNoteClick,
            onLongNoteClick = ::onLongNoteClick
        )
    }
    private val presenter: NotesObject.Presenter by lazy { provideNotesPresenter(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        filters = Filters()
        binding.recyclerNotes.adapter = adapter
        presenter.loadData()

        binding.toolBar.inflateMenu(R.menu.notes_menu)

        binding.toolBar.setOnMenuItemClickListener {
            when (it) {
                binding.toolBar.menu.findItem(R.id.menu_delete) -> {
                    setDeleteState()
                    true
                }
                binding.toolBar.menu.findItem(R.id.menu_search) -> {
                    setSearchState()
                    true
                }
                binding.toolBar.menu.findItem(R.id.menu_sort_alphabet_a_to_z) -> {
                    presenter.sortNotes { filters.filterByAlphabetAtoZ(adapter.currentList) }
                    true
                }
                binding.toolBar.menu.findItem(R.id.menu_sort_alphabet_z_to_a) -> {
                    presenter.sortNotes { filters.filterByAlphabetZtoA(adapter.currentList) }
                    true
                }
                else -> {
                    true
                }
            }
        }

        binding.ibtnGoBack.setOnClickListener {
            setBasicState()
        }

        binding.fabDelete.setOnClickListener {
            onDeleteFubClick()
        }

        binding.fab.setOnClickListener {
            presenter.addNote()
        }

        val searchField = binding.etSearch
        searchField.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(
                s: CharSequence, start: Int,
                count: Int, after: Int
            ) {
            }

            override fun onTextChanged(
                s: CharSequence, start: Int,
                before: Int, count: Int
            ) {
                presenter.filterNotes(searchField.text.toString())
            }
        })
    }


    override fun onDestroy() {
        super.onDestroy()
        presenter.dispose()
    }

    companion object {

        const val INCREASE = "increase"
        const val DECREASE = "decrease"

        fun navigateTo(thisContext: Context): Intent {
            return Intent(thisContext, NoteActivity::class.java)
        }

        const val NOTEID = "note id"
    }


    override fun showFailToast() {
        Toast.makeText(this, getString(R.string.somth_went_wrong), Toast.LENGTH_LONG).show()
    }

    override fun onNoteClick(noteModel: NoteModel) {
        navigateToNoteActivity(noteModel.id)
    }

    override fun onLongNoteClick(note: NoteModel) {
        setDeleteState()
    }

    override fun onGoBackClick() {
        setBasicState()
    }

    override fun navigateToNoteActivity(noteId: String) {
        val intent = navigateTo(this).apply {
            putExtra(NOTEID, noteId)
        }
        startActivity(intent)
    }

    override fun setDeleteState() {
        adapter.setDeleteState(true)
        binding.fabDelete.isVisible = true
        binding.fab.isVisible = false
        binding.ibtnGoBack.isVisible = true
    }

    override fun setSortedState(filtration: (item: List<NoteModel>) -> List<NoteModel>) {

    }

    override fun setSearchState() {
        binding.etSearch.isVisible = true
        binding.ibtnGoBack.isVisible = true
    }

    override fun setBasicState() {
        adapter.setDeleteState(false)
        binding.fabDelete.isVisible = false
        binding.fab.isVisible = true
        binding.ibtnGoBack.isVisible = false
        binding.etSearch.isVisible = false
        presenter.loadData()
    }

    override fun setBasicStateAfterSearch() {
        setBasicState()
        presenter.loadData()
    }

    override fun onDeleteFubClick() {
        adapter.notifyDataSetChanged()
        presenter.deleteNote(adapter.getCheckedPositions())
        adapter.clearCheckList()
    }

    override fun showLoading() {
        // changeState(State.Loading)
        binding.progressLoading.isVisible = true
        binding.textError.isVisible = false
        binding.recyclerNotes.isVisible = false
    }

    override fun showNotes(
        notes: List<NoteModel>
    ) {
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
