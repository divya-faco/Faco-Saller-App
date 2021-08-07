package com.dm.facosallerapp.activity

import android.app.TimePickerDialog
import android.app.TimePickerDialog.OnTimeSetListener
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.text.format.DateFormat
import android.view.View
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.core.graphics.drawable.DrawableCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dm.facosallerapp.Interface.WeekItemClickListener
import com.dm.facosallerapp.R
import com.dm.facosallerapp.adapter.WeekDayAdapter
import com.dm.facosallerapp.model.WeekModel
import com.dm.facosallerapp.utils.ToastCustom
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class SetAvailabilityActivity : AppCompatActivity(),WeekDayAdapter.OnItemClickListener {

    lateinit var days_recycler: RecyclerView
    val weekdayList = ArrayList<WeekModel>()
    lateinit var weekAdapter: WeekDayAdapter
    lateinit var yes_radiobutton : RadioButton
    lateinit var radio_group : RadioGroup
    lateinit var availabe_radio_button : RadioButton
    lateinit var available_layout : LinearLayout
    lateinit var appoint_slot_layout : LinearLayout
    lateinit var not_available_layout : LinearLayout
    var updateTime : Boolean = false
    lateinit var et_from_time : TextView
    lateinit var et_to_time : TextView
    var from_mon_time : String = ""
    var from_tue_time : String = ""
    var from_wed_time : String = ""
    var from_thu_time : String = ""
    var from_fri_time : String = ""
    var from_sat_time : String = ""
    var from_sun_time : String = ""
    var to_mon_time : String = ""
    var to_tue_time : String = ""
    var to_wed_time : String = ""
    var to_thu_time : String = ""
    var to_fri_time : String = ""
    var to_sat_time : String = ""
    var to_sun_time : String = ""
    lateinit var txt_monday : TextView
    lateinit var txt_tuesday : TextView
    lateinit var txt_wensday : TextView
    lateinit var txt_thusday : TextView
    lateinit var txt_friday : TextView
    lateinit var txt_saturday : TextView
    lateinit var txt_sunday : TextView
    var mHour:Int = 0
    var mHour2:Int = 0
    var mMinute:Int = 0
    var mMinute2:Int = 0
    lateinit var datePickerButton: Button
    var mWeekItemClickListener : WeekItemClickListener ?= null

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_set_availability)

        findID()
        var back_button: ImageButton = findViewById(R.id.back_button)
        back_button.setOnClickListener { finish() }

        days_recycler = findViewById(R.id.days_recycler)
        days_recycler.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        weekAdapter = WeekDayAdapter(this, weekdayList,this)
        days_recycler.adapter = weekAdapter
        getAllDate()

        available_layout.visibility = View.VISIBLE
        val sdf_ = SimpleDateFormat("EEEE")
        val date = Date()
        val days_Name = sdf_.format(date)

        when (days_Name) {
            "Monday" -> setAppointmentSlot("Monday")
            "Tuesday" -> setAppointmentSlot("Tuesday")
            "Wednesday" -> setAppointmentSlot("Wednesday")
            "Thursday" -> setAppointmentSlot("Thursday")
            "Friday" -> setAppointmentSlot("Friday")
            "Saturday" -> setAppointmentSlot("Saturday")
            "Sunday" -> setAppointmentSlot("Sunday")
        }
    }

    private fun findID() {
        yes_radiobutton = findViewById(R.id.yes_radiobutton)
        radio_group = findViewById(R.id.radio_group)
        available_layout = findViewById(R.id.available_layout)
        appoint_slot_layout = findViewById(R.id.appoint_slot_layout)
        not_available_layout = findViewById(R.id.not_available_layout)
        et_from_time = findViewById(R.id.et_from_time)
        et_to_time = findViewById(R.id.et_to_time)
        txt_monday = findViewById(R.id.txt_monday)
        txt_tuesday = findViewById(R.id.txt_tuesday)
        txt_wensday = findViewById(R.id.txt_wensday)
        txt_thusday = findViewById(R.id.txt_thusday)
        txt_friday = findViewById(R.id.txt_friday)
        txt_saturday = findViewById(R.id.txt_saturday)
        txt_sunday = findViewById(R.id.txt_sunday)
        datePickerButton = findViewById(R.id.datePickerButton)
    }

    private fun getAllDate() {
        val fmt = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)
        val fmt2 = SimpleDateFormat("dd", Locale.ENGLISH)
        val monthFormatter = SimpleDateFormat("MMMM", Locale.ENGLISH)
        val monthyear = SimpleDateFormat("MMM yyyy", Locale.ENGLISH)
        val selectedDateFormatter = SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH)
        val cal = Calendar.getInstance()
        val year = cal[Calendar.YEAR]
        val month = cal[Calendar.MONTH]
        val ct_date = cal[Calendar.DATE]
        val toDay = fmt.format(cal.time)
        var position = -1
        var currentDay = 0
        cal.clear()
        cal[year, month] = ct_date
        weekdayList.clear()
        for (i in 0..6) {
            val day = cal[Calendar.DAY_OF_WEEK]
            var dayName = ""
            var full_days_Name = ""
            val date = fmt.format(cal.time)
            val date2 = fmt2.format(cal.time)
            val mnt_year = monthyear.format(cal.time)
            when (day) {
                Calendar.SUNDAY -> {
                    dayName = "SUN"
                    full_days_Name = "SUNDAY"
                    currentDay = Calendar.SUNDAY
                }
                Calendar.MONDAY -> {
                    dayName = "MON"
                    full_days_Name = "MONDAY"
                    currentDay = Calendar.MONDAY
                }
                Calendar.TUESDAY -> {
                    dayName = "TUE"
                    full_days_Name = "TUESDAY"
                    currentDay = Calendar.TUESDAY
                }
                Calendar.WEDNESDAY -> {
                    dayName = "WED"
                    full_days_Name = "WEDNESDAY"
                    currentDay = Calendar.WEDNESDAY
                }
                Calendar.THURSDAY -> {
                    dayName = "THU"
                    full_days_Name = "THURSDAY"
                    currentDay = Calendar.THURSDAY
                }
                Calendar.FRIDAY -> {
                    dayName = "FRI"
                    full_days_Name = "FRIDAY"
                    currentDay = Calendar.FRIDAY
                }
                Calendar.SATURDAY -> {
                    dayName = "SAT"
                    full_days_Name = "SATURDAY"
                    currentDay = Calendar.SATURDAY
                }
            }
            val model = WeekModel(dayName)
            model.date = date2
            if (toDay == date && position == -1) {
                position = i
                model.isToday = true
                val currentDayMonth = selectedDateFormatter.format(cal.time)

                datePickerButton.text = mnt_year
            }
            model.currentDateName = selectedDateFormatter.format(cal.time)
            model.month = monthFormatter.format(cal.time)
            model.full_day_name = full_days_Name
            model.currentDay = currentDay
            model.mnt_year = mnt_year
            model.setAppointmentDate = date
            weekdayList.add(model)
            cal.add(Calendar.DAY_OF_MONTH, 1)
        }
        weekAdapter.addItems(weekdayList)
        days_recycler.scrollToPosition(position)
    }


    private fun setAppointmentSlot(dayName: String) {
        yes_radiobutton.setChecked(true)
        radio_group.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener { group: RadioGroup, checkedId: Int ->
            availabe_radio_button = group.findViewById<RadioButton>(checkedId)
            val index = group.indexOfChild(availabe_radio_button)
            when (index) {
                0 -> {
                    available_layout.setVisibility(View.VISIBLE)
                    appoint_slot_layout.setVisibility(View.VISIBLE)
                    not_available_layout.setVisibility(View.GONE)
                }
                1 -> {
                    not_available_layout.setVisibility(View.GONE)
                    available_layout.setVisibility(View.GONE)
                    appoint_slot_layout.setVisibility(View.VISIBLE)
                    when (dayName) {
                        "MON", "Monday" -> {
                            updateTime = true
                            et_from_time.setText("")
                            et_to_time.setText("")
                            from_mon_time = ""
                            to_mon_time = ""
                            txt_monday.setText("M")
                            DrawableCompat.setTint(
                                DrawableCompat.wrap(txt_monday.getBackground()),
                                getColor(R.color.purple_500)
                            )
                            txt_monday.setTextColor(getColor(R.color.white))
                        }
                        "TUE", "Tuesday" -> {
                            updateTime = true
                            et_from_time.setText("")
                            et_to_time.setText("")
                            from_tue_time = ""
                            to_tue_time = ""
                            txt_tuesday.setText("T")
                            txt_tuesday.setTextColor(getColor(R.color.white))
                            DrawableCompat.setTint(
                                DrawableCompat.wrap(txt_tuesday.getBackground()),
                                getColor(R.color.purple_500)
                            )
                        }
                        "WED", "Wednesday" -> {
                            updateTime = true
                            et_from_time.setText("")
                            et_to_time.setText("")
                            from_wed_time = ""
                            to_wed_time = ""
                            txt_wensday.setText("W")
                            txt_wensday.setTextColor(getColor(R.color.white))
                            DrawableCompat.setTint(
                                DrawableCompat.wrap(txt_wensday.getBackground()),
                                getColor(R.color.purple_500)
                            )
                        }
                        "THU", "Thursday" -> {
                            updateTime = true
                            et_from_time.setText("")
                            et_to_time.setText("")
                            from_thu_time = ""
                            to_thu_time = ""
                            txt_thusday.setText("T")
                            DrawableCompat.setTint(
                                DrawableCompat.wrap(txt_thusday.getBackground()),
                                getColor(R.color.purple_500)
                            )
                            txt_thusday.setTextColor(getColor(R.color.white))
                        }
                        "FRI", "Friday" -> {
                            updateTime = true
                            et_from_time.setText("")
                            et_to_time.setText("")
                            from_fri_time = ""
                            to_fri_time = ""
                            txt_friday.setText("F")
                            txt_friday.setTextColor(getColor(R.color.white))
                            DrawableCompat.setTint(
                                DrawableCompat.wrap(txt_friday.getBackground()),
                                getColor(R.color.purple_500)
                            )
                        }
                        "SAT", "Saturday" -> {
                            updateTime = true
                            et_from_time.setText("")
                            et_to_time.setText("")
                            from_sat_time = ""
                            to_sat_time = ""
                            txt_saturday.setText("S")
                            txt_saturday.setTextColor(getColor(R.color.white))
                            DrawableCompat.setTint(
                                DrawableCompat.wrap(txt_saturday.getBackground()),
                                getColor(R.color.purple_500)
                            )
                        }
                        "SUN", "Sunday" -> {
                            updateTime = true
                            et_from_time.setText("")
                            et_to_time.setText("")
                            from_sun_time = ""
                            to_sun_time = ""
                            txt_sunday.setText("S")
                            txt_sunday.setTextColor(getColor(R.color.white))
                            DrawableCompat.setTint(
                                DrawableCompat.wrap(txt_sunday.getBackground()),
                                getColor(R.color.purple_500)
                            )
                        }
                    }
                }
            }
        })
        et_from_time.setOnClickListener {
            val timePickerDialog1 = TimePickerDialog(
                this,
                { view: TimePicker?, hourOfDay: Int, minute: Int ->
                    mHour = hourOfDay
                    mMinute = minute
                    val calendar = Calendar.getInstance()
                    calendar[0, 0, 0, mHour] = mMinute
                    et_from_time.setText(DateFormat.format("hh:mm aa", calendar))
                    when (dayName) {
                        "MON", "Monday" -> from_mon_time =
                            DateFormat.format("hh:mm aa", calendar) as String
                        "TUE", "Tuesday" -> from_tue_time =
                            DateFormat.format("hh:mm aa", calendar) as String
                        "WED", "Wednesday" -> from_wed_time =
                            DateFormat.format("hh:mm aa", calendar) as String
                        "THU", "Thursday" -> from_thu_time =
                            DateFormat.format("hh:mm aa", calendar) as String
                        "FRI", "Friday" -> from_fri_time =
                            DateFormat.format("hh:mm aa", calendar) as String
                        "SAT", "Saturday" -> from_sat_time =
                            DateFormat.format("hh:mm aa", calendar) as String
                        "SUN", "Sunday" -> from_sun_time =
                            DateFormat.format("hh:mm aa", calendar) as String
                    }
                }, 12, 0, false
            )
            timePickerDialog1.show()
        }
        et_to_time.setOnClickListener{
            if (TextUtils.isEmpty(et_from_time.getText().toString().trim { it <= ' ' })) {
//                ToastCustom.toastInfoBottom(this, "Set Your First Slot Time !!!")
                et_from_time.setError("Set Appointment")
                et_from_time.setFocusable(true)
            } else {
                et_from_time.setError(null)
                et_from_time.setFocusable(false)
                val timePickerDialog = TimePickerDialog(
                    this,
                    { view: TimePicker?, hourOfDay: Int, minute: Int ->
                        mHour2 = hourOfDay
                        mMinute2 = minute
                        val calendar = Calendar.getInstance()
                        calendar[0, 0, 0, mHour2] = mMinute2
                        et_to_time.setText(DateFormat.format("hh:mm aa", calendar))
                        when (dayName) {
                            "MON", "Monday" -> {
                                updateTime = true
                                to_mon_time = DateFormat.format("hh:mm aa", calendar) as String
                                txt_monday.setText("M")
                                DrawableCompat.setTint(
                                    DrawableCompat.wrap(txt_monday.getBackground()),
                                    getColor(R.color.purple_500)
                                )
                                txt_monday.setTextColor(getColor(R.color.white))
                            }
                            "TUE", "Tuesday" -> {
                                updateTime = true
                                to_tue_time = DateFormat.format(
                                    "hh:mm aa",
                                    calendar
                                ) as String
                                txt_tuesday.setText("T")
                                txt_tuesday.setTextColor(getColor(R.color.white))
                                DrawableCompat.setTint(
                                    DrawableCompat.wrap(txt_tuesday.getBackground()),
                                    getColor(R.color.purple_500)
                                )
                            }
                            "WED", "Wednesday" -> {
                                updateTime = true
                                to_wed_time = DateFormat.format(
                                    "hh:mm aa",
                                    calendar
                                ) as String
                                txt_wensday.setText("W")
                                txt_wensday.setTextColor(getColor(R.color.white))
                                DrawableCompat.setTint(
                                    DrawableCompat.wrap(txt_wensday.getBackground()),
                                    getColor(R.color.purple_500)
                                )
                            }
                            "THU", "Thursday" -> {
                                updateTime = true
                                to_thu_time = DateFormat.format(
                                    "hh:mm aa",
                                    calendar
                                ) as String
                                txt_thusday.setText("T")
                                txt_thusday.setTextColor(getColor(R.color.white))
                                DrawableCompat.setTint(
                                    DrawableCompat.wrap(txt_thusday.getBackground()),
                                    getColor(R.color.purple_500)
                                )
                            }
                            "FRI", "Friday" -> {
                                updateTime = true
                                to_fri_time = DateFormat.format(
                                    "hh:mm aa",
                                    calendar
                                ) as String
                                txt_friday.setText("F")
                                txt_friday.setTextColor(getColor(R.color.white))
                                DrawableCompat.setTint(
                                    DrawableCompat.wrap(txt_friday.getBackground()),
                                    getColor(R.color.purple_500)
                                )
                            }
                            "SAT", "Saturday" -> {
                                updateTime = true
                                to_sat_time = DateFormat.format(
                                    "hh:mm aa",
                                    calendar
                                ) as String
                                txt_saturday.setText("S")
                                txt_saturday.setTextColor(getColor(R.color.white))
                                DrawableCompat.setTint(DrawableCompat.wrap(txt_saturday.getBackground()),
                                    getColor(R.color.purple_500)
                                )
                            }
                            "SUN", "Sunday" -> {
                                updateTime = true
                                to_sun_time = DateFormat.format(
                                    "hh:mm aa",
                                    calendar
                                ) as String
                                txt_sunday.setText("S")
                                txt_sunday.setTextColor(getColor(R.color.white))
                                DrawableCompat.setTint(DrawableCompat.wrap(txt_sunday.getBackground()),
                                    getColor(R.color.purple_500)
                                )
                            }
                        }
                    }, 12, 0, false
                )
                timePickerDialog.show()
            }
        }
    }

    override fun getOnItemClick(model: WeekModel) {
        datePickerButton.text = model.mnt_year

        if (mWeekItemClickListener != null) {
            mWeekItemClickListener?.onGetItem(model)
        }
        Toast.makeText(this,"Position"+model.date,Toast.LENGTH_SHORT).show()

        val name_day: String? = model.dayName
//        if (isSignUP == false) {
//            if (!getTime.isEmpty()) if (updateTime == false) getDrTimeData(name_day)
//        }
        when (name_day) {
            "MON" -> {
                if (from_mon_time.isEmpty() && to_mon_time.isEmpty()) {
                    et_from_time.text = ""
                    et_to_time.text = ""
                } else {
                    et_to_time.text = to_mon_time
                    et_from_time.text = from_mon_time
                }
                setAppointmentSlot("MON")
            }
            "TUE" -> {
                if (from_tue_time.isEmpty() && to_tue_time.isEmpty()) {
                    et_from_time.text = ""
                    et_to_time.text = ""
                } else {
                    et_from_time.text = from_tue_time
                    et_to_time.text = to_tue_time
                }
                setAppointmentSlot("TUE")
            }
            "WED" -> {
                if (from_wed_time.isEmpty() && to_wed_time.isEmpty()) {
                    et_from_time.text = ""
                    et_to_time.text = ""
                } else {
                    et_to_time.text = to_wed_time
                    et_from_time.text = from_wed_time
                }
                setAppointmentSlot("WED")
            }
            "THU" -> {
                if (from_thu_time.isEmpty() && to_thu_time.isEmpty()) {
                    et_from_time.text = ""
                    et_to_time.text = ""
                } else {
                    et_to_time.text = to_thu_time
                    et_from_time.text = from_thu_time
                }
                setAppointmentSlot("THU")
            }
            "FRI" -> {
                if (from_fri_time.isEmpty() && to_fri_time.isEmpty()) {
                    et_from_time.text = ""
                    et_to_time.text = ""
                } else {
                    et_to_time.text = to_fri_time
                    et_from_time.text = from_fri_time
                }
                setAppointmentSlot("FRI")
            }
            "SAT" -> {
                if (from_sat_time.isEmpty() && to_sat_time.isEmpty()) {
                    et_from_time.text = ""
                    et_to_time.text = ""
                } else {
                    et_to_time.text = to_sat_time
                    et_from_time.text = from_sat_time
                }
                setAppointmentSlot("SAT")
            }
            "SUN" -> {
                if (from_sun_time.isEmpty() && to_sun_time.isEmpty()) {
                    et_from_time.text = ""
                    et_to_time.text = ""
                } else {
                    et_to_time.text = to_sun_time
                    et_from_time.text = from_sun_time
                }
                setAppointmentSlot("SUN")
            }
        }
    }


}