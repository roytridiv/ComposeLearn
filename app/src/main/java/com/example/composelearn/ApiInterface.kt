package com.example.composelearn

import com.example.composelearn.networkPojo.MoviesBodyResp
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiInterface {
    @GET("movielist.json")
    suspend fun getMovies() : List<MoviesBodyResp>

    companion object {
        var apiService: ApiInterface? = null
        fun getInstance() : ApiInterface {
            if (apiService == null) {
                apiService = Retrofit.Builder()
                    .baseUrl("https://howtodoandroid.com/apis/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build().create(ApiInterface::class.java)
            }
            return apiService!!
        }
    }
}