package com.example.appdev.lab3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import org.w3c.dom.Text

class PageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page)
        intent = getIntent()
        val text: TextView = findViewById(R.id.full_name)
        val image: ImageView = findViewById(R.id.userPhoto)
        val view  = DataStorage.getVersionsList().get(intent.getIntExtra("profileId",0))
        image.setImageResource(view.imageAndroid)
        text.text = view.title

    }
}