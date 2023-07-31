package com.example.kuiper.model

import android.os.Parcel
import android.os.Parcelable

data class NewsModel(var id: String) : Parcelable {
    var headline: String? = null
    var newsBody: String? = null
    var newsImageUrl: String? = null
    var newsFooter: String? = null
    lateinit var newsID: String

    constructor(parcel: Parcel) : this("") {
        headline = parcel.readString()
        newsBody = parcel.readString()
        newsImageUrl = parcel.readString()
        newsFooter = parcel.readString()
        newsID = parcel.readString()!!
    }

    constructor(id: String, headline: String?, newsBody: String?, newsImageUrl: String?, newsFooter: String?) : this(id){
        this.headline = headline
        this.newsBody = newsBody
        this.newsFooter = newsFooter
        this.newsImageUrl = newsImageUrl
    }


//    inner class x{
//        fun y(){
//            var newsModel = NewsModel()
//            newsModel.headline = "dafjk"
//        }
//    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(headline)
        parcel.writeString(newsBody)
        parcel.writeString(newsImageUrl)
        parcel.writeString(newsFooter)
        parcel.writeString(newsID)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<NewsModel> {
        override fun createFromParcel(parcel: Parcel): NewsModel {
            return NewsModel(parcel)
        }

        override fun newArray(size: Int): Array<NewsModel?> {
            return arrayOfNulls(size)
        }
    }
}
