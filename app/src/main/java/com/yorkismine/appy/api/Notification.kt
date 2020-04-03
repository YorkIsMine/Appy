package com.yorkismine.appy.api

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class Notification(
    @SerializedName("unread")
    @Expose
    var unread: Boolean? = null,

    @SerializedName("text")
    @Expose
    var text: String? = null,

    @SerializedName("img")
    @Expose
    var img: String? = null,

    @SerializedName("price")
    @Expose
    var price: Int? = null
)