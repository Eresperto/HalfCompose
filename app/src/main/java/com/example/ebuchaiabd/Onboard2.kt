package com.example.ebuchaiabd

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ebuchaiabd.ui.theme.EbuchaiaBDTheme

class Onboard2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {


Onboardig2()




            }
        }


    @Preview(showBackground = true)
    @Composable
    fun Onboardig2(){
        var toAuth = Intent(this,AuthActivity::class.java)
        var to3 = Intent(this,OnBoard3::class.java)


        Column(
            Modifier
                .fillMaxSize()
                .background(Color(red = 27, green = 45, blue = 59)),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top,) {

            Image(painter = painterResource(id = R.drawable.headerboard),
                contentDescription ="header", )
            Image(painter = painterResource(id = R.drawable.midtransition), contentDescription ="pictura" ,modifier = Modifier.padding(/*top = 40.dp,*/ bottom = 90.dp)/*.offset(y=40.dp)*/)

            Image(painter = painterResource(id = R.drawable.transition), contentDescription = "perekli",Modifier.padding(top =40.dp))



            Image(painter = painterResource(id = R.drawable.text1), contentDescription = "perekli",Modifier.padding(top = 25.dp)/*.padding(top =104.dp)*/)

            Text(text ="        Создавайте проекты и идеи,\n" +
                    "продвигайте их среди инвесторов,\n" +
                    "        и следите за статистикой\n" +
                    "               вашего прогресса",
                color = Color.Gray,modifier = Modifier.padding(top =10.dp )
                /*fontSize = 18.dp*/)

            Image(painter = painterResource(id = R.drawable.btn_next), contentDescription ="nextfragment",modifier = Modifier
                .padding(top = 38.dp)
                .clickable {

                    startActivity(to3)

                }
            )

            Text(text = "ПРОПУСТИТЬ",color = Color.Gray,modifier = Modifier.padding(top =25.dp ).clickable { startActivity(toAuth) })

        }

    }



    }


