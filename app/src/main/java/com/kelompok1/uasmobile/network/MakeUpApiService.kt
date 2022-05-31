package com.kelompok1.uasmobile.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

private const val BASE_URL = "https://makeup-api.herokuapp.com/api/v1/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface MakeUpApiService{
    @GET("product.json")
    suspend fun getDataEyebrow(@Query("product_type") kategori: String) : List<Eyebrow>

    @GET
    suspend fun etDataEyebrow(@Url kategori: String) : List<Eyebrow>
    @GET("product.json")
    suspend fun getDataEyeliner(@Query("product_type") kategori: String) : List<eyeliner>
    @GET("product.json")
    suspend fun getDataEyeshadow(@Query("product_type") kategori: String) : List<eyeshadow>
}
object MakeUpApi{
    val retrofitServiceApi : MakeUpApiService by lazy {
        retrofit.create(MakeUpApiService::class.java)
    }
}