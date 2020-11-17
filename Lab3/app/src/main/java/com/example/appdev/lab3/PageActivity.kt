package com.example.appdev.lab3

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import ru.itmo.androidversions.data.DataStorage

class PageActivity() : AppCompatActivity() {


    private fun getContext(): Context {
        return applicationContext
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page)
        intent = getIntent()
        val androidId =  intent.getIntExtra("profileId", 0)

        // get places where we put out image, titile and so on...
        val title: TextView = findViewById(R.id.android_name)
        val image: ImageView = findViewById(R.id.android_icon)
        val description: TextView = findViewById(R.id.description)
        val date: TextView = findViewById(R.id.released_date)
        val urlButton: Button = findViewById(R.id.url_button)



        // set data
        val view = DataStorage.getVersionsList().get(androidId)

        image.setImageResource(view.imageAndroid)
        title.text = view.title
        description.text  = view.description
        date.text = view.date

        // set listener on button
        urlButton.setOnClickListener(buttonClickListener(getContext(), view.url_source))



    }

    // listener for button
    class buttonClickListener(private val context: Context, private val url: String) :
        View.OnClickListener {
        override fun onClick(p0: View?) {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            context.startActivity(browserIntent)
        }
    }
}