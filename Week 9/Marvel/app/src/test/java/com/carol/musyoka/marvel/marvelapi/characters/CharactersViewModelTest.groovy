package com.carol.musyoka.marvel.marvelapi.characters

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock

class CharactersViewModelTest {

    @Test
    fun getCharactersFails(){
        testSingle = Single.error(Throwable())


        characterViewModel.refresh()

        assertEquals(true, characterViewModel.charactersLoadError.value)
        assertEquals(false, characterViewModel.loading.value)

    }
}
