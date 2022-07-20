package com.shopping.mvvm.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.shopping.mvvm.Model.Shopping_Item

@Database(
    entities = [Shopping_Item::class], version = 1
)
abstract class Shopping_DataBase : RoomDatabase() {
    abstract fun getDao():Dao
    companion object{
        @Volatile
        private var instant:Shopping_DataBase?=null
        private val LOCK=Any()
        operator fun invoke(context: Context)= instant?: synchronized(LOCK){
            instant?: create_Database(context).also {
                instant=it
            }
        }

        private fun create_Database(context :Context)=
            Room.databaseBuilder(
                context.applicationContext,
                Shopping_DataBase::class.java,
                "ShoppingDB.dp"
            ).build()

    }
}