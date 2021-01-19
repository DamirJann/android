package com.example.appdev.lab5


import android.app.Application
import androidx.lifecycle.LiveData
import com.example.appdev.lab5.dao.ItemDao
import com.example.appdev.lab5.entity.TransactionEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class Repository (application: Application){
    private val itemDao: ItemDao
    private val allItems: LiveData<List<TransactionEntity>>

    init {
        val database: ItemDatabase = ItemDatabase.getInstance(application)!!
        itemDao = database.itemDao()
        allItems = itemDao.getAllItems()
    }

    fun insert(item : TransactionEntity) = runBlocking{
        this.launch (Dispatchers.IO) {
            itemDao.insert(item)
        }
    }

    fun update(item : TransactionEntity) = runBlocking{
        this.launch (Dispatchers.IO) {
            itemDao.update(item)
        }
    }

    fun delete(item : TransactionEntity) = runBlocking{
        this.launch (Dispatchers.IO) {
            itemDao.delete(item)
        }
    }

    fun deleteAllItems() = runBlocking{
        this.launch (Dispatchers.IO) {
            itemDao.deleteAllItems()
        }
    }

    fun getAllItems(): LiveData<List<TransactionEntity>> {
        return allItems
    }

    fun getAllTransactionByBank(bank: String): List<TransactionEntity> {
        return itemDao.getAllTransactionByBank(bank);
    }


}