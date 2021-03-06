package com.apptoko.app.data.remote


import com.apptoko.app.data.model.Surah
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface SurahService {
    @GET("/")
    fun Surah() : Call<List<Surah>>

    @GET("detail/")
    fun detailSurah(@Query("url") url: String) : Call<List<Surah>>

    @GET("search/")
    fun searchSurah(@Query("q") query: String) : Call<List<Surah>>
}