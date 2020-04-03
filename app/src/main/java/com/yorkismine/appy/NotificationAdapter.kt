package com.yorkismine.appy

import android.graphics.Color
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.yorkismine.appy.api.Notification
import de.hdodenhof.circleimageview.CircleImageView

class NotificationAdapter : RecyclerView.Adapter<NotificationAdapter.NotificationHolder>() {

    private val notifications = mutableListOf<Notification>()

    fun setData(list: List<Notification>) {
        notifications.addAll(list)
        notifyDataSetChanged()
    }

    class NotificationHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        fun bind(notification: Notification) {
            if (notification.unread!!) view.setBackgroundColor(view.resources.getColor(R.color.colorPrimaryLight))

            val notificationImage = view.findViewById<CircleImageView>(R.id.notification_image)
            Glide.with(view.context).load(notification.img).into(notificationImage)


            val notificationTitle = view.findViewById<TextView>(R.id.content_title)
            notificationTitle.text = Html.fromHtml(notification.text, Html.FROM_HTML_MODE_COMPACT)

            if (notification.price != 0) {
                val titlePrice = view.findViewById<TextView>(R.id.price)
                titlePrice.text = " -${notification.price.toString()} ₽"
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotificationHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.notification_item, parent, false)

        return NotificationHolder(view)
    }

    override fun getItemCount(): Int = notifications.size

    override fun onBindViewHolder(holder: NotificationHolder, position: Int) {
        holder.bind(notifications[position])
    }
}