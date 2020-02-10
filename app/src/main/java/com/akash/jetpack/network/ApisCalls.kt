package com.akash.jetpack.network

import com.akash.jetpack.model.Post
import io.reactivex.Observable
import retrofit2.http.GET

interface ApisCalls {

    @GET("/posts")
    fun getPosts(): Observable<List<Post>>
}