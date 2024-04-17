package com.example.dummy.data

import retrofit2.http.GET
import retrofit2.http.Path

interface ProductApiService {
    @GET("products/{id}")
    suspend fun getProductById(@Path("id") id: Int): Product
}