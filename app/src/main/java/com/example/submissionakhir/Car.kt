package com.example.submissionakhir
import android.os.Parcelable
import kotlinx.parcelize.Parcelize
@Parcelize
data class Car(
    val name: String,
    val description: String,
    val photo: String,
    val manufacture: String,
    val production: String
) : Parcelable
