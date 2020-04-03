package com.yorkismine.appy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_notification.*

class NotificationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification)

        val unreadAdapter = NotificationAdapter()
        val readAdapter = NotificationAdapter()

        back_btn.setOnClickListener {
            finish()
        }

        unread.layoutManager = LinearLayoutManager(this)
        unread.adapter = unreadAdapter

        recent.layoutManager = LinearLayoutManager(this)
        recent.adapter = readAdapter

        val viewModel = ViewModelProviders.of(this).get(NotificationViewModel::class.java)

        viewModel.getData().observe(this, Observer { list ->
            progress_bar.visibility = View.GONE
            val unreadList = list.filter { it.unread!! }
            val readList = list.filter { !it.unread!! }
            readAdapter.setData(readList)
            unreadAdapter.setData(unreadList)
        })
    }
}
