package com.example.appdev.lab5

import android.app.Activity
import com.example.appdev.lab5.entity.TransactionEntity

import android.app.Application
import android.content.Context
import android.os.Build
import android.util.Log
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.lifecycle.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.function.Consumer

class TransactionViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: Repository = Repository(application)
    private val transactions: LiveData<List<TransactionEntity>> = repository.getAllItems()

    fun insert(item: TransactionEntity) {
        repository.insert(item)
    }

    fun delete(item: TransactionEntity) {
        repository.delete(item)
    }

    fun update(item: TransactionEntity) {
        repository.update(item)
    }

    fun deleteAllItems() {
        repository.deleteAllItems()
    }

    fun getAllItems(): LiveData<List<TransactionEntity>> {
        return repository.getAllItems()
    }

//    fun getAllByBank(bank: String): LiveData<List<TransactionEntity>> {
////        return repository.getAllTransactionByBank(bank);
//    }
//
//    @RequiresApi(Build.VERSION_CODES.N)
//    fun getReasonablePurchaseCountByBank(bank: String): Int {
//        val transactions: LiveData<List<TransactionEntity>> =
////            repository.getAllTransactionByBank(bank);
//        var count: Int = 0
//        transactions.value?.stream()?.forEach { transaction: TransactionEntity ->
//            count += (if (transaction.isReasonable) 1 else 0)
//        }
//        return count
//    }

//    @RequiresApi(Build.VERSION_CODES.N)
//    fun getNonReasonablePurchaseCountByBank(bank: String): Int {
////        val transactions: LiveData<List<TransactionEntity>> =
////            repository.getAllTransactionByBank(bank);
////        var count: Int = 0
////        transactions.value?.stream()?.forEach { transaction: TransactionEntity ->
////            count += (if (transaction.isReasonable) 0 else 1)
////        }
////        return count
//    }


}