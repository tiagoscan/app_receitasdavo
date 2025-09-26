package com.mentoriaandroid.appreceitasdavo

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.io.Serializable

@Parcelize
data class Receita(
    val titulo: String,
    val tempo: String,
    val resIdImagem: Int,
    val ingredientes: List<String>
) : Parcelable



/*
data class Receita(
    val titulo: String,
    val tempo: String,
    val resIdImagem: Int
) : Serializable*/
