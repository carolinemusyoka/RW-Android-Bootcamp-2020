package com.carol.mybookcollection.view

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.carol.mybookcollection.Book
import com.carol.mybookcollection.BookDetails
import com.carol.mybookcollection.R
import com.carol.mybookcollection.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.book_entry.view.*

class MainActivity : AppCompatActivity() {

    var adapter: BookAdapter? = null
    var booksList = ArrayList<Book>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

<<<<<<< Updated upstream
        // load books
=======

>>>>>>> Stashed changes
        booksList.add(
            Book(
                "Harry Potter and The Chamber of Secrets",
                "The second instalment of boy wizard Harry Potter's adventures at Hogwarts School of Witchcraft and Wizardry, based on the novel by JK Rowling. A mysterious elf tells Harry to expect trouble during his second year at Hogwarts, but nothing can prepare him for trees that fight back, flying cars, spiders that talk and deadly warnings written in blood on the walls of the school.",
                R.drawable.chamber_of_secrets
            )
        )
        booksList.add(
            Book(
                "God HelpThe Child",
                "Revolves around the life of Bride, formerly known as Lula Ann Bridewell. She's a young black woman in her early twenties who has had to overcome many obstacles in her life, particularly moving on from her childhood, to become the successful business woman she is today.",
                R.drawable.god_help_the_child
            )
        )
        booksList.add(
            Book(
                "Harry Potter and The Half Blood Prince",
                "As Death Eaters wreak havoc in both Muggle and Wizard worlds, Hogwarts is no longer a safe haven for students. Though Harry (Daniel Radcliffe) suspects there are new dangers lurking within the castle walls, Dumbledore is more intent than ever on preparing the young wizard for the final battle with Voldemort. Meanwhile, teenage hormones run rampant through Hogwarts, presenting a different sort of danger. Love may be in the air, but tragedy looms, and Hogwarts may never be the same again.",
                R.drawable.half_blood_prince
            )
        )
        booksList.add(
            Book(
                "IT",
                " The story follows the experiences of seven children as they are terrorized by an evil entity that exploits the fears of its victims to disguise itself while hunting its prey.",
                R.drawable.it
            )
        )
        booksList.add(
            Book(
                "Jazz",
                " A married dude shoots his eighteen-year-old girlfriend, and she dies. His wife is understandably bummed out. Everyone sits around thinking about history and listening to jazz for a few months. Another eighteen-year-old girl shows up, and the married couple dances and is happy again.",
                R.drawable.jazz
            )
        )
        booksList.add(
            Book(
                "Harry Potter and the Order of the Phoenix",
                "Now in his fifth year at Hogwarts, Harry (Daniel Radcliffe) learns that many in the wizarding community do not know the truth of his encounter with Lord Voldemort. Cornelius Fudge, minister of Magic, appoints his toady, Dolores Umbridge, as Defense Against the Dark Arts teacher, for he fears that professor Dumbledore will take his job. But her teaching is deficient and her methods, cruel, so Harry prepares a group of students to defend the school against a rising tide of evil.",
                R.drawable.order_of_the_phoenix
            )
        )
        booksList.add(
            Book(
                "Harry Potter and The Philosopher`s Stone",
                "Adaptation of the first of J.K. Rowling's popular children's novels about Harry Potter, a boy who learns on his eleventh birthday that he is the orphaned son of two powerful wizards and possesses unique magical powers of his own. He is summoned from his life as an unwanted child to become a student at Hogwarts, an English boarding school for wizards. There, he meets several friends who become his closest allies and help him discover the truth about his parents' mysterious deaths.",
                R.drawable.philosophers_stone
            )
        )
        booksList.add(
            Book(
                "Harry Potter and the Prisoner of Azkaban",
                "Harry Potter's (Daniel Radcliffe) third year at Hogwarts starts off badly when he learns deranged killer Sirius Black (Gary Oldman) has escaped from Azkaban prison and is bent on murdering the teenage wizard. While Hermione's (Emma Watson) cat torments Ron's (Rupert Grint) sickly rat, causing a rift among the trio, a swarm of nasty Dementors is sent to protect the school from Black. A mysterious new teacher helps Harry learn to defend himself, but what is his secret tie to Sirius Black?",
                R.drawable.prisoner_of_azkaban
            )
        )
        booksList.add(
            Book(
                "Sula",
                "This rich and moving novel traces the lives of two black heroines from their close-knit childhood in a small Ohio town, through their sharply divergent paths of womanhood, to their ultimate confrontation and reconciliation.\n" +
                        "\n" +
                        "Nel Wright has chosen to stay in the place where she was born, to marry, raise a family, and become a pillar of the black community. Sula Peace has rejected the life Nel has embraced, escaping to college, and submerging herself in city life. When she returns to her roots, it is as a rebel and a wanton seductress. Eventually, both women must face the consequences of their choices. Together, they create an unforgettable portrait of what it means and costs to be a black woman in America.",
                R.drawable.sula
            )
        )
        booksList.add(
            Book(
                "Tar Baby",
                "Ravishingly beautiful and emotionally incendiary, Tar Baby is Toni Morrison’s reinvention of the love story. Jadine Childs is a black fashion model with a white patron, a white boyfriend, and a coat made out of ninety perfect sealskins. Son is a black fugitive who embodies everything she loathes and desires. As Morrison follows their affair, which plays out from the Caribbean to Manhattan and the deep South, she charts all the nuances of obligation and betrayal between blacks and whites, masters and servants, and men and women.",
                R.drawable.tar_baby
            )
        )
        booksList.add(
            Book(
                "The Shining",
                "Jack Torrance's new job at the Overlook Hotel is the perfect chance for a fresh start. As the off-season caretaker at the atmospheric old hotel, he'll have plenty of time to spend reconnecting with his family and working on his writing. But as the harsh winter weather sets in, the idyllic location feels ever more remote...and more sinister. And the only one to notice the strange and terrible forces gathering around the Overlook is Danny Torrance, a uniquely gifted five-year-old.",
                R.drawable.the_shining
            )
        )
        booksList.add(
            Book(
                "To Kill a MockingBird",
                "To Kill a Mockingbird is a novel by Harper Lee published in 1960. It was immediately successful, winning the Pulitzer Prize, and has become a classic of modern American literature. The plot and characters are loosely based on Lee's observations of her family, her neighbors and an event that occurred near her hometown of Monroeville, Alabama, in 1936, when she was 10 years old. The story is told by the six-year-old Jean Louise Finch.",
                R.drawable.to_kill_a_mockingbird
            )
        )
        adapter = BookAdapter(
            this,
            booksList
        )

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
