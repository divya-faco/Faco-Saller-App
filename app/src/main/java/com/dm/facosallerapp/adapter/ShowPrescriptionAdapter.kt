package com.dm.facosallerapp.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dm.facosallerapp.R
import com.dm.facosallerapp.activity.AddLabInfoActivity
import com.dm.facosallerapp.model.ShowPrescriptionModel

class ShowPrescriptionAdapter(val context:Context,val pres_list:ArrayList<ShowPrescriptionModel>) : RecyclerView.Adapter<ShowPrescriptionAdapter.Viewolder>() {
    class Viewolder(itemView :View) :RecyclerView.ViewHolder(itemView) {
//        fun bindItems(showPrescriptionModel: ShowPrescriptionModel){
            val patient_name = itemView.findViewById<TextView>(R.id.patient_name)
            val add_medicine = itemView.findViewById<TextView>(R.id.add_medicine)
            val check_medicine = itemView.findViewById<TextView>(R.id.check_medicine)
            val patient_phone = itemView.findViewById<TextView>(R.id.patient_phone)
            val patient_date = itemView.findViewById<TextView>(R.id.patient_date)
            val prescription_download = itemView.findViewById<TextView>(R.id.prescription_download)
//        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Viewolder {
        return Viewolder(LayoutInflater.from(parent.context).inflate(R.layout.md_prescription_layout,parent,false))
    }

    override fun onBindViewHolder(holder: Viewolder, position: Int) {
        val ShowPrescriptionModel = pres_list[position]
        holder.patient_name.text = ShowPrescriptionModel.patient_name
        holder.patient_date.text = ShowPrescriptionModel.pres_date
        holder.patient_phone.text = ShowPrescriptionModel.patient_mob
        holder.add_medicine.setOnClickListener {
            context.startActivity(Intent(context,AddLabInfoActivity::class.java))
        }
    }

    override fun getItemCount(): Int {
        return pres_list.size
    }
}