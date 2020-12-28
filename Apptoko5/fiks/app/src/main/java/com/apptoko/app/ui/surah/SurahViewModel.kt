package com.apptoko.app.ui.surah

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.apptoko.app.data.model.ActionState
import com.apptoko.app.data.model.Surah
import com.apptoko.app.data.repository.SurahRepository
import kotlinx.coroutines.launch

class SurahViewModel : ViewModel() {
    private val repo: SurahRepository by lazy { SurahRepository() }

    val loading = MutableLiveData(false)
    val actionState = MutableLiveData<ActionState<*>>()

    val listResp = MutableLiveData<List<Surah>>()
    val detailResp = MutableLiveData<Surah>()
    val searhResp = MutableLiveData<List<Surah>>()

    val url = MutableLiveData("")
    val query = MutableLiveData("")

    fun listSurah() {
        viewModelScope.launch {
            loading.value = true
            val resp = repo.Surah()
            actionState.value = resp
            listResp.value = resp.data
            loading.value = false
        }
    }
    fun detailSurah(url: String? = this.url.value) {
        url?.let {
            viewModelScope.launch {
                loading.value = true
                val resp = repo.detailSurah(it)
                actionState.value = resp
                detailResp.value = resp.data
                loading.value = false

            }
        }
    }
    fun searchSurah(query: String? = this.query.value) {
        query?.let {
            viewModelScope.launch {
                loading.value = true
                val resp = repo.searchSurah(it)
                actionState.value = resp
                searhResp.value = resp.data
                loading.value = false
            }
        }
    }
}