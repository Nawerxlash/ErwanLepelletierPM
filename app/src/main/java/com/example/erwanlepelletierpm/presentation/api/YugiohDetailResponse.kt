package com.example.erwanlepelletierpm.presentation.api

import com.example.erwanlepelletierpm.presentation.list.Card

data class YugiohDetailResponse (
    val data: List<CardInfo>
)

data class CardInfo (
        val name: String,
        val id : Int,
        val type: String,
        val desc: String,
        val archetype: String,
        val card_Images: List<ImageSet>
)

data class ImageSet(
    val idImg: Int,
    val image_Url: String,
    val image_Url_Small: String
)