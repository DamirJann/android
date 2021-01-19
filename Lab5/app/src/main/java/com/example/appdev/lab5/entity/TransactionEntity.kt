package com.example.appdev.lab5.entity


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "transaction")
class TransactionEntity (
    @ColumnInfo(name = "bank")
    var bank : String,
    @ColumnInfo(name = "cost")
    var cost : Int,
    @ColumnInfo(name = "tag")
    var tag : String,
    @ColumnInfo(name = "is_reasonable")
    var isReasonable: Boolean
) : Serializable{
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null

}