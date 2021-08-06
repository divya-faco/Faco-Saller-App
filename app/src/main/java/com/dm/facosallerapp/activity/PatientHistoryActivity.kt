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
import com.dm.facosallerapp.adapter.PatientHistoryAdapter
import com.dm.facosallerapp.model.ShowPrescriptionModel

class PatientHistoryActivity : AppCompatActivity() {

    lateinit var patient_history_recyclerview : RecyclerView
    lateinit var no_item :LinearLayout
    val patient_historyList = ArrayList<ShowPrescriptionModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_patient_history)

        var back_button : ImageButton = findViewById(R.id.back_button)
        back_button.setOnClickListener { finish() }
        var custom_toolabar_title : TextView = findViewById(R.id.custom_toolabar_title)
        custom_toolabar_title.text = "Patient History"

        patient_history_recyclerview = findViewById(R.id.patient_history_recyclerview)
        no_item = findViewById(R.id.no_item)

        patient_history_recyclerview.layoutManager = LinearLayoutManager(this)
        val patient_adapter = PatientHistoryAdapter(patient_historyList)
        patient_history_recyclerview.adapter = patient_adapter

    }

    override fun onResume() {
        super.onResume()
        showPatientHistorryData()
        if (patient_historyList.isEmpty()){
            no_item.visibility = View.VISIBLE
        }else{
            no_item.visibility = View.GONE
        }
    }

    override fun onPause() {
        super.onPause()
        patient_historyList.clear()
    }

    fun showPatientHistorryData(){
        patient_historyList.add(ShowPrescriptionModel("A","XYZ","",""))
        patient_historyList.add(ShowPrescriptionModel("B","ABC","",""))
        patient_historyList.add(ShowPrescriptionModel("C","JKL","",""))
        patient_historyList.add(ShowPrescriptionModel("D","MNO","",""))
    }
}