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
    private lateinit var textViewType: TextView
    private lateinit var ImageView: ImageView
    private lateinit var YugiLogo: ImageView



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
        textViewType = view.findViewById(R.id.card_detail_type)
        ImageView = view.findViewById(R.id.card_img)
        YugiLogo  = view.findViewById(R.id.yugi_logo)

        callApi()
    }

    private fun callApi() {
        val id = arguments?.getInt("cardId") ?: -1
        Singletons.yugiApi.getYugiDetail(id).enqueue(object : retrofit2.Callback<YugiohDetailResponse> {
            override fun onFailure(call: Call<YugiohDetailResponse>, t: Throwable) {
                //TODO("Not yet implemented")
            }

            override fun onResponse(
                        call: Call<YugiohDetailResponse>,
                    response: Response<YugiohDetailResponse>
            ) {
                if (response.isSuccessful && response.body() != null) {
                    // J'ai affiché le nom et la description derière l'image Yugioh mais en soit ça sert à rien, l'info est deja dans l'image de la carte
                    textViewName.text = response.body()!!.data[id].name
                    textViewType.text = response.body()!!.data[id].type

                    Glide
                            .with(ImageView)
                            .load(response.body()!!.data[id].card_images[0].image_url)
                            .centerCrop()
                            .into(ImageView);

                    Glide
                        .with(YugiLogo)
                        .load("https://www.logolynx.com/images/logolynx/8a/8a629aa27c090b4ec0d27fe78e63c8f5.jpeg")
                        .centerCrop()
                        .into(YugiLogo);

                }
            }
        })
    }
}