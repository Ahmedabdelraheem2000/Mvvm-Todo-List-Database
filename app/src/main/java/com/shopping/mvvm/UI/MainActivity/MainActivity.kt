package com.shopping.mvvm.UI.MainActivity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.shopping.mvvm.Model.Shopping_Item
import com.shopping.mvvm.Repostory.Shopping_Repostory
import com.shopping.mvvm.UI.MainActivity.Alert_Shopping_Item.Alert_Shopping_Item
import com.shopping.mvvm.UI.MainActivity.Alert_Shopping_Item.Get_Item_in_Alert
import com.shopping.mvvm.UI.MainActivity.Utils.Shopping_Item_Adapter
import com.shopping.mvvm.databinding.ActivityMainBinding
import com.shopping.mvvm.db.Shopping_DataBase

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        val view =binding.root
        setContentView(view)

        val database=Shopping_DataBase(this)
        val repostory=Shopping_Repostory(database)
        val factory= Shopping_ViewModel_Factopry(repostory)
        val viewmodel=ViewModelProviders.of(this,factory).get(Shopping_ViewModel::class.java)

        val shoppingItemAdapter=Shopping_Item_Adapter(listOf(),viewmodel)
        binding.recyclerShopping.layoutManager=LinearLayoutManager(this)
        binding.recyclerShopping.adapter=shoppingItemAdapter
        viewmodel.getAllItem().observe(this, Observer {
            shoppingItemAdapter.shoppingItem=it
            shoppingItemAdapter.notifyDataSetChanged()
        })

        binding.btnFloatAction.setOnClickListener {
            Alert_Shopping_Item(this,object :Get_Item_in_Alert{
                override fun Add_Data_Item(shoppingItem: Shopping_Item) {
                    viewmodel.Upsert(shoppingItem)
                }

            }).show()
        }
    }
}