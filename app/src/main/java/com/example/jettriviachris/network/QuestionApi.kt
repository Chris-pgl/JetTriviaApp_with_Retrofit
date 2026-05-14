package com.example.jettriviachris.network

import com.example.jettriviachris.model.Question
import retrofit2.http.GET
import javax.inject.Singleton


@Singleton
interface QuestionApi {
    @GET("world.json")
    suspend fun getAllQuestions(): Question



}