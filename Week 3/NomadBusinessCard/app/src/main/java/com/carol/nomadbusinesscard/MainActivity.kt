package com.carol.nomadbusinesscard

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    private lateinit var text: TextView
    private lateinit var mybtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val callme = findViewById<View>(R.id.callme) //intents...this will start another activity when the text is clicked
        callme.setOnClickListener {
            val callIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:+254741102889"))
            startActivity(callIntent)

            Handler().postDelayed({  // display a message after a few seconds when the activity is opened
                Toast.makeText(
                    this,
                    "Please leave a message if I am not available",
                    Toast.LENGTH_LONG
                ).show()
            }, 4000)
        }

        val emailme = findViewById<View>(R.id.emailme)  //another intent
        emailme.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO)
            intent.data =
                Uri.parse("mailto:thenomadke@gmail.com") // only email apps should handle this
            intent.putExtra(Intent.EXTRA_EMAIL, "")
            intent.putExtra(Intent.EXTRA_SUBJECT, "Feedback")
            startActivity(intent)

        }

        text = findViewById(R.id.quotespace)
        mybtn = findViewById(R.id.quotegenerator)
        val facts = arrayOf(  //an array of the facts that will be displayed once the button is clicked
            "The Maasai Tribe inhabit more than one country: Kenya and Tanzania",
            "The Maasai Tribe is made up of sixteen sections(Sub tribes)",
            " Blood is part of the Maasai diet: Its definitely not gross",
            "The Maasai are named after their own language",
            "The Maasai have their own traditional wardrobe",
            "Maasai members pride themselves on their cows",
            "There are different religions within the Maasai Tribe",
            "The Maasai Tribe are mostly polygamous",
            "Children in the Maasai Tribe are not named until three months of age",
            "The Maasai have their own calendar"
        )
        mybtn.setOnClickListener {
            val randomQuote = facts.random()  // this picks a random fact
            text.setText(randomQuote)


        }
        val fab: View = findViewById(R.id.fab) // the floating action button
        val randomQuote = facts.random()
        fab.setOnClickListener {
            val s = randomQuote

            //Intent to share the text (the current text displayed)
            val shareIntent = Intent()
            shareIntent.action = Intent.ACTION_SEND
            shareIntent.type = "text/plain"
            shareIntent.putExtra(Intent.EXTRA_TEXT, s);
            startActivity(Intent.createChooser(shareIntent, "Share via"))
        }

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {  // the menu
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {

            R.id.action_version -> { //tells it what to do once it is clicked
                Toast.makeText(applicationContext, "Version 1.0.0", Toast.LENGTH_LONG).show()
                return true
            }
            else -> super.onOptionsItemSelected(item)


        }

    }
}



        




