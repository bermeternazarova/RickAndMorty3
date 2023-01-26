package com.example.rickandmorty3.model

data class Characters(
    val info: Info,
    val results: List<Result>
):java.io.Serializable