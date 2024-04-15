package com.example.dummy.data

import retrofit2.http.GET

interface ProductApiService {
    @GET("products/1")
    suspend fun getProductById(): Product
}