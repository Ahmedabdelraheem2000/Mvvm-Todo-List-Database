package com.shopping.mvvm.db

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.Dao
import com.shopping.mvvm.Model.Shopping_Item

@Dao
interface Dao {
@Insert(onConflict = OnConflictStrategy.REPLACE)
fun Upsert(Item:Shopping_Item)
@Delete
fun Delete(Item:Shopping_Item)
@Query("Select * From Shopping_Items")
fun getAllItem():LiveData<List<Shopping_Item>>


}