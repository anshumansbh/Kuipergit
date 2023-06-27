package com.example.kuiper.model

import android.os.Parcel
import android.os.Parcelable

data class NewsModel(var x: String) : Parcelable {
    var headline: String? = null
    var newsBody: String? = null
    var newsImageUrl: String? = null
    var newsFooter: String? = null

    constructor(parcel: Parcel) : this("ll") {
        headline = parcel.readString()
        newsBody = parcel.readString()
        newsImageUrl = parcel.readString()
        newsFooter = parcel.readString()
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
