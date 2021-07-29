package com.moiz.apihandler.Retrofit

import com.moiz.apihandler.Models.PostObject

interface APICallbacks {
    fun onSuccess(value: ArrayList<PostObject>)
    fun onError(throwable: Throwable)
}