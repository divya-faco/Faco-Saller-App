package com.dm.facosallerapp.utils

import android.app.Activity
import android.view.Gravity
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.dm.facosallerapp.R

class ToastCustom(contentLayoutId: Int) : AppCompatActivity(contentLayoutId) {
    private var toast: Toast? = null

    fun toastSuccessCenter(activity: Activity, message: String?) {
        toast = Toast.makeText(activity, message, Toast.LENGTH_SHORT)
        toast?.setGravity(Gravity.CENTER, 0, 0)
        val custom_view: View = activity.layoutInflater.inflate(R.layout.toast_icon_text, null)
        (custom_view.findViewById<View>(R.id.message) as TextView).text = message
        (custom_view.findViewById<View>(R.id.icon) as ImageView).setImageResource(R.drawable.ic_baseline_check)
        (custom_view.findViewById<View>(R.id.parent_view) as CardView).setCardBackgroundColor(
            activity.resources
                .getColor(R.color.success_toast)
        )
        toast?.setView(custom_view)
        toast?.show()
    }

    fun toastInfoCenter(activity: Activity, message: String?) {
        toast = Toast.makeText(activity, message, Toast.LENGTH_SHORT)
        toast?.setGravity(Gravity.CENTER, 0, 0)
        val custom_view: View = activity.layoutInflater.inflate(R.layout.toast_icon_text, null)
        (custom_view.findViewById<View>(R.id.message) as TextView).text = message
        (custom_view.findViewById<View>(R.id.icon) as ImageView).setImageResource(R.drawable.ic_error_outline)
        (custom_view.findViewById<View>(R.id.parent_view) as CardView).setCardBackgroundColor(
            activity.resources
                .getColor(R.color.medicine_time)
        )
        toast?.setView(custom_view)
        toast?.show()
    }

    fun toastErrorCenter(activity: Activity, message: String?) {
        toast = Toast.makeText(activity, message, Toast.LENGTH_SHORT)
        toast?.setGravity(Gravity.CENTER, 0, 0)
        val custom_view: View = activity.layoutInflater.inflate(R.layout.toast_icon_text, null)
        (custom_view.findViewById<View>(R.id.message) as TextView).text = message
        (custom_view.findViewById<View>(R.id.icon) as ImageView).setImageResource(R.drawable.ic_baseline_clear)
        (custom_view.findViewById<View>(R.id.parent_view) as CardView).setCardBackgroundColor(
            activity.resources.getColor(R.color.emergency)
        )
        toast?.setView(custom_view)
        toast?.show()
    }

    fun toastSuccessBottom(activity: Activity, message: String?) {
        toast = Toast.makeText(activity, message, Toast.LENGTH_SHORT)
        toast?.setGravity(Gravity.BOTTOM, 0, 70)
        val custom_view: View = activity.layoutInflater.inflate(R.layout.toast_icon_text, null)
        (custom_view.findViewById<View>(R.id.message) as TextView).text = message
        (custom_view.findViewById<View>(R.id.icon) as ImageView).visibility =
            View.GONE
        (custom_view.findViewById<View>(R.id.parent_view) as CardView).setCardBackgroundColor(
            activity.resources.getColor(R.color.black)
        )
        toast?.setView(custom_view)
        toast?.show()
    }

    fun toastErrorBottom(activity: Activity, message: String?) {
        toast = Toast.makeText(activity, message, Toast.LENGTH_SHORT)
        toast?.setGravity(Gravity.BOTTOM, 0, 50)
        val custom_view: View = activity.layoutInflater.inflate(R.layout.toast_icon_text, null)
        (custom_view.findViewById<View>(R.id.message) as TextView).text = message
        (custom_view.findViewById<View>(R.id.icon) as ImageView).setImageResource(R.drawable.ic_baseline_clear)
        (custom_view.findViewById<View>(R.id.parent_view) as CardView).setCardBackgroundColor(
            activity.resources.getColor(R.color.emergency)
        )
        toast?.setView(custom_view)
        toast?.show()
    }

    fun toastInfoBottom(activity: Activity, message: String?) {
        toast = Toast.makeText(activity, message, Toast.LENGTH_SHORT)
        toast?.setGravity(Gravity.BOTTOM, 0, 70)
        val custom_view: View = activity.layoutInflater.inflate(R.layout.toast_icon_text, null)
        (custom_view.findViewById<View>(R.id.message) as TextView).text = message
        (custom_view.findViewById<View>(R.id.icon) as ImageView).setImageResource(R.drawable.ic_error_outline)
        (custom_view.findViewById<View>(R.id.parent_view) as CardView).setCardBackgroundColor(
            activity.resources
                .getColor(R.color.medicine_time)
        )
        toast?.setView(custom_view)
        toast?.show()
    }
}