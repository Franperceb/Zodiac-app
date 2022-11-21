package com.example.zodiac_app.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    var name: String?,
    var account_number: Int?,
    var birth: String?,
    var age: String?,
    var email: String?,
    var horoscope: String?,
    var chineseHoroscope: String?,
): Parcelable
