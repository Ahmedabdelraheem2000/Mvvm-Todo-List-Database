package com.shopping.mvvm.UI.MainActivity

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.shopping.mvvm.Repostory.Shopping_Repostory

class Shopping_ViewModel_Factopry(private var repostory: Shopping_Repostory) :
    ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return Shopping_ViewModel(repostory) as T
    }
}