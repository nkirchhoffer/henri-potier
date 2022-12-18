package fr.nkirchhoffer.library

import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

class HenriPotierService {

    private val retrofit: Retrofit
    private val api: Api

    init {
        retrofit = Retrofit.Builder().baseUrl("https://henri-potier.techx.fr/").addConverterFactory(GsonConverterFactory.create()).build()
        api = retrofit.create(Api::class.java)
    }

    fun getApi(): Api = api

    interface Api {
        @GET("books")
        fun listBooks(): Call<List<Book>>
    }

}