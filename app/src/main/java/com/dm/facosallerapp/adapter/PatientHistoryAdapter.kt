package com.dm.facosallerapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dm.facosallerapp.R
import com.dm.facosallerapp.model.ShowPrescriptionModel

class PatientHistoryAdapter(val patient_historyList:ArrayList<ShowPrescriptionModel>):RecyclerView.Adapter<PatientHistoryAdapter.ViewHolder>() {
    class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {
        val patient_name : TextView = itemView.findViewById(R.id.patient_name)
        val patient_consult : TextView = itemView.findViewById(R.id.patient_consult)
        val txt_upload_pres : TextView = itemView.findViewById(R.id.txt_upload_pres)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.patient_history_layout,parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val ShowPrescriptionModel = patient_historyList[position]
        holder.patient_name.text = ShowPrescriptionModel.patient_name
        holder.patient_consult.text = ShowPrescriptionModel.patient_mob
    }

    override fun getItemCount(): Int {
        return patient_historyList.size
    }
}