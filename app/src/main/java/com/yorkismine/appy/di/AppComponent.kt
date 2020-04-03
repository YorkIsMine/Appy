package com.yorkismine.appy.di

import com.yorkismine.appy.NotificationViewModel
import dagger.Component

@Component(modules = [NetworkModule::class])
interface AppComponent {
    fun inject(notificationViewModel: NotificationViewModel)
}