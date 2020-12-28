package com.apptoko.app.data.repository

import com.apptoko.app.data.model.ActionState
import com.apptoko.app.data.model.Surah
import com.apptoko.app.data.remote.RetrofitApi
import com.apptoko.app.data.remote.SurahService
import retrofit2.await
import java.lang.Exception

class SurahRepository {
    private val surahService: SurahService by lazy { RetrofitApi.surahService() }

    suspend fun Surah() : ActionState<List<Surah>> {
       return try {
            val list = surahService.Surah().await()
            ActionState(list)

        } catch (e: Exception){
            ActionState(message = e.message, isSuccess = false)
        }
    }

    suspend fun detailSurah(url: String) : ActionState<Surah> {
        return try {
            val list = surahService.detailSurah(url).await()
            ActionState(list.first())

        } catch (e: Exception) {
            ActionState(message = e.message, isSuccess = false)
        }
    }

    suspend fun searchSurah(query: String) : ActionState<List<Surah>> {
      return try {
            val list = surahService.searchSurah(query).await()
            ActionState(list)

        } catch (e: Exception) {
            ActionState(message = e.message, isSuccess = false)
        }
    }
}