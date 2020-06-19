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
        booksList.add(Book("Harry Potter and The Chamber of Secrets", "Coffee preparation is the process of turning coffee beans into a beverage. While the particular steps vary with the type of coffee and with the raw materials, the process includes four basic steps; raw coffee beans must be roasted, the roasted coffee beans must then be ground, the ground coffee must then be mixed with hot water for a certain time (brewed), and finally the liquid coffee must be separated from the used grounds.",
            R.drawable.chamber_of_secrets))
        booksList.add(Book("God HelpThe Child", "Espresso’s authentic formula is clear and basic, its proper execution a matter of training, experience and natural talent.  A jet of hot water at 88°-93°C (190°-200°F) passes under a pressure of nine or more atmospheres through a seven-gram (.25 oz) cake-like layer of ground and tamped coffee. Done right, the result is a concentrate of not more than 30 ml (one oz) of pure sensorial pleasure.",
            R.drawable.god_help_the_child))
        booksList.add(Book("Harry Potter and The Half Blood Prince", "Heat a few inches of vegetable oil to 300 degrees F in a heavy pot. In 3 or 4 batches, fry the potatoes about 4 to 5 minutes per batch, or until soft. They should not be brown at all at this point-you just want to start the cooking process. Remove each batch and drain them on new, dry paper towels.",
            R.drawable.half_blood_prince))
        booksList.add(Book("IT", "While it is less likely that anyone would do this on their own if they are not a beekeeper, this might be useful for those who aspire to become one. Bees are really great and easy to keep, even in the urban environment! As Novella Carpenter calls them, bees are &quot;gateway animal for urban farmers&quot;. All you need is some space in the backyard/deck. The process of honey harvesting and extraction most likely happens on a separate days.",
            R.drawable.it))
        booksList.add(Book("Jazz", "Preparation. Coarsely mash strawberries with sugar, lemon juice, and salt using a potato masher in a large bowl. Let stand, stirring and mashing occasionally, 10 minutes. Transfer half of strawberry mixture to a blender and purée with cream until smooth. Freeze mixture in ice cream maker.",
            R.drawable.jazz))
        booksList.add(Book("Harry Potter and the Order of the Phoenix", "Sugar cubes are extremely simple to make at home - all you need is sugar and water. In addition to standard cubes, you can add color and flavor to add fun flair to a tea party or another gathering. Learn how to make sugar cubes using two different methods: using a pan in the oven or an ice cube tray you leave out overnight.",
            R.drawable.order_of_the_phoenix))
        booksList.add(Book("Harry Potter and The Philosopher`s Stone", "Preparation. Coarsely mash strawberries with sugar, lemon juice, and salt using a potato masher in a large bowl. Let stand, stirring and mashing occasionally, 10 minutes. Transfer half of strawberry mixture to a blender and purée with cream until smooth. Freeze mixture in ice cream maker.",
            R.drawable.philosophers_stone))
        booksList.add(Book("Harry Potter and the Prisoner of Azkaban", "Preparation. Coarsely mash strawberries with sugar, lemon juice, and salt using a potato masher in a large bowl. Let stand, stirring and mashing occasionally, 10 minutes. Transfer half of strawberry mixture to a blender and purée with cream until smooth. Freeze mixture in ice cream maker.",
            R.drawable.prisoner_of_azkaban))
        booksList.add(Book("Sula", "Preparation. Coarsely mash strawberries with sugar, lemon juice, and salt using a potato masher in a large bowl. Let stand, stirring and mashing occasionally, 10 minutes. Transfer half of strawberry mixture to a blender and purée with cream until smooth. Freeze mixture in ice cream maker.",
            R.drawable.sula))
        booksList.add(Book("Tar Baby", "Preparation. Coarsely mash strawberries with sugar, lemon juice, and salt using a potato masher in a large bowl. Let stand, stirring and mashing occasionally, 10 minutes. Transfer half of strawberry mixture to a blender and purée with cream until smooth. Freeze mixture in ice cream maker.",
            R.drawable.tar_baby))
        booksList.add(Book("The Shining", "Preparation. Coarsely mash strawberries with sugar, lemon juice, and salt using a potato masher in a large bowl. Let stand, stirring and mashing occasionally, 10 minutes. Transfer half of strawberry mixture to a blender and purée with cream until smooth. Freeze mixture in ice cream maker.",
            R.drawable.the_shining))
        booksList.add(Book("To Kill a MockingBird", "Preparation. Coarsely mash strawberries with sugar, lemon juice, and salt using a potato masher in a large bowl. Let stand, stirring and mashing occasionally, 10 minutes. Transfer half of strawberry mixture to a blender and purée with cream until smooth. Freeze mixture in ice cream maker.",
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
