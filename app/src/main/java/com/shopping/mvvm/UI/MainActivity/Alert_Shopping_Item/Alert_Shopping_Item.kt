package com.shopping.mvvm.UI.MainActivity.Alert_Shopping_Item

import android.app.AlertDialog
import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatDialog
import com.shopping.mvvm.Model.Shopping_Item
import com.shopping.mvvm.databinding.AlertDialogShoppingBinding

class Alert_Shopping_Item(context: Context,var getItemInAlert: Get_Item_in_Alert) : AppCompatDialog(context) {
    private lateinit var binding: AlertDialogShoppingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= AlertDialogShoppingBinding.inflate(layoutInflater)
        var view=binding.root
        setContentView(view)
        binding.btnCancelItemAlert.setOnClickListener {
            cancel()
        }
        binding.btnAddItemAlert.setOnClickListener {
            var Name_item:String=binding.nameItemAlert.text.toString()
            var Amount_Item:Int=binding.amountItemAlert.text.toString().toInt()
            var shoppingItem=Shopping_Item(Name_item,Amount_Item)
            getItemInAlert.Add_Data_Item(shoppingItem)
            dismiss()
        }
    }
}