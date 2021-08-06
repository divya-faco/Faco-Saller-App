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
import com.dm.facosallerapp.adapter.ShowPrescriptionAdapter
import com.dm.facosallerapp.model.ShowPrescriptionModel

class LabAppointmentActivity : AppCompatActivity() {

    val pres_list = ArrayList<ShowPrescriptionModel>()
    lateinit var no_item : LinearLayout
    lateinit var prescription_recyclerView : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lab_appointment)

        var back_button : ImageButton = findViewById(R.id.back_button)
        back_button.setOnClickListener { finish() }
        var custom_toolabar_title : TextView = findViewById(R.id.custom_toolabar_title)
        custom_toolabar_title.text = "Lab Appointment"

        no_item = findViewById(R.id.no_item)
        prescription_recyclerView = findViewById(R.id.prescription_recyclerView)
        prescription_recyclerView.layoutManager = LinearLayoutManager(this)

        val pres_adapter = ShowPrescriptionAdapter(this,pres_list)
        prescription_recyclerView.adapter = pres_adapter
    }

    override fun onResume() {
        super.onResume()
        showPrescriptionData()
        if (pres_list.isEmpty()) {
            no_item.visibility = View.VISIBLE
            prescription_recyclerView.visibility = View.GONE
        } else {
            prescription_recyclerView.visibility = View.VISIBLE
            no_item.visibility = View.GONE
        }
    }

    override fun onPause() {
        super.onPause()
        pres_list.clear()
    }

    fun showPrescriptionData(){
        pres_list.add(ShowPrescriptionModel("A","12345789","12/5/2021",""))
        pres_list.add(ShowPrescriptionModel("B","789456123","03/5/2020",""))
        pres_list.add(ShowPrescriptionModel("C","456123789","12/4/2021",""))
        pres_list.add(ShowPrescriptionModel("D","987654123","15/8/2021",""))
    }
}