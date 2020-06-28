package com.carol.mybookcollection

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.carol.mybookcollection.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.activity_book_details.*
import kotlinx.android.synthetic.main.book_entry.*

class BookDetails : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_details)

        val bundle= intent.extras

        bundle?.getInt("image")?.let { imgBookDetails.setImageResource(it) }
        bookname.text = bundle?.getString("name")
        bookDetails.text = bundle?.getString("description")

        val share_text_1_btn : FloatingActionButton = findViewById(R.id.fab)

        share_text_1_btn.setOnClickListener {
            val sendIntent = Intent()
            sendIntent.action = Intent.ACTION_SEND
            sendIntent.action = Intent.ACTION_SEND;
            sendIntent.putExtra(Intent.EXTRA_TEXT,bookDetails.text.toString())
            sendIntent.type = "text/plain";
            Intent.createChooser(sendIntent,"Share via")
            startActivity(sendIntent)
        }
    }
}
