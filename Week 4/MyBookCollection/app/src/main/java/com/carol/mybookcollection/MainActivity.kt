package com.carol.mybookcollection

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.book_entry.view.*

class MainActivity : AppCompatActivity() {

    var adapter: BookAdapter? = null
    var booksList = ArrayList<Book>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // load foods
        booksList.add(Book("Harry Potter and The Chamber of Secrets", "",
            R.drawable.chamber_of_secrets))
        booksList.add(Book("God HelpThe Child", "",
            R.drawable.god_help_the_child))
        booksList.add(Book("Harry Potter and The Half Blood Prince", "",
            R.drawable.half_blood_prince))
        booksList.add(Book("IT", " ",
            R.drawable.it))
        booksList.add(Book("Jazz", "",
            R.drawable.jazz))
        booksList.add(Book("Harry Potter and the Order of the Phoenix", "",
            R.drawable.order_of_the_phoenix))
        booksList.add(Book("Harry Potter and The Philosopher`s Stone", "",
            R.drawable.philosophers_stone))
        booksList.add(Book("Harry Potter and the Prisoner of Azkaban", "",
            R.drawable.prisoner_of_azkaban))
        booksList.add(Book("Sula", "",
            R.drawable.sula))
        booksList.add(Book("Tar Baby", "",
            R.drawable.tar_baby))
        booksList.add(Book("The Shining", "",
            R.drawable.the_shining))
        booksList.add(Book("To Kill a MockingBird", "",
            R.drawable.to_kill_a_mockingbird))
        adapter = BookAdapter(this, booksList)

        gvBooks.adapter = adapter
    }

    class BookAdapter(context: Context, var booksList: ArrayList<Book>) : BaseAdapter() {
        var context: Context? = context

        override fun getCount(): Int {
            return booksList.size
        }

        override fun getItem(position: Int): Any {
            return booksList[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val book = this.booksList[position]

            val inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val bookView = inflator.inflate(R.layout.book_entry, null)
            bookView.imgBook.setOnClickListener {

                val intent = Intent(context, BookDetails::class.java)
                intent.putExtra("name", book.name!!)
                intent.putExtra("description", book.description!!)
                intent.putExtra("image", book.image!!)
                context!!.startActivity(intent)
            }
            bookView.imgBook.setImageResource(book.image!!)
            bookView.bookName.text = book.name!!

            return bookView
        }
    }
}
