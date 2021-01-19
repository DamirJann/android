package com.example.appdev.lab5

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Switch
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.appdev.lab5.entity.TransactionEntity

class AddNewTransactionPage() : AppCompatActivity() {

    private val itemViewModel: TransactionViewModel by viewModels()

    private fun getContext(): Context {
        return applicationContext
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_new_transaction_page)
        findViewById<TextView>(R.id.bank_name_new_transaction).text = intent.getStringExtra("bank_name")
        val button: Button = findViewById<Button>(R.id.save_transaction_button)
        button.setOnClickListener{

            val costView: EditText = findViewById(R.id.editTextNumber)
            val tagView: EditText = findViewById(R.id.editTextTextPersonName)
            val isReasonable: Switch = findViewById(R.id.switch1)

            itemViewModel.insert(TransactionEntity(intent.getStringExtra("bank_name") ,
                                                   costView.text.toString().toInt(),
                                                   tagView.text.toString(),
                                                   isReasonable.isChecked))

            val intent = Intent(this , MainActivity::class.java);
            startActivity(intent)
        }

    }


}