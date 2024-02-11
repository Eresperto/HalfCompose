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

class Onboardings : ComponentActivity() {

    public var frag = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        setContent {
            Onboardig1()
        }

    }


@Composable
fun anims(){

//    AnimatedContent(
//        targetState = state,
//        transitionSpec = {
//            fadeIn(animationSpec = tween(durationMillis = 150)) with
//                    fadeOut(animationSpec = tween(durationMillis = 150)) using
//                    SizeTransform { initialSize, targetSize ->
//                        if (targetState == Thread.State.EXPAND) {
//                            keyframes {
//                                IntSize(initialSize.width, initialSize.height) at 150
//                                durationMillis = 300
//                            }
//                        } else {
//                            keyframes {
//                                IntSize(targetSize.width, targetSize.height) at 150
//                                durationMillis = 300
//                            }
//                        }
//                    }
//        }
//    ) { targetExpanded ->
//        if (targetExpanded == Recomposer.State.EXPAND) {
//            Collapsed()
//        } else {
//            SheetValue.Expanded()
//        }
//    }

}




    @Preview(showBackground = true)
    @Composable
    fun Onboardig3(){

        var toMain = Intent(this,SplashDMG::class.java)

        Column(
            Modifier
                .fillMaxSize()
                .background(Color(red = 27, green = 45, blue = 59)),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top,) {

            Image(painter = painterResource(id = R.drawable.headerboard),
                contentDescription ="header", )
            Image(painter = painterResource(id = R.drawable.fon3), contentDescription ="pictura" ,modifier = Modifier.padding(/*top = 40.dp,*/ bottom = 90.dp)/*.offset(y=40.dp)*/)

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

                    startActivity(toMain)

                }
            )

            Text(text = "ПРОПУСТИТЬ",color = Color.Gray,modifier = Modifier.padding(top =25.dp ))


        }

    }

    @Preview(showBackground = true)
    @Composable
    fun Onboardig2(){

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
                    frag =3
                }
            )

            Text(text = "ПРОПУСТИТЬ",color = Color.Gray,modifier = Modifier.padding(top =25.dp ))

        }

    }




@Preview(showBackground = true)
@Composable
fun Onboardig1(){

    var skip =Intent(this,AuthActivity::class.java)

    var to2 =Intent(this,Onboard2::class.java)

    Column(
        Modifier
            .fillMaxSize()
            .background(Color(red = 27, green = 45, blue = 59)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,) {

            Image(painter = painterResource(id = R.drawable.headerboard),
                contentDescription ="header", )
        Image(painter = painterResource(id = R.drawable.fon1board1_2), contentDescription ="pictura" ,modifier = Modifier.padding(top = 40.dp, bottom = 104.dp)/*.offset(y=40.dp)*/)

Image(painter = painterResource(id = R.drawable.transition), contentDescription = "perekli",Modifier.padding(top =40.dp))



        Image(painter = painterResource(id = R.drawable.text1), contentDescription = "perekli",Modifier.padding(top = 25.dp)/*.padding(top =104.dp)*/)

        Text(text ="Легко адаптироваться в приложении,\n" +
                "                   простой интерфейс, \n" +
                "       за счет чего удобно работать",
            color = Color.Gray,modifier = Modifier.padding(top =10.dp )
            /*fontSize = 18.dp*/)

        Image(painter = painterResource(id = R.drawable.btn_next), contentDescription ="nextfragment",modifier = Modifier
            .padding(top = 48.dp)
            .clickable {

            startActivity(to2)

            }
        )

        Text(text = "ПРОПУСТИТЬ",color = Color.Gray,modifier = Modifier.padding(top =25.dp ).clickable { startActivity(skip) }

        )

//        while (true){
//                if(frag==2){
//
//                    Onboardig2()
//                }else{}


        }


    }

}







//}

