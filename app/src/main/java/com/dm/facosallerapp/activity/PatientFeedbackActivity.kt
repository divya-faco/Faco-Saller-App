package com.dm.facosallerapp.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dm.facosallerapp.R
import com.dm.facosallerapp.adapter.PatientFeedbcakAdapter
import com.dm.facosallerapp.model.ShowPrescriptionModel

class PatientFeedbackActivity : AppCompatActivity() {
    val patient_feedbackList = ArrayList<ShowPrescriptionModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_patient_feedback)

        var back_button : ImageButton = findViewById(R.id.back_button)
        back_button.setOnClickListener { finish() }
        var custom_toolabar_title : TextView = findViewById(R.id.custom_toolabar_title)
        custom_toolabar_title.text = "Patient Feedbcak"

        var feedback_recyclerview : RecyclerView = findViewById(R.id.feedback_recyclerview)
        feedback_recyclerview.layoutManager = LinearLayoutManager(this)
        val patient_adapter = PatientFeedbcakAdapter(patient_feedbackList)
        feedback_recyclerview.adapter = patient_adapter
    }

    override fun onResume() {
        super.onResume()
        patientFeedbackData()
    }

    override fun onPause() {
        super.onPause()
        patient_feedbackList.clear()
    }
    fun patientFeedbackData(){
        patient_feedbackList.add(ShowPrescriptionModel("A","","","XYZ"))
        patient_feedbackList.add(ShowPrescriptionModel("B","","","ABC"))
        patient_feedbackList.add(ShowPrescriptionModel("C","","","JKL"))
    }
}