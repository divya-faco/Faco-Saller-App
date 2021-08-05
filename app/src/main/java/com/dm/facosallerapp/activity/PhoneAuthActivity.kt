package com.dm.facosallerapp.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.dm.facosallerapp.R

class PhoneAuthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phone_auth)

        val verify_btn = findViewById<Button>(R.id.verify_btn)
        verify_btn.setOnClickListener{
            startActivity(Intent(this,TestInfoActivity::class.java))
        }
    }
}