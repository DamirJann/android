package com.example.appdev.lab5

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import com.example.appdev.lab5.entity.TransactionEntity
import com.google.android.material.floatingactionbutton.FloatingActionButton

import androidx.lifecycle.Observer


class MainActivity : AppCompatActivity() {
    private val itemViewModel: TransactionViewModel by viewModels()


    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val bankName:TextView = findViewById(R.id.bank_name)
        val totalSum:TextView = findViewById(R.id.total_count)
        val reasonablePurchaseCount:TextView = findViewById(R.id.reasonable_purchase)
        val nonReasonablePurchaseCount:TextView = findViewById(R.id.none_reasonable_purchase)

        val bank = "SBERBANK"

        bankName.text = bank

        val recyclerView: RecyclerView = findViewById(R.id.transactionRecylerView)
        // подключаем адаптер
        val adapter = Adapter(this)
        // ищем списко, добавляем к нему адаптер
        recyclerView.adapter = adapter

        itemViewModel.getAllItems().observe(this, Observer { it ->
            adapter.setItems(it)

            var sum = 0
            var reasonableCount = 0
            var nonReasonableCount = 0

            it.forEach {
                sum += it.cost
                reasonableCount += if (it.isReasonable) 1 else 0
                nonReasonableCount += if (it.isReasonable) 0 else 1
            }
            totalSum.text = sum.toString()
            reasonablePurchaseCount.text = reasonableCount.toString()
            nonReasonablePurchaseCount.text = nonReasonableCount.toString()

        })
        val button = findViewById<FloatingActionButton>(R.id.floatingActionButton)
        button.setOnClickListener(MyImlInterface(this, bank))


    }
}

class MyImlInterface(private val context: Context, private val bank_name: String) :
    View.OnClickListener {


    override fun onClick(p0: View?) {
        val intent = Intent(this.context, AddNewTransactionPage::class.java)
        context.startActivity(intent)
        intent.putExtra("bank_name", bank_name)
        context.startActivity(intent)
    }
}