package com.dm.facosallerapp.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import com.dm.facosallerapp.R

class AddLabInfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_lab_info)
        var back_button : ImageButton = findViewById(R.id.back_button)
        back_button.setOnClickListener { finish() }
        var custom_toolabar_title : TextView = findViewById(R.id.custom_toolabar_title)
        custom_toolabar_title.text = "Add Test Info"
    }
}