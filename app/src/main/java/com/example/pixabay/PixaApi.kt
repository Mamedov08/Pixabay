package com.example.pixabay

import retrofit2.http.GET
import retrofit2.http.Query

interface PixaApi {

    @GET("api/")

    fun searchImage(@Query("q") keyWord: String,
                    @Query("page") page: Int,
                    @Query("per_page") per_page: Int = 6,
                    @Query("key") key: String ="28283066-0ec69652eb612ae95db3e1a9a"

    ) :retrofit2.Call<PixaModel>
}