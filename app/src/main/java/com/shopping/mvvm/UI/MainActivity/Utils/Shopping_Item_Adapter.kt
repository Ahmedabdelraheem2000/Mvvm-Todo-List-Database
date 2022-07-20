package com.shopping.mvvm.UI.MainActivity.Utils

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.shopping.mvvm.Model.Shopping_Item
import com.shopping.mvvm.UI.MainActivity.Shopping_ViewModel
import com.shopping.mvvm.databinding.ItemShoppingBinding

class Shopping_Item_Adapter(var shoppingItem: List<Shopping_Item>
        ,private val viewShopping_ViewModel: Shopping_ViewModel) :
    RecyclerView.Adapter<Shopping_Item_Adapter.Shopping_Item_Holder>() {

    inner class Shopping_Item_Holder(val binding: ItemShoppingBinding)
        : RecyclerView.ViewHolder(binding.root){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Shopping_Item_Holder {
       return Shopping_Item_Holder(ItemShoppingBinding.inflate(LayoutInflater.from(parent.context)
       ,parent,false))

    }

    override fun onBindViewHolder(holder: Shopping_Item_Holder, position: Int) {
        var item=shoppingItem[position]
        holder.binding.apply {
            tvItemName.setText(item.Item_Name)
            amountItem.setText("${item.Amount_Item}")
            btnAdd.setOnClickListener {
                item.Amount_Item++
                viewShopping_ViewModel.Upsert(item)
            }
            btnMin.setOnClickListener {
                item.Amount_Item--
                viewShopping_ViewModel.Upsert(item)
            }
        }
    }

    override fun getItemCount(): Int {
        return shoppingItem.size
    }


}