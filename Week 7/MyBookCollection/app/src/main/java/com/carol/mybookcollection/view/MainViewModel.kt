package com.carol.mybookcollection.view

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.carol.mybookcollection.APIService
import com.carol.mybookcollection.model.Book
import com.carol.mybookcollection.response.BookBodyResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BooksViewModel : ViewModel() {
    val booksLiveData: MutableLiveData<List<Book>> = MutableLiveData()

    fun getBooks() {
        APIService.service.getBooks().enqueue(object : Callback<BookBodyResponse> {

            override fun onResponse(
                call: Call<BookBodyResponse>,
                response: Response<BookBodyResponse>
            ) {
                when {
                    response.isSuccessful ->{
                        val books: MutableList<Book> = mutableListOf()
                        response.body()?.let { bookBodyResponse ->

                            for (result in bookBodyResponse.bookResults) {
                                val book = Book(
                                    title = result.bookDetailResponses[0].title,
                                    author = result.bookDetailResponses[0].author,
                                    description = result.bookDetailResponses[0].description
                                )
                                books.add(book)
                            }
                        }
                        booksLiveData.value = books
                    }
                }
            }
            override fun onFailure(call: Call<BookBodyResponse>, t: Throwable) {}
        })
    }
}