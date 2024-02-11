package com.example.ebuchaiabd
import android.content.Intent
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
class RegistActivity : AppCompatActivity() {
    var dostup: String=""
    override fun onCreate(savedInstanceState: Bundle?) {



        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_regist)
        // Проверка состояния loggedIn при создании активити
        //Кнопошки
        var btn_comp = findViewById<Button>(R.id.btn_cp)
        var btn_startup = findViewById<Button>(R.id.btn_strup)
        var edt_name = findViewById<EditText>(R.id.edt_name)
        var edt_log = findViewById<EditText>(R.id.edt_log)
        var edt_pass = findViewById<EditText>(R.id.edt_pass)
        var btn_reg = findViewById<Button>(R.id.btn_reg)
        var btn_autoreg = findViewById<Button>(R.id.btn_autoreg)
        //Инетнты
       val intent_au = Intent(this, AuthActivity::class.java)
      val intentlk_comp = Intent(this, LKcompanies::class.java)
       val intentlk_str_up = Intent(this, LKstartup::class.java)
        //Переход в главную компании
        btn_comp.setOnClickListener {
            dostup ="1"
            btn_reg.setOnClickListener {
                var name = edt_name.text.toString()
                var login = edt_log.text.toString()
                var pass = edt_pass.text.toString()
                insertData(name, login, pass, dostup)
                Toast.makeText(this, "Работает", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this,AuthActivity::class.java))
            }
        }
        btn_autoreg.setOnClickListener {
            startActivity(Intent(this, SplashDMG::class.java))
        }
    }






    private fun insertData(name: String, login: String, pass: String, dostup: String){
        lifecycleScope.launch{
            val client = getClient()
            var abc = Testing(username = name, userlogin = login, userpass = pass, power = dostup)
            client.postgrest["users"].insert(value = abc)

        }
    }

    private fun getClient(): SupabaseClient {
        return createSupabaseClient(supabaseUrl = "https://twrnebqcmxfljyozuqyp.supabase.co",
            supabaseKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6InR3cm5lYnFjbXhmbGp5b3p1cXlwIiwicm9sZSI6ImFub24iLCJpYXQiOjE2OTkyNzMwODYsImV4cCI6MjAxNDg0OTA4Nn0.NKu0iwKego8G5OJOTz2bay3OOsouPvtMjQZee219Ksg")
        {
            install(Postgrest)
        }
    }

}
@kotlinx.serialization.Serializable
data class Testing(
    val id: Int=0,
    val username: String = "",
    val userlogin: String = "",
    val userpass: String = "",
    val power: String=""

){
    override fun toString(): String{
        return "${id} ${username} ${userlogin} ${userpass} ${power}"
    }
}
