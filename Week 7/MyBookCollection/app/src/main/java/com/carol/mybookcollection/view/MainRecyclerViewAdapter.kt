package com.carol.mybookcollection.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.carol.mybookcollection.R
import com.carol.mybookcollection.model.Book
import kotlinx.android.synthetic.main.book_entry.view.*

class BooksRecyclerViewAdapter(
    private val books: List<Book>,
    private val onItemClickListener: (book: Book) -> Unit
) : RecyclerView.Adapter<BooksRecyclerViewAdapter.BooksViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BooksViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.book_entry, parent, false)
        return BooksViewHolder(itemView, onItemClickListener)
    }

    override fun getItemCount() = books.count()

    override fun onBindViewHolder(holder: BooksViewHolder, position: Int) {
        holder.bindView(books[position])
    }

    class BooksViewHolder(
        itemView: View,
        private val onItemClickListener: (book: Book) -> Unit
    ) : RecyclerView.ViewHolder(itemView) {

        private val title = itemView.bookName
        private val author = itemView.item_author

        fun bindView(book: Book) {
            title.text = book.title
            author.text = book.author
            itemView.setOnClickListener {
                onItemClickListener.invoke(book)
            }
        }
    }
}