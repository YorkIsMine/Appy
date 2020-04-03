package com.yorkismine.appy.api

import io.reactivex.Single
import retrofit2.http.GET

interface ApiService {
    @GET("/v2/5e85a947300000290097b2b4?mocky-delay=2000ms")
    fun getNotificationList(): Single<List<Notification>>
}