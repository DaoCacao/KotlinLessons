package com.example.lessonapp3.data.remote

import com.example.lessonapp3.data.model.BaseRaw
import com.example.lessonapp3.data.model.JediRaw
import retrofit2.http.GET
import retrofit2.http.Path

interface JediService {
@GET("people/?search={id}")
fun getJedi(@Path("id") id: Int): BaseRaw<List<JediRaw>>
}