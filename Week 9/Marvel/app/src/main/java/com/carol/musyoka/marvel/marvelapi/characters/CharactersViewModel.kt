package com.carol.musyoka.marvel.marvelapi.characters

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.carol.musyoka.marvel.marvelapi.base.BaseViewModel
import com.carol.musyoka.marvel.marvelapi.characters.model.CharactersDTO
import com.carol.musyoka.marvel.marvelapi.ext.combinedObserveOnScheduleOn
import com.carol.musyoka.marvel.marvelapi.ext.toLiveData
import io.reactivex.subjects.BehaviorSubject
import javax.inject.Inject

class CharactersViewModel @Inject constructor(private val repository: CharactersRepoService) : BaseViewModel() {

    private val _characters: MutableLiveData<CharactersDTO> by lazy {
        MutableLiveData<CharactersDTO>().also {
            loadCharacters()
        }
    }
    var characters: LiveData<CharactersDTO> = _characters

    private val _viewState: BehaviorSubject<ViewState> = BehaviorSubject.create()
    var viewState: LiveData<ViewState> = _viewState.toLiveData()

    init {
        _viewState.onNext(ViewState())
    }

    private fun loadCharacters() {
        repository.getCharacters()
            .combinedObserveOnScheduleOn().subscribe({
                _characters.postValue(it)
                _viewState.onNext(ViewState(isLoaded = true))
            }, {
                _viewState.onNext(ViewState(showError = true))
            }).addToViewModelCompositeDisposable()
    }

    data class ViewState(val isLoaded: Boolean? = false,
                         val showError: Boolean? = false)
}