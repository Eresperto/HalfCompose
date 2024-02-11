package com.example.ebuchaiabd

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest
import io.github.jan.supabase.postgrest.postgrest
import kotlinx.coroutines.launch

class AuthActivity : AppCompatActivity() {
    var heredostup: String=""
   var NameInt: String = ""



    override fun onCreate(savedInstanceState: Bundle?) {

        setTheme(android.R.style.Theme)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)




        var edt_log = findViewById<EditText>(R.id.edt_log)
        var edt_pass = findViewById<EditText>(R.id.edt_pass)
        var btn_autoreg = findViewById<Button>(R.id.btn_autoreg)
        var btn_reg = findViewById<Button>(R.id.btn_reg)

        val intent_reg = Intent(this, RegistActivity::class.java)





        btn_reg.setOnClickListener {
            startActivity(intent_reg)
        }
        btn_autoreg.setOnClickListener {
            var log = edt_log.text.toString()
            var pas = edt_pass.text.toString()
            getData(log,pas)

            Toast.makeText(this, "Работает", Toast.LENGTH_SHORT).show()

        // startActivity(intentlk_comp)
        }

    }

    private fun getClient(): SupabaseClient {
        return createSupabaseClient(supabaseUrl = "https://twrnebqcmxfljyozuqyp.supabase.co",
            supabaseKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6InR3cm5lYnFjbXhmbGp5b3p1cXlwIiwicm9sZSI6ImFub24iLCJpYXQiOjE2OTkyNzMwODYsImV4cCI6MjAxNDg0OTA4Nn0.NKu0iwKego8G5OJOTz2bay3OOsouPvtMjQZee219Ksg")
        {
            install(Postgrest)
        }
    }


    var a:Int = 0
    private fun getData(log:String,pas:String ){

        val sharedPreferences: SharedPreferences = this.getSharedPreferences("username", Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor = sharedPreferences.edit()

        lifecycleScope.launch {
            val client = getClient()
            val supabaseReponse = client.postgrest["users"].select()
            val data = supabaseReponse.decodeList<Testing>()
            while(a<data.size){
                if((log==data[a].userlogin) and (pas==data[a].userpass)){
                    heredostup=data[a].power
                    NameInt = data[a].id.toString()
                    editor.putString("NameInt",NameInt)

                }
            }
        }
    }





}

