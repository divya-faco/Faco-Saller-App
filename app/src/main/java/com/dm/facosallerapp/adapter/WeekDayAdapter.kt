package com.dm.facosallerapp.adapter

import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.dm.facosallerapp.R
import com.dm.facosallerapp.model.WeekModel

class WeekDayAdapter(val context: Context, var weekdyaList:ArrayList<WeekModel>,
                     private val mOnItemClickListener: OnItemClickListener):RecyclerView.Adapter<WeekDayAdapter.ViewHolder>() {

    var mSelectedPosition = 1


    class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {
        val textViewDay = itemView.findViewById<TextView>(R.id.text_view_day)
        val text_view_date = itemView.findViewById<TextView>(R.id.text_view_date)
        val days_layout = itemView.findViewById<CardView>(R.id.days_layout)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.show_date_layout,parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val WeekModel = weekdyaList[position]
        holder.textViewDay.text = WeekModel.dayName
        holder.text_view_date.text = WeekModel.date

        if (WeekModel.isToday) {
            holder.days_layout.setBackgroundResource(R.drawable.days_white_circle_full)
            holder.days_layout.setBackgroundColor(Color.WHITE)
            holder.days_layout.setRadius(10f)
            holder.text_view_date.setTextColor(context.resources.getColor(R.color.purple_500))
            holder.textViewDay.setTextColor(context.resources.getColor(R.color.purple_500))
            holder.text_view_date.setTypeface(null, Typeface.BOLD)
            holder.textViewDay.setTypeface(null, Typeface.BOLD)
            mSelectedPosition = position
//            mHolder = holder
        } else {
            holder.days_layout.setBackgroundResource(R.drawable.days_circle_border)
            holder.text_view_date.setTextColor(context.resources.getColor(R.color.white))
            holder.textViewDay.setTextColor(context.resources.getColor(R.color.white))
            holder.text_view_date.setTypeface(null, Typeface.NORMAL)
            holder.textViewDay.setTypeface(null, Typeface.NORMAL)
        }

        holder.itemView.setOnClickListener {
            if (mSelectedPosition != position && !WeekModel.isHoliday) {
                val m: WeekModel = weekdyaList.get(mSelectedPosition)
                m.isToday = false
                WeekModel.isToday = true
                mSelectedPosition = position
            }
            mOnItemClickListener.getOnItemClick(WeekModel)
            notifyDataSetChanged()
        }
    }

    override fun getItemCount(): Int {
        return weekdyaList.size
    }

    fun addItems(list: ArrayList<WeekModel>) {
//        this.weekdyaList.clear()
        this.weekdyaList = list
        notifyDataSetChanged()
    }

    interface OnItemClickListener {
        fun getOnItemClick(model: WeekModel)
    }
}