package com.example.dummy.data


data class Product(
    val id: Int = 0,
    val title: String? = null,
    val description: String? = null,
    val price: Int = 0,
    val discountPercentage: Double = 0.0,
    val rating: Double = 0.0,
    val stock: Int = 0,
    val brand: String? = null,
    val category: String? = null,
    val thumbnail: String? = null,
    val images: ArrayList<String>? = null
)

