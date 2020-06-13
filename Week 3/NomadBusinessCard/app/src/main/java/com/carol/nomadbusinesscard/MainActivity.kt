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
            "Kenya is ....",
            "sdjasjdnksjd",
            "snsankxasmkas",
            "sxjksaxkdasmxds"
        )
        mybtn.setOnClickListener {
            val randomQuote = facts.random()
            text.setText(randomQuote)


        }

    }
}
