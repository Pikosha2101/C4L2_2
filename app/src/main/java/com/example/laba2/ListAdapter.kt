package com.example.laba2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.laba2.databinding.CustomListItemBinding


class ListAdapter(context: Context, private val arrayList: ArrayList<ItemModel>) :
    //arrayadapter - базовый класс
    ArrayAdapter<ItemModel>(context, R.layout.custom_list_item, arrayList) {

    private lateinit var binding : CustomListItemBinding
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater = LayoutInflater.from(parent.context)
        binding = CustomListItemBinding.inflate(inflater, parent, false)

        binding.imageview.setImageResource(arrayList[position].imageId)
        binding.textView1.text = arrayList[position].name
        binding.textView2.text = arrayList[position].city

        return binding.root
    }
}