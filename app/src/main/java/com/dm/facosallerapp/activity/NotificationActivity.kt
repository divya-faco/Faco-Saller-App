package com.dm.facosallerapp.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dm.facosallerapp.R
import com.dm.facosallerapp.adapter.NotificationAdapter
import com.dm.facosallerapp.model.NotificationModel

class NotificationActivity : AppCompatActivity() {
    lateinit var no_item : LinearLayout
    lateinit var notification_recyclerview : RecyclerView
    var notification_list = ArrayList<NotificationModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification)

        no_item = findViewById(R.id.no_item)
        notification_recyclerview = findViewById(R.id.notification_recyclerview)

        var back_button : ImageButton = findViewById(R.id.back_button)
        back_button.setOnClickListener { finish() }
        var custom_toolabar_title : TextView = findViewById(R.id.custom_toolabar_title)
        custom_toolabar_title.text = "Notification"

        notification_recyclerview.layoutManager = LinearLayoutManager(this)
        val notification_adapter = NotificationAdapter(notification_list)
        notification_recyclerview.adapter = notification_adapter
    }

    override fun onResume() {
        super.onResume()
        showNotificationData()
        if (notification_list.isEmpty()){
            no_item.visibility = View.VISIBLE
        }else{
            no_item.visibility = View.GONE
        }
    }

    private fun showNotificationData() {
        notification_list.add(NotificationModel("A","","","","xyz"))
        notification_list.add(NotificationModel("B","","","","ABC"))
        notification_list.add(NotificationModel("C","","","","JKL"))
        notification_list.add(NotificationModel("D","","","","MNOP"))
    }
}