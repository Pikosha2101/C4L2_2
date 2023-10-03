package com.example.laba2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.laba2.databinding.ListFragmentBinding

class ListFragment : Fragment(R.layout.list_fragment) {
    private var _binding : ListFragmentBinding? = null
    private val binding get() = _binding!!
    private lateinit var itemArrayList : ArrayList<ItemModel>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val countries = arrayOf("Россия", "США", "Австралия", "Япония", "Вьетнам")
        val cities = arrayOf("Москва", "Вашингтон", "Канберра", "Токио", "Ханой")
        val flags = intArrayOf(R.drawable.ru, R.drawable.us, R.drawable.au, R.drawable.jp, R.drawable.vn)

        itemArrayList = ArrayList()

        for (i in countries.indices){
            val item = ItemModel(countries[i], flags[i], cities[i])
            itemArrayList.add(item)
        }


        _binding = ListFragmentBinding.inflate(inflater, container, false)
        binding.listview.adapter = ListAdapter(requireContext(), itemArrayList)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = with(binding) {
        listview.onItemClickListener = AdapterView.OnItemClickListener { parent, v, position, id ->
            val selectedItem = itemArrayList[position]
            Toast.makeText(requireContext(), selectedItem.name, Toast.LENGTH_SHORT).show()
        }
    }
}