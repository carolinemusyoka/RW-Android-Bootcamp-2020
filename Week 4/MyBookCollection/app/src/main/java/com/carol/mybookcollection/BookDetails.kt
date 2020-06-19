package com.carol.mybookcollection

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_book_details.*
import kotlinx.android.synthetic.main.book_entry.*
import kotlinx.android.synthetic.main.activity_book_details.bookName as bookName1

class BookDetails : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_details)

        val bundle= intent.extras

        imgBookDetails.setImageResource(bundle.getInt("image"))
        bookName.text = bundle.getString("name")
        bookDetails.text = bundle.getString("description")
    }
}
