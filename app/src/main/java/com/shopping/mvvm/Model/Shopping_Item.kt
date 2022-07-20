package com.shopping.mvvm.Model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Shopping_Items")
data class Shopping_Item(
    @ColumnInfo(name = "Item_Name")
     var Item_Name:String,
    @ColumnInfo(name = "Amount_Item")
     var Amount_Item:Int
){
    @PrimaryKey(autoGenerate = true)
     var ID:Int? = null
}
