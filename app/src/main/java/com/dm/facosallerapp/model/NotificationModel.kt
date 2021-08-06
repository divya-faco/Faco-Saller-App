package com.dm.facosallerapp.model

data class NotificationModel(
    val notification_title:String,
    var notification_time: String? = null,
    var notification_st_date: String? = null,
    var notification_type: String? = null,
    var notification_order: String? = null,
    var notification_count: String? = null,
    var notification_image: String? = null,
    var notication_end_date: String? = null,
    var notication_id: String? = null,
    var data_id: String? = null,
    var notification_current_time: String? = null)
