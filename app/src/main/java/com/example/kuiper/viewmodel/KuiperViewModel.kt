package com.example.kuiper.viewmodel

import androidx.lifecycle.LiveData
import com.example.kuiper.model.NewsModel

class KuiperViewModel {
    lateinit var refreshedNewsLiveData : LiveData<List<NewsModel>>
    fun getRefreshedNews(){
        val newsModel = NewsModel("d")
        newsModel.headline = "dasf"
    }
}