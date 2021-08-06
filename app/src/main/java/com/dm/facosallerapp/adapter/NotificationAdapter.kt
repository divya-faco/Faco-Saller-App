package com.dm.facosallerapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dm.facosallerapp.R
import com.dm.facosallerapp.model.NotificationModel

class NotificationAdapter(val notificationList : ArrayList<NotificationModel>) : RecyclerView.Adapter<NotificationAdapter.ViewHolder>() {

    class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {
        val notification_time : TextView = itemView.findViewById(R.id.notification_time)
        val notification_image : ImageView = itemView.findViewById(R.id.notification_image)
        val notification_title : TextView = itemView.findViewById(R.id.notification_title)
        val notification_attribute : TextView = itemView.findViewById(R.id.notification_attribute)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.notification_layout,parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val NotificationModel = notificationList[position]
        holder.notification_title.text = NotificationModel.notification_title
        holder.notification_attribute.text = NotificationModel.notification_order
        holder.notification_time.text = NotificationModel.notification_st_date
    }

    override fun getItemCount(): Int {
        return notificationList.size
    }
}