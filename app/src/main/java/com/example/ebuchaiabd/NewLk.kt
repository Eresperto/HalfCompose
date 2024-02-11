package com.example.ebuchaiabd

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import kotlin.system.exitProcess

class NewLk : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

Lk()




        }
    }

@Preview(showBackground = true)
@Composable
fun Lk(){

    Column(
        Modifier
            .fillMaxSize()
            .background(Color(red = 27, green = 45, blue = 59)) /*,horizontalAlignment = Alignment.CenterHorizontally,*/ /*verticalArrangement = Arrangement.Center*/) {


        Image(painter = painterResource(id = R.drawable.header), contentDescription ="headline" )

        Image(painter = painterResource(id = R.drawable.gui), contentDescription = "icnpalka")

Image(painter = painterResource(id = R.drawable.btnsettings), contentDescription = "settings", Modifier.offset(y=36.dp))

        Image(painter = painterResource(id = R.drawable.creating_project), contentDescription ="createprj",Modifier.offset(y=72.dp) )

Image(painter = painterResource(id = R.drawable.stats), contentDescription ="stats" ,Modifier.padding(top= 94.dp,start=31.dp))





        Spacer(modifier = Modifier.height(110.dp))


        Row(modifier = Modifier
            .offset(y = -21.dp)
            // .background(Color(red = 27, green = 45, blue = 59))
            /*.fillMaxWidth(0.9f)*/
            /*.fillMaxHeight(0.1f)*/
            //.fillMaxSize(0.1f),
            .fillMaxWidth()
          ,  horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.Bottom)

        {

            Image(painter = painterResource(id = R.drawable.mainicon) , contentDescription = "Button home")
            Spacer(modifier = Modifier.width(85.dp))
            Image(painter = painterResource(id = R.drawable.profilemain) , contentDescription = "Button home",Modifier.clickable {
              //  startActivity(toSettings)
            }


            )
            Spacer(modifier = Modifier.width(85.dp))
            Image(painter = painterResource(id = R.drawable.exitmenu) , contentDescription = "Button home",Modifier.clickable {
               // startActivity(toAuth)
                moveTaskToBack(true);
                exitProcess(-1)

            })
//            Spacer(modifier = Modifier.width(25.dp))
//            Image(painter = painterResource(id = R.drawable.api) , contentDescription = "Button home")

        }

    }




}


}

