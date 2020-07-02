package com.carol.podplay.repository

import com.carol.podplay.service.ItunesService
import com.carol.podplay.service.PodcastResponse
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class ItunesRepo(private val itunesService: ItunesService){
    fun searchByTerm(term:String, callBack: (List<PodcastResponse.ItunesPodcast>?) -> Unit){
        val podcastCall = itunesService.searchPodcastByTerm(term)

        podcastCall.enqueue(object : retrofit2.Callback<PodcastResponse> {
            override fun onFailure(call: Call<PodcastResponse>?,
                                   t:Throwable?){
                callBack(null)
            }
            override fun onResponse(
                call: Call<PodcastResponse>?,
                response: Response<PodcastResponse>?){
                val body = response?.body()
                callBack(body?.results)
            }

        })
    }
}