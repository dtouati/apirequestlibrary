package com.djamel.apirequestlibrary


import com.djamel.apirequestlibrary.Model.RateMovie
import com.djamel.apirequestlibrary.Model.WapperDetailsMovie
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface MoviesService {
    @GET("popular?api_key=d707987cde0dea1f51036f521ed41b37")
    fun listMovies(): Call<WapperMovie>

    @GET("{id}?api_key=d707987cde0dea1f51036f521ed41b37")
    fun detailsMovie(@Path("id") id: Int? ): Call<WapperDetailsMovie>

    @POST("15322/5/api_key=d707987cde0dea1f51036f521ed41b37")
    fun rate() : Call<RateMovie>

}