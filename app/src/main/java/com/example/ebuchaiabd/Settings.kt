package com.example.ebuchaiabd

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Settings : AppCompatActivity() {

   // val sharedPreferences: SharedPreferences = this.getSharedPreferences("username", Context.MODE_PRIVATE)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        var btn_homemenu = findViewById<Button>(R.id.btn_homemenu)
        var btn_lkmenu = findViewById<Button>(R.id.btn_lkmenu)
        var btn_exitmenu = findViewById<Button>(R.id.btn_exitmenu)
        var btn_apimenu = findViewById<Button>(R.id.btn_apimenu)



        val intent_lkmenu = Intent(this, LKcompanies::class.java)
        val intent_exitmenu = Intent(this, RegistActivity::class.java)
        val intent_homemenu = Intent(this, LKstartup::class.java)
       // val intent_api = Intent(this, API::class.java)

        btn_lkmenu.setOnClickListener {
            startActivity(intent_lkmenu)
        }
        btn_exitmenu.setOnClickListener {
            startActivity(intent_exitmenu)
        }
        btn_apimenu.setOnClickListener {
            //startActivity(intent_api)
        }



    }
}