package com.example.appdev.lab3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val android = DataStorage.getVersionsList()
        val adapter = AndroidAdapter(this, android)
        val list = findViewById<RecyclerView>(R.id.androidList)
        list.adapter = adapter


        val decoration = DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL)
        decoration.setDrawable(ContextCompat.getDrawable(this, R.color.colorPrimaryDark)!!)
        list.addItemDecoration(decoration)
    }



}