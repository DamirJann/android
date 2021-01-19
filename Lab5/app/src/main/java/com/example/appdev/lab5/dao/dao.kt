package com.example.appdev.lab5.dao


import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.appdev.lab5.entity.TransactionEntity

@Dao
interface ItemDao {

    @Insert
    fun insert(item: TransactionEntity)

    @Update
    fun update(item: TransactionEntity)

    @Delete
    fun delete(item: TransactionEntity)

    @Query("DELETE FROM `transaction`")
    fun deleteAllItems()

    @Query("SELECT * FROM `transaction` ORDER BY bank DESC")
    fun getAllItems(): LiveData<List<TransactionEntity>>

    @Query("SELECT * FROM `transaction` where `transaction`.bank = :bank ")
    fun getAllTransactionByBank(bank:String): List<TransactionEntity>
}