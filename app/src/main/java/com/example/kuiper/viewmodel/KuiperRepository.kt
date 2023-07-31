package com.example.kuiper.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.kuiper.model.NewsModel
import com.example.kuiper.utils.Utils
import com.example.kuiper.utils.getNewsURL


class KuiperRepository {
    lateinit var refreshedNewsLiveData : MutableLiveData<List<NewsModel>>

    fun callRefreshedNewsAPI(context: Context) : MutableLiveData<List<NewsModel>> {
        // Instantiate the RequestQueue.
        val queue = Volley.newRequestQueue(context)
        var newsImages = ArrayList<String?>()
        var refreshedNews = ArrayList<NewsModel>()

// Request for images
        val imageRequest = StringRequest(
            Request.Method.GET, getNewsURL,
            { response ->
                // Display the first 500 characters of the response string.
                newsImages.add(response.get(""))
            },
            { })


// Request a string response from the provided URL.
        val newsRequest = StringRequest(
            Request.Method.GET, getNewsURL,
            { response ->
                // Display the first 500 characters of the response string.
                refreshedNews.add(NewsModel(
                        Utils.generateRandomString(),
                        response.substring(0,40),
                        response.substring(41, 200),
                        response.substring(200,240)
                    ))
            },
            { })

// Add the request to the RequestQueue.
        queue.add(newsRequest)
        queue.add(imageRequest)
        return refreshedNewsLiveData
    }
}