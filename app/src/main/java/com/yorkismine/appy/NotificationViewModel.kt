package com.yorkismine.appy

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.yorkismine.appy.api.ApiService
import com.yorkismine.appy.api.Notification
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class NotificationViewModel : ViewModel() {
    private val _notifications: MutableLiveData<List<Notification>> = MutableLiveData()
    val notifications: LiveData<List<Notification>> get() = _notifications
    private val disposables = CompositeDisposable()

    init {
        MainApp.injector.inject(this)
    }

    @Inject
    lateinit var apiService: ApiService

    @SuppressLint("CheckResult")
    fun getData(): LiveData<List<Notification>> {
        apiService.getNotificationList()
            .subscribeOn(Schedulers.io())
            .subscribe(
                { result -> _notifications.postValue(result) },
                { t -> t.printStackTrace() })

        return _notifications
    }



    override fun onCleared() {
        super.onCleared()

        disposables.dispose()
    }
}