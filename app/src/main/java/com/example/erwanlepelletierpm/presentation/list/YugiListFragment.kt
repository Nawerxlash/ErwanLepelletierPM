package com.example.erwanlepelletierpm.presentation.list

import YugiAdapter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.erwanlepelletierpm.R
import com.example.erwanlepelletierpm.presentation.Singletons
import com.example.erwanlepelletierpm.presentation.api.YugiohResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class YugiListFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private val adapter = YugiAdapter(listOf(), ::onClikedCard)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_yugi_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        recyclerView = view.findViewById(R.id.yugioh_recyclerview)

        recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = this@YugiListFragment.adapter
        }
        callApi()
        /*val list = getListFromCache()
        if(list.isEmpty()) {
            callApi()
        } else {
            showList(list)
        }
    }

         */
    }

   /* private fun getListFromCache(): List<Card> {

    }*/


    private fun callApi() {
        val id = arguments?.getInt("id")
        Singletons.yugiApi.getYugiList().enqueue(object : Callback<YugiohResponse> {
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
                   /* showList(YugiohResponse.data)*/
                }
            }

        })
    }

   /* private fun showList(YugiohResponse: List<Card>) {
        adapter.updateList(YugiohResponse)
    }*/


    private fun onClikedCard(id: Int) {
        findNavController().navigate(R.id.navigateToCardDetailFragment, bundleOf(
            "cardId" to id,
        ))
    }
}