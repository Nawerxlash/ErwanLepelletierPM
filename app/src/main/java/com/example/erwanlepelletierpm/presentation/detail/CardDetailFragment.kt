package com.example.erwanlepelletierpm.presentation.detail

import YugiAdapter
import android.accounts.AuthenticatorDescription
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.erwanlepelletierpm.R
import com.example.erwanlepelletierpm.presentation.Singletons
import com.example.erwanlepelletierpm.presentation.api.YugiohDetailResponse
import com.example.erwanlepelletierpm.presentation.api.YugiohResponse
import com.example.erwanlepelletierpm.presentation.list.Card
import retrofit2.Call
import retrofit2.Response

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class CardDetailFragment : Fragment() {



    private lateinit var textViewName: TextView
    private lateinit var textViewDescription: TextView
    private lateinit var textViewType: TextView
    private lateinit var textViewArchetype: TextView
    private lateinit var ImageView: ImageView

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_card_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        textViewName = view.findViewById(R.id.card_detail_name)
        textViewDescription = view.findViewById(R.id.card_detail_description)
        textViewType = view.findViewById(R.id.card_detail_type)
        textViewArchetype = view.findViewById(R.id.card_detail_archetype)
        ImageView = view.findViewById(R.id.card_img)


        callApi()
    }

    private fun callApi() {
        val id = arguments?.getInt("cardId") ?: -1
        Singletons.yugiApi.getYugiDetail(id.toString()).enqueue(object : retrofit2.Callback<YugiohDetailResponse> {
            override fun onFailure(call: Call<YugiohDetailResponse>, t: Throwable) {
                //TODO("Not yet implemented")
            }

            override fun onResponse(
                        call: Call<YugiohDetailResponse>,
                    response: Response<YugiohDetailResponse>
            ) {
                if (response.isSuccessful && response.body() != null) {
                    textViewName.text = response.body()!!.data[id].name
                    textViewDescription.text = response.body()!!.data[id].desc
                    textViewType.text = response.body()!!.data[id].type
                    textViewArchetype.text = response.body()!!.data[id].archetype

                    /*Glide
                            .with(ImageView)
                            .load(response.body()!!.data[0].card_Images[0].image_Url)
                            .centerCrop()
                            .into(ImageView);*/

                }
            }
        })
    }
}