package com.shopping.mvvm.Repostory

import androidx.lifecycle.LiveData
import androidx.room.Delete
import com.shopping.mvvm.Model.Shopping_Item
import com.shopping.mvvm.db.Shopping_DataBase

class Shopping_Repostory(private var shoppingDatabase: Shopping_DataBase) {

    suspend fun Upsert(item: Shopping_Item)=shoppingDatabase.getDao().Upsert(item)
    suspend fun Delete(item: Shopping_Item)=shoppingDatabase.getDao().Delete(item)
    fun getAllItem() =shoppingDatabase.getDao().getAllItem()
}