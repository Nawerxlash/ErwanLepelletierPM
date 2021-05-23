package com.example.erwanlepelletierpm.presentation.list

import YugiAdapter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.erwanlepelletierpm.R
import com.example.erwanlepelletierpm.presentation.api.YugiApi
import com.example.erwanlepelletierpm.presentation.api.YugiohResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class YugiListFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private val adapter = YugiAdapter(listOf(), ::onClikedCard)


    private val layoutManager = LinearLayoutManager(context)


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_yugi_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        recyclerView = view.findViewById(R.id.genshin_recyclerview)

        recyclerView.apply {
            layoutManager = this@YugiListFragment.layoutManager
            adapter = this@YugiListFragment.adapter
        }


        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://db.ygoprodeck.com/api/v7/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val pokeApi: YugiApi = retrofit.create(YugiApi::class.java)

        pokeApi.getYugiList().enqueue(object : retrofit2.Callback<YugiohResponse> {
            override fun onFailure(call: Call<YugiohResponse>, t: Throwable) {
                //TODO("Not yet implemented")
            }

            override fun onResponse(
                call: Call<YugiohResponse>,
                response: Response<YugiohResponse>
            ) {
                if (response.isSuccessful && response.body() != null) {
                    val YugiohResponse: YugiohResponse = response.body()!!
                    adapter.updateList(YugiohResponse.data)
                }
            }


        })
    }

    private fun onClikedCard(card: Card) {
        findNavController().navigate(R.id.navigateToCardDetailFragment)
    }
}