package com.example.kuiper.viewmodel

import androidx.lifecycle.LiveData
import com.example.kuiper.model.NewsModel
import com.example.kuiper.utils.Utils

class KuiperViewModel {
    lateinit var refreshedNewsLiveData : LiveData<List<NewsModel>>
    fun getRefreshedNews(){
        val newsModel = NewsModel(Utils.generateRandomString())

    }
}