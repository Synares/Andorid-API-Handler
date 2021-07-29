package com.knightsol.toolbox.Retrofit

import com.moiz.apihandler.Models.PostObject
import retrofit2.Call
import retrofit2.http.*
import kotlin.collections.ArrayList

/**
 * Created by Moiz Hassan on 28, July,2021
 */

interface APIInterface {

    @GET("posts")
    @Headers("Content-Type: application/json")
    fun getPosts (): Call<ArrayList<PostObject>>



}