package com.shopping.mvvm.UI.MainActivity

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.room.Update
import com.shopping.mvvm.Model.Shopping_Item
import com.shopping.mvvm.Repostory.Shopping_Repostory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class Shopping_ViewModel(private var repostory: Shopping_Repostory) :ViewModel() {
    fun Upsert(item: Shopping_Item)= CoroutineScope(Dispatchers.IO).launch {
        repostory.Upsert(item)
    }
  fun Delete(item: Shopping_Item)= CoroutineScope(Dispatchers.IO).launch {
      repostory.Delete(item)
  }
  fun getAllItem() =repostory.getAllItem()
}