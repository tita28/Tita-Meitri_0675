package com.apptoko.app.ui.auth

import android.content.Context
import com.apptoko.app.data.model.ActionState
import com.apptoko.app.data.repository.AuthRepository
import kotlinx.coroutines.*

object ApptokoAuth {

    fun logout(context: Context, callback: ((ActionState<Boolean>) -> Unit)? = null) {
        val repo = AuthRepository(context)
        CoroutineScope(Dispatchers.IO).launch {
            val resp = repo.logout()
            withContext(Dispatchers.Main) {
                if (callback !=null) callback.invoke(resp)
            }
        }
    }
}