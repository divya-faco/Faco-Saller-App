package com.dm.facosallerapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dm.facosallerapp.R
import com.dm.facosallerapp.model.ShowPrescriptionModel

class PatientFeedbcakAdapter(val patient_feedbackList:ArrayList<ShowPrescriptionModel>):RecyclerView.Adapter<PatientFeedbcakAdapter.ViewHolder>() {
    class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {
        val rated_image :ImageView = itemView.findViewById(R.id.rated_image)
        val txt_patient_name :TextView = itemView.findViewById(R.id.txt_patient_name)
        val rated_date :TextView = itemView.findViewById(R.id.rated_date)
        val txt_patient_desc :TextView = itemView.findViewById(R.id.txt_patient_desc)
        val ratingBar :RatingBar = itemView.findViewById(R.id.ratingBar)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.patient_feedback_layout,parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       val ShowPrescriptionModel = patient_feedbackList[position]
        holder.txt_patient_name.text = ShowPrescriptionModel.patient_name
        holder.txt_patient_desc.text = ShowPrescriptionModel.patient_mob
    }

    override fun getItemCount(): Int {
        return patient_feedbackList.size
    }
}