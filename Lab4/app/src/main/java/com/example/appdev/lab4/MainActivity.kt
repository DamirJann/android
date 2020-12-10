package com.example.appdev.lab4

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main);
        val fragment: AccountsFragment = AccountsFragment()
        supportFragmentManager
            .beginTransaction()
            .add(R.id.container, fragment)
            .commit()

        val button: FloatingActionButton? = findViewById<FloatingActionButton>(R.id.floatingActionButtonAccount1)
        button?.setOnClickListener {
            Toast.makeText(this, "Clicked", Toast.LENGTH_LONG).show()
            supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.container, AccountTransactionFragment())
                        .commit()
        }
    }
}