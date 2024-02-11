package com.example.ebuchaiabd

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class LKstartup : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lkstartup)

        var btn_settings = findViewById<Button>(R.id.btn_settings)
        var btn_creatpj = findViewById<Button>(R.id.btn_creatpj)
        var btn_homemenu = findViewById<Button>(R.id.btn_homemenu)
        var btn_lkmenu = findViewById<Button>(R.id.btn_lkmenu)
        var btn_apimenu = findViewById<Button>(R.id.btn_apimenu)
        var btn_exitmenu = findViewById<Button>(R.id.btn_exitmenu)
        val intent_lkmenu = Intent(this, LKstartup::class.java)
        val intent_exitmenu = Intent(this, RegistActivity::class.java)
        val intent_homemenu = Intent(this, LKstartup::class.java)
        val intent_settings = Intent(this, Settings::class.java)
        val intent_creatpj = Intent(this, CreatingProject::class.java)
        val intent_api = Intent(this, API::class.java)

        btn_settings.setOnClickListener {
            startActivity(intent_settings)
        }
        btn_lkmenu.setOnClickListener {
            startActivity(intent_lkmenu)
        }
        btn_exitmenu.setOnClickListener {
            startActivity(intent_exitmenu)
        }
        btn_creatpj.setOnClickListener {
            startActivity(intent_creatpj)
        }
        btn_apimenu.setOnClickListener {
            startActivity(intent_api)
        }




    }
}