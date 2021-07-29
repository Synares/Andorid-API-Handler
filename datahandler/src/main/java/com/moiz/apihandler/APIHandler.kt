package com.moiz.apihandler

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.knightsol.toolbox.Retrofit.APIClient
import com.knightsol.toolbox.Retrofit.APIInterface
import com.moiz.apihandler.Models.PostObject
import com.moiz.apihandler.Retrofit.APICallbacks
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.math.MathContext

/**
 * Created by Moiz Hassan on 28,July,2021
 */


class APIHandler {

    companion object{

        fun fetchPosts(callbacks : APICallbacks?) {
            var postList : ArrayList<PostObject> = arrayListOf()
            val apiInterface: APIInterface = APIClient.getClient().create(APIInterface::class.java)
            postList.clear()
            val call1: Call<ArrayList<PostObject>> = apiInterface.getPosts()
            call1.enqueue(object : Callback<ArrayList<PostObject>> {
                override fun onResponse(
                    call: Call<ArrayList<PostObject>>,
                    response: Response<ArrayList<PostObject>>
                ) {
                    if(response.isSuccessful){
                        postList = response.body()!!
                    }
                    callbacks?.onSuccess(postList)
                }

                override fun onFailure(call: Call<ArrayList<PostObject>>, t: Throwable) {
                    call.cancel()
                    callbacks?.onError(t)
                    Log.d("myAPIResultViews", t.message.toString())
                }
            })
        }

    }

}