package com.dm.facosallerapp.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.dm.facosallerapp.R

class TestInfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_info)

        val btn_next = findViewById<Button>(R.id.btn_next)
        btn_next.setOnClickListener{
            startActivity(Intent(this,HomeActivity::class.java))
        }
    }
}