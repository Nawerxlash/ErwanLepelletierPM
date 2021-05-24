package com.example.erwanlepelletierpm.presentation.api

import com.example.erwanlepelletierpm.presentation.list.Card

data class YugiohDetailResponse (
    val data: List<CardInfo>
)

data class CardInfo (
        val name: String,
        val id : Int,
        val type: String,
        val card_images: List<ImageSet>
)

data class ImageSet(
    val image_url: String,
    val image_url_small: String
)