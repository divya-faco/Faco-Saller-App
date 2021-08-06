package com.dm.facosallerapp.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.dm.facosallerapp.R
import com.dm.facosallerapp.activity.*

class HomeFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        var nav_icon : ImageView = view.findViewById(R.id.nav_icon);
        nav_icon.setOnClickListener { (activity as HomeActivity)?.openDrawer() }
        var notification_badge_counter: TextView = view.findViewById(R.id.notification_badge_counter)
        notification_badge_counter.setOnClickListener {
            startActivity(Intent(activity,NotificationActivity::class.java))
        }

        var btn_appointment : LinearLayout = view.findViewById(R.id.btn_appointment)
        btn_appointment.setOnClickListener {
            startActivity(Intent(activity,LabAppointmentActivity::class.java))
        }
        var btn_profile_page: LinearLayout = view.findViewById(R.id.btn_profile_page)
        btn_profile_page.setOnClickListener {
            startActivity(Intent(activity,LabProfileActivity::class.java))
        }
        var btn_patient_history: LinearLayout = view.findViewById(R.id.btn_patient_history)
        btn_patient_history.setOnClickListener {
            startActivity(Intent(activity,PatientHistoryActivity::class.java))
        }
        var btn_patient_feedback: LinearLayout = view.findViewById(R.id.btn_patient_feedback)
        btn_patient_feedback.setOnClickListener {
            startActivity(Intent(activity,PatientFeedbackActivity::class.java))
        }
        return view
    }

    override fun onResume() {
        super.onResume()
        (activity as AppCompatActivity).supportActionBar?.hide()
        activity?.window?.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
        requireActivity().window.setSoftInputMode(
            WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN
        )
    }
}