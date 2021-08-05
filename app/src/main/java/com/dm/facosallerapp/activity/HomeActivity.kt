package com.dm.facosallerapp.activity

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import com.google.android.material.navigation.NavigationView
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import com.dm.facosallerapp.R
import com.dm.facosallerapp.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarHome.toolbar)

        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView

        toggle = ActionBarDrawerToggle(this,drawerLayout,R.string.navigation_drawer_open,R.string.navigation_drawer_close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        toggle.setToolbarNavigationClickListener {
            if (drawerLayout.isDrawerOpen(GravityCompat.START)){
                drawerLayout.closeDrawer(GravityCompat.START)
            }else{
                drawerLayout.openDrawer(GravityCompat.START)
            }
        }
        navView.setNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.nav_home -> {
//                    val manager = supportFragmentManager.beginTransaction().replace(
//                        R.id.frame_layout, HomeFragment()
//                    ).addToBackStack(null).commit()
                    startActivity(Intent(this,HomeActivity::class.java)
                        .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
                        .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
                    drawerLayout.closeDrawer(GravityCompat.START)
                }
                R.id.menu_profile ->{
                    startActivity(Intent(this,LabProfileActivity::class.java)
                        .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK))
                    drawerLayout.closeDrawer(GravityCompat.START)
                }
                R.id.menu_set_avaliability ->{
                    startActivity(Intent(this,SetAvailabilityActivity::class.java)
                        .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK))
                    drawerLayout.closeDrawer(GravityCompat.START)
                }
                R.id.menu_Notif ->{
                    startActivity(Intent(this,NotificationActivity::class.java)
                        .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK))
                    drawerLayout.closeDrawer(GravityCompat.START)
                }
                R.id.menu_feedback ->{
                    startActivity(Intent(this,PatientFeedbackActivity::class.java)
                        .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK))
                    drawerLayout.closeDrawer(GravityCompat.START)
                }
            }
            true
        }

        val headerView : View = navView.getHeaderView(0)
        val txteditprofile = headerView.findViewById<TextView>(R.id.txt_edit_profile)
        val txtuserName = headerView.findViewById<TextView>(R.id.txt_userName)
        val emergency = headerView.findViewById<TextView>(R.id.emergency)
        val cleardrwer = headerView.findViewById<ImageButton>(R.id.clear_drwer)
        cleardrwer.setOnClickListener{
            if (drawerLayout.isOpen)
                drawerLayout.close()
        }
        txteditprofile.setOnClickListener {
            startActivity(Intent(this,LabProfileActivity::class.java))
            drawerLayout.closeDrawer(GravityCompat.START)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.home, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}