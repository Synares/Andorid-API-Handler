package com.moiz.apihandler.Models

import com.google.gson.annotations.SerializedName

/**
 * Created by Moiz Hassan on 28, July,2021
 */

data class PostObject(

    @SerializedName("userId")
    var userId : Int,
    @SerializedName("id")
    var postId : Int,
    @SerializedName("title")
    var title : String,
    @SerializedName("body")
    var body : String

)
