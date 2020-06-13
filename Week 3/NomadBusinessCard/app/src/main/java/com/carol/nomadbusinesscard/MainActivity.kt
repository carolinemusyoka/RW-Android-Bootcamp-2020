package com.carol.nomadbusinesscard

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var text: TextView
    private lateinit var mybtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val callme = findViewById<View>(R.id.callme)
        callme.setOnClickListener {
            val callIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:+254741102889"))
            startActivity(callIntent)

            Handler().postDelayed({
                Toast.makeText(
                    this,
                    "Please leave a message if I am not available",
                    Toast.LENGTH_LONG
                ).show()
            }, 4000)
        }

        val emailme = findViewById<View>(R.id.emailme)
        emailme.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO)
            intent.data = Uri.parse("mailto:thenomadke@gmail.com") // only email apps should handle this
            intent.putExtra(Intent.EXTRA_EMAIL, "")
            intent.putExtra(Intent.EXTRA_SUBJECT, "Feedback")
            startActivity(intent)

        }

        text = findViewById(R.id.quotespace)
        mybtn = findViewById(R.id.quotegenerator)
        val facts = arrayOf(
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
            val randomQuote = facts.random()
            text.setText(randomQuote)


        }

    }
}
