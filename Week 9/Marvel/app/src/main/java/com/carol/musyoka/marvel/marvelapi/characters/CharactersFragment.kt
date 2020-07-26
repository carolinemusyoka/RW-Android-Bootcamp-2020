package com.carol.musyoka.marvel.marvelapi.characters

import android.view.View
import android.widget.ProgressBar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.carol.musyoka.marvel.R
import com.carol.musyoka.marvel.marvelapi.base.BaseFragment
import com.carol.musyoka.marvel.marvelapi.characters.adapter.CharactersAdapter
import com.carol.musyoka.marvel.marvelapi.characters.model.CharactersDTO
import com.carol.musyoka.marvel.marvelapi.imageloader.PicassoLoader
import kotlinx.android.synthetic.main.fragment_characters.*
import javax.inject.Inject

class CharactersFragment : BaseFragment() {

    init {
        layoutFragmentRes = R.layout.fragment_characters
    }

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    @Inject
    lateinit var picassoLoader: PicassoLoader

    private lateinit var viewModel: CharactersViewModel

    override fun setUpFragmentView(view: View) {
        getComponentFragment().inject(this)
        val progressBar: ProgressBar = view.findViewById(R.id.characters_progress_bar)

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(CharactersViewModel::class.java)
        viewModel.characters.observe(this, Observer {
            displayCharactersView(it)
        })
        viewModel.viewState.observe(this, Observer {
            displayProgressBar(it, progressBar)
        })
    }

    private fun displayCharactersView(it: CharactersDTO) {
        if (it.data.results.isNotEmpty()) {
            val charactersAdapter = CharactersAdapter(it.data.results, picassoLoader, context!!)
            setUpRecyclerView(charactersAdapter)
        }
    }

    private fun displayProgressBar(it: CharactersViewModel.ViewState, progressBar: ProgressBar) {
        it.isLoaded?.let { showProgressView ->
            if (showProgressView) {
                progressBar.visibility = ProgressBar.GONE
            } else {
                progressBar.visibility = ProgressBar.VISIBLE
            }
        }
    }

    private fun setUpRecyclerView(charactersAdapter: CharactersAdapter) {
        characters_recycler_view.adapter = charactersAdapter
        characters_recycler_view.layoutManager = LinearLayoutManager(activity)
    }

    companion object {
        fun createCharactersFragment() = CharactersFragment()
    }
}
