package com.example.laba2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.laba2.databinding.ListFragmentBinding
import java.text.FieldPosition


class ListAdapter(context: Context, private val arrayList: ArrayList<ItemModel>) :
    ArrayAdapter<ItemModel>(context, R.layout.custom_list_item, arrayList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater = LayoutInflater.from(parent.context)
        val view : View = inflater.inflate(R.layout.custom_list_item, parent, false)

        val imageView : ImageView = view.findViewById(R.id.imageview)
        val countryName : TextView = view.findViewById(R.id.textView1)
        val cityName : TextView = view.findViewById(R.id.textView2)

        imageView.setImageResource(arrayList[position].imageId)
        countryName.text = arrayList[position].name
        cityName.text = arrayList[position].city

        return view
    }
}