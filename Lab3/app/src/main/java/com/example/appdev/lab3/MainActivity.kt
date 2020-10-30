package com.example.appdev.lab3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
//class MainActivity : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//    }
//}
//


data class Android(
    val title: String,
    @DrawableRes val imageAndroid: Int
)

object DataStorage {
    fun getVersionsList(): List<Android> {
        return listOf(
            Android(
                "Cupcake",
                R.drawable.cupcake
            ),

            Android(
                "Donut",
                R.drawable.donut
            ),

            Android(
                "Eclair",
                R.drawable.eclair
            ),

            Android(
                "Froyo",
                R.drawable.froyo

            ),

            Android(
                "Gingerbread",
                R.drawable.gingerbread
            ),

            Android(
                "Honeycomb",
                R.drawable.honeycomb
            ),

            Android(
                "Jelly Bean",
                R.drawable.jelly
            ),

            Android(
                "Kitkat",
                R.drawable.kitkat
            ),

            Android(
                "Lollipop",
                R.drawable.lollipop
            ),

            Android(
                "Marshmallow",
                R.drawable.marshmallow
            ),

            Android(
                "Nougat",
                R.drawable.nougat
            ),

            Android(
                "Oreo",
                R.drawable.oreo
            ),

            Android(
                "Pie",
                R.drawable.pie
            ),

            Android(
                "Android 10",
                R.drawable.android_ten
            ),

            Android(
                "Android 11",
                R.drawable.android_el
            )
        )
    }
}




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