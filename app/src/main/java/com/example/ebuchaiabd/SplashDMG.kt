package com.example.ebuchaiabd

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashDMG : ComponentActivity() {






    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            splash()

        }

       var toMain = Intent(this,Main::class.java)

       var toReg = Intent(this,RegistActivity::class.java)

        var toOnbord = Intent(this, Onboardings::class.java)

        val pref: SharedPreferences = this.getSharedPreferences("pref_reg", Context.MODE_PRIVATE)
        val editor = pref.edit()

        try{
            var v =pref.getInt("key",0)

            if(v==1){
                lifecycleScope.launch {
                    delay(2000)
                    editor.putInt("key",1)
                    editor.apply()
                    startActivity(toMain)
                    finish()
                    //  startActivity(Intent(this, ))
                }
            }else{

                lifecycleScope.launch {
                    delay(2000)
                    editor.putInt("key",1)
                    editor.apply()
                         startActivity(toOnbord)
                  //  startActivity(toReg)
                    finish()

                    //  startActivity(Intent(this, ))


                }
            }


        }catch (e:Exception){


        }



    }

//    private fun navigateToNextScreenAfterDelay(intent: Intent) {
//        lifecycleScope.launch {
//            delay(2000)
//
//            editor.putInt("key",1)
//            editor.apply()
//
//            startActivity(intent)
//            finish()
//
//            //  startActivity(Intent(this, ))
//
//
//        }
//
//    }

    @Composable
    @Preview(showBackground = true)
    fun splash(){
        Column(
            Modifier
                .fillMaxSize()
                .background(Color(red = 27, green = 45, blue = 59)),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top) {

            Image(painterResource(id = R.drawable.headerboard), contentDescription = null)

            Image(modifier = Modifier
                .height(419.dp)
                .width(413.dp),painter = painterResource(id = R.drawable.slashpnglogo), contentDescription ="splashloltip" )

            Image(painter = painterResource(id = R.drawable.wafillatxt) , contentDescription ="wafillatext" )


        }




    }



}
