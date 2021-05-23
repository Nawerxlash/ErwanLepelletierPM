package com.example.erwanlepelletierpm.presentation.list

import GenshinAdapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.erwanlepelletierpm.R

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class GenshinListFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private val adapter = GenshinAdapter(listOf())
    private val layoutManager = LinearLayoutManager(context)


    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_genshin_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        recyclerView = view.findViewById(R.id.genshin_recyclerview)

        recyclerView.apply  {
            layoutManager = this@GenshinListFragment.layoutManager
            adapter = this@GenshinListFragment.adapter
        }

        val genshinlist : ArrayList<String> = arrayListOf<String>().apply {
            add("Xiao")
            add("Tartaglia")
            add("Diluc")
            add("Eula")
        }

        adapter.updateList(genshinlist)
    }
}