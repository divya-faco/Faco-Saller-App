package com.dm.facosallerapp.model

data class WeekModel(
    var dayName: String? = null,
    var full_day_name: String? = null,

    var date: String? = null,

    var currentDateName: String? = null,

    var month: String? = null,

    var isToday: Boolean = false,

    var isHoliday: Boolean = false,

    var currentDay: Int = 0,

    var mnt_year: String? = null,

    var setAppointmentDate: String? = null
)
