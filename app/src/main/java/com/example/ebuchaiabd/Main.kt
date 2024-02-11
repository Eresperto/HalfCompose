package com.example.ebuchaiabd

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import androidx.lifecycle.lifecycleScope
import com.example.ebuchaiabd.ui.theme.EbuchaiaBDTheme
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest
import io.github.jan.supabase.postgrest.postgrest
import kotlinx.coroutines.launch

class Main : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val sharedPreferences: SharedPreferences = this.getSharedPreferences("username", Context.MODE_PRIVATE)
        var name : String? = "gjkfnkjfdngijer"
        try {
            name = sharedPreferences.getString("NameInt","Имя")
        }catch (e:Exception){

        }

        lifecycleScope.launch {
            window.statusBarColor = ContextCompat.getColor(this@Main,R.color.topactivity)
            var PrjNamemas = getProjectName()
            var PrjCostmas = getProjectCost()
            var Prjlongmas = getProjectLong()
            setContent {
                EbuchaiaBDTheme {
                    // A surface container using the 'background' color from the theme
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colorScheme.background
                    ) {
                        Shapka()
                        listview(context = this@Main, prjnames =PrjNamemas , cost =PrjCostmas , long = Prjlongmas, username = name)

                    }
                }
            }
        }
    }

    @Composable
    fun Shapka(){
        Row(Modifier/*.fillMaxWidth()*/) {
            Image(
                modifier = Modifier.fillMaxWidth(),
                painter = painterResource(id = R.drawable.group45), contentDescription = "topBAr", contentScale = ContentScale.FillWidth)
        }
    }

    private suspend fun getProjectName():Array<String> {
        var client = getClient()
        var supabaseReponse = client.postgrest["CostPrj"].select()
        return supabaseReponse.decodeList<CostPrj>().map { it.prjname }.toTypedArray()
    }

    private suspend fun getProjectCost():Array<String> {
        var client = getClient()
        var supabaseReponse = client.postgrest["CostPrj"].select()
        return supabaseReponse.decodeList<CostPrj>().map { it.prjcost }.toTypedArray()
    }
    private suspend fun getProjectLong():Array<String> {
        var client = getClient()
        var supabaseReponse = client.postgrest["CostPrj"].select()
        return supabaseReponse.decodeList<CostPrj>().map { it.long }.toTypedArray()
    }

    private suspend fun getProjectId():Array<Int> {
        var client = getClient()
        var supabaseReponse = client.postgrest["CostPrj"].select()
        return supabaseReponse.decodeList<CostPrj>().map { it.id }.toTypedArray()
    }
    @Composable
    fun listview(context: Context, prjnames: Array<String>, cost: Array<String>, long : Array<String>,username: String?) {
        //val longarray = arrayOf("a","b","c")

        var toAuth = Intent(this,AuthActivity::class.java)

         val intent_reg = Intent(this, Onboardings::class.java)

        val toSettings =Intent(this,Settings::class.java)


        val toProfile =Intent(this,NewLk::class.java)



        window.statusBarColor = ContextCompat.getColor(this@Main,R.color.topactivity)


        Card(
            modifier = Modifier
                .padding(top = 46.dp)
                .background(
                    Color(red = 27, green = 45, blue = 59),
                    shape = RoundedCornerShape(20.dp)
                )
                /*.fillMaxSize(0.9f)*/
                .fillMaxWidth()
                .fillMaxHeight(0.8f), shape = RoundedCornerShape(20.dp)
        ) {
            Column(

                modifier = Modifier
                    .background(Color(red = 27, green = 45, blue = 59))
                    .fillMaxSize()
            ) {
                Text(
                    modifier = Modifier.padding(top = 10.dp, start = 50.dp),
                    text = "Здравствуйте , $username ", color = Color.White, textAlign = TextAlign.Center,
                    fontSize = 20.sp, fontWeight = FontWeight.Bold
                )
                Text(
                    modifier = Modifier.padding(start = 30.dp, top = 30.dp),
                    text = "Инвестируемы проекты", color = Color.White,
                )
                Spacer(modifier = Modifier.height(24.dp))
                //Тут должен быть цикл
                LazyColumn(
                    modifier =
                    Modifier
                        .fillMaxSize()
                        .background(Color(red = 27, green = 45, blue = 59)/*Color.White*/)
                        .padding(bottom = 40.dp)
                ) {
                    // on below line we are setting data for each item of our listview.
                    var trueIndex: Int = 0
                    var rasstan: Boolean = false

                    itemsIndexed(prjnames) { index, item ->
                        // on below line we are creating a card for our list view item.
                        if (rasstan == false) {
                            Row(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .background(Color(red = 27, green = 45, blue = 59)),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.Center
                            ) {
                                //Тут цикл
                                Column(
                                    // for our row we are adding modifier
                                    // to set padding from all sides.
                                    modifier = Modifier


                                        //.padding(top = 8.dp, end = 20.dp)

                                        .fillMaxWidth(0.409f)
//                                  .fillMaxWidth(0.31f)
//                                  .fillMaxHeight(0.2f)
                                        .border(0.dp, Color.Transparent)
                                        .background(
                                            brush = Brush.verticalGradient(
                                                colors = listOf(
                                                    Color(red = 100, green = 179, blue = 166),
                                                    Color(red = 45, green = 80, blue = 83),
                                                )
                                            ), shape = RoundedCornerShape(15.dp)
                                        )
                                        .clip(shape = RoundedCornerShape(15.dp)),
                                    verticalArrangement = Arrangement.Center,
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    // on below line inside row we are adding spacer
//                                    Spacer(modifier = Modifier.width(5.dp))
                                    // on below line we are adding spacer between image and a text
//                                    Spacer(modifier = Modifier.width(5.dp))
                                    // on the below line we are creating a text.
                                    Text(
                                        modifier = Modifier.padding(top = 10.dp),
                                        text = prjnames[trueIndex],
                                        color = Color.White, textAlign = TextAlign.Center,
                                        fontSize = 20.sp, fontWeight = FontWeight.Bold
                                    )
                                    Text(
                                        modifier = Modifier.padding(top = 10.dp),
                                        text = "стоимость", fontSize = 15.sp
                                    )
                                    Text(
                                        text = cost[trueIndex] + " руб.",
                                        modifier = Modifier.padding(4.dp),
                                        // on below line we are adding color for our text

                                        color = Color.White,
                                        textAlign = TextAlign.Center,
                                        fontSize = 20.sp,
                                        fontWeight = FontWeight.Bold
                                    )

                                    Text(
                                        text = " время разработки",
                                        modifier = Modifier.padding(top = 10.dp), fontSize = 15.sp
                                    )
                                    Text(
                                        text = long[trueIndex],
                                        // on below line we are adding color for our text
                                        color = Color.White, textAlign = TextAlign.Center,
                                        fontSize = 20.sp, fontWeight = FontWeight.Bold
                                    )
                                    if (trueIndex < prjnames.size - 1) {
                                        trueIndex += 1
                                    } else if (trueIndex == prjnames.size - 1) {
                                        rasstan = true
                                    }
                                    Image(
                                        painter = painterResource(id = R.drawable.prodolzit), contentDescription = "",
                                        modifier = Modifier
                                            .clickable {
                                                window.statusBarColor = ContextCompat.getColor(
                                                    this@Main,
                                                    R.color.topactivity


                                                )
                                            }
                                            .padding(top = 10.dp, bottom = 20.dp),

                                        )

                                }


                                Spacer(modifier = Modifier.width(34.dp))

                                // on below line we are creating
                                // a row for our list view item.
                                Column(
                                    // for our row we are adding modifier
                                    // to set padding from all sides.
                                    modifier = Modifier
                                        .fillMaxWidth(0.8f)
                                        //  .padding(8.dp)
//                                  .fillMaxWidth(0.5f)
//                                  .fillMaxHeight(0.2f)
                                        .fillMaxHeight(0.35f)
                                        .border(0.dp, Color.Transparent)
                                        .background(
                                            brush = Brush.verticalGradient(
                                                colors = listOf(
                                                    Color(red = 100, green = 179, blue = 166),
                                                    Color(red = 45, green = 80, blue = 83),
                                                )
                                            ), shape = RoundedCornerShape(15.dp)
                                        )
                                        .clip(shape = RoundedCornerShape(15.dp)),
                                    verticalArrangement = Arrangement.Center,
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    // on below line inside row we are adding spacer
                                    Spacer(modifier = Modifier.width(5.dp))
                                    // on below line we are adding spacer between image and a text
                                    Spacer(modifier = Modifier.width(5.dp))
                                    // on the below line we are creating a text.
                                    Text(
                                        modifier = Modifier.padding(top = 10.dp),
                                        text = prjnames[trueIndex],
                                        color = Color.White, textAlign = TextAlign.Center,
                                        fontSize = 20.sp, fontWeight = FontWeight.Bold
                                    )
                                    Text(
                                        modifier = Modifier.padding(top = 10.dp),
                                        text = "стоимость", fontSize = 15.sp
                                    )
                                    Text(
                                        text = cost[trueIndex] + " руб.",
                                        modifier = Modifier.padding(4.dp),
                                        // on below line we are adding color for our text
                                        color = Color.White,
                                        textAlign = TextAlign.Center,
                                        fontSize = 20.sp,
                                        fontWeight = FontWeight.Bold
                                    )
                                    Text(
                                        text = " время разработки",
                                        modifier = Modifier.padding(top = 10.dp), fontSize = 15.sp
                                    )
                                    Text(
                                        text = long[trueIndex],
                                        // on below line we are adding color for our text
                                        color = Color.White, textAlign = TextAlign.Center,
                                        fontSize = 20.sp, fontWeight = FontWeight.Bold
                                    )
                                    if (trueIndex < prjnames.size - 1) {
                                        trueIndex += 1
                                    } else if (trueIndex == prjnames.size - 1) {
                                        rasstan = true
                                    }
                                    Image(
                                        painter = painterResource(id = R.drawable.prodolzit), contentDescription = "",
                                        modifier = Modifier
                                            .clickable {
                                                window.statusBarColor = ContextCompat.getColor(
                                                    this@Main,
                                                    R.color.topactivity
                                                )



                                               // startActivity(intent_reg)
                                            }
                                            .padding(top = 10.dp, bottom = 20.dp),

                                        )
                                }


                            }
                            Spacer(modifier = Modifier
                                .fillMaxWidth()
                                .height(20.dp))
                        } else {

                        }


                    }



                }
            }
        }

        Row(modifier = Modifier
            .offset(y = -21.dp)
            // .background(Color(red = 27, green = 45, blue = 59))
            /*.fillMaxWidth(0.9f)*/
            /*.fillMaxHeight(0.1f)*/
            .fillMaxSize(0.1f),
            horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.Bottom)

        {

            Image(painter = painterResource(id = R.drawable.mainicon) , contentDescription = "Button home")
            Spacer(modifier = Modifier.width(85.dp))
            Image(painter = painterResource(id = R.drawable.profilemain) , contentDescription = "Button home",Modifier.clickable {
            startActivity(toProfile)
            }


            )
            Spacer(modifier = Modifier.width(85.dp))
            Image(painter = painterResource(id = R.drawable.exitmenu) , contentDescription = "Button home",Modifier.clickable {
                startActivity(toAuth)
            })
//            Spacer(modifier = Modifier.width(25.dp))
//            Image(painter = painterResource(id = R.drawable.api) , contentDescription = "Button home")

        }


    }


    private fun insertData(name: String, login: String, pass: String, dostup: String){
        lifecycleScope.launch{
            val client = getClient()
            var abc = users(username = name, userlogin = login, userpass = pass, power = dostup)
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

    @kotlinx.serialization.Serializable
    data class CostPrj(
        val id: Int=0,
        val prjname: String = "",
        val prjcost: String = "",
        val long: String = "",
    ){
        override fun toString(): String{
            return "${id} ${prjname} ${prjcost} ${long}"
        }
    }

    @kotlinx.serialization.Serializable
    data class users(
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


}

