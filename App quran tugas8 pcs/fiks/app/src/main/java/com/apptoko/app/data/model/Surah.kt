package com.apptoko.app.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Surah (
    val arti: String = "",
    val audio: String = "",
    val ayat: String = "",
    val keterangan: String = "",
    val nama: String = "",
    val nomor: String = "",
    val type: String = "",
    val urut: String = ""
) : Parcelable