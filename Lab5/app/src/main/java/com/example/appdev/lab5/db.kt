package com.example.appdev.lab5

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.appdev.lab5.dao.ItemDao
import com.example.appdev.lab5.entity.TransactionEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

@Database(entities = [TransactionEntity::class], version = 3)
abstract class ItemDatabase : RoomDatabase(){
    abstract fun itemDao(): ItemDao

    companion object {
        @Volatile
        private var instance: ItemDatabase? = null

        fun getInstance(context: Context): ItemDatabase? {
            if (instance == null) {
                synchronized(ItemDatabase::class) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        ItemDatabase::class.java, "note_database"
                    )
                        .fallbackToDestructiveMigration() // when version increments, it migrates (deletes db and creates new) - else it crashes
                        .addCallback(ItemDatabaseCallback())
                        .build()
                }
            }
            return instance
        }

        fun destroyInstance() {
            instance = null
        }



        private class ItemDatabaseCallback() : RoomDatabase.Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                instance?.let { database ->
                    CoroutineScope(Dispatchers.IO).launch (Dispatchers.IO) {
                    }
                }
            }
        }
    }
}