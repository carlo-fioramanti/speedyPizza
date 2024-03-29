package com.example.speedypizza.screens.admin

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.speedypizza.R
import com.example.speedypizza.screens.rider.BarraSuperiore
import com.example.speedypizza.screens.rider.ScrittaIniziale
import com.example.speedypizza.ui.theme.boxcol
import com.example.speedypizza.ui.theme.center_color
import com.example.speedypizza.ui.theme.end_color
import com.example.speedypizza.ui.theme.start_color
import com.example.speedypizza.viewmodel.LoginViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch




@Composable
fun AdminDashboard(navController: NavHostController, viewModel: LoginViewModel) {
    val gradient = Brush.verticalGradient(
        colors = listOf(start_color, center_color, end_color ),
        startY = 0f,
        endY = 2000f
    )

    ConstraintLayout {
        val (box)=createRefs()
        Box(modifier = Modifier
            .background(brush = gradient)
            .fillMaxSize()
            .constrainAs(box) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        ){
            Column {
                BarraSuperiore(navController, viewModel)
                ScrittaIniziale("SpeedyPizza")
                Spacer(modifier = Modifier.height(200.dp))
                PrimoMenu(navController)
            }
        }

    }

}



@Composable
fun PrimoMenu(navController: NavHostController) {


    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
            .background(boxcol)
            .padding(5.dp)


    ){

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxSize()
                .offset(x = 15.dp, y = 60.dp), // Questo fa sì che il Box occupi tutto lo spazio disponibile
        ){
            Button( //Bottone RaiderManagement
                onClick={

                    navController.navigate("MyRiderPage")

                },
                colors = ButtonDefaults.buttonColors(
                    containerColor=Color.White,
                    contentColor=Color.Black
                ),
                modifier = Modifier
                    .width(130.dp)
                    .height(130.dp)
                    .offset(x = 40.dp, y = 40.dp)
                    .shadow(20.dp),
                shape = RoundedCornerShape(topStart=15.dp, topEnd=15.dp, bottomEnd = 15.dp, bottomStart=15.dp)

            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,

                    ){
                    Icon(
                        painter = painterResource(id =R.drawable.baseline_sports_motorsports_24),
                        contentDescription = "Calendar",
                        modifier = Modifier
                            .size(60.dp)
                    )
                    Text(stringResource(R.string.Rider_Management), modifier = Modifier.offset(y=5.dp), textAlign = TextAlign.Center)
                }

            }

            Button( //Bottone Create Calendar
                onClick = {

                    navController.navigate("createCalendarPage")

                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                    contentColor = Color.Black
                ),
                modifier = Modifier
                    .width(130.dp)
                    .height(130.dp)
                    .offset(x = 200.dp, y = 40.dp)
                    .shadow(20.dp),
                shape = RoundedCornerShape(topStart=15.dp, topEnd=15.dp, bottomEnd = 15.dp, bottomStart=15.dp)

            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.padding(2.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_create_24),
                        contentDescription = "Change",
                        tint = Color.Black,
                        modifier = Modifier.size(60.dp)
                    )
                    Text(stringResource(R.string.Create_Calendar), modifier = Modifier.offset(y=5.dp), textAlign = TextAlign.Center)
                }

            }


            Button( // bottone shift
                onClick = {
                    CoroutineScope(Dispatchers.Main).launch {
                        navController.navigate("shiftPage")
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                    contentColor = Color.Black
                ),
                modifier = Modifier
                    .width(292.dp)
                    .height(130.dp)
                    .offset(x = 40.dp, y = 200.dp)
                    .shadow(20.dp),
                shape = RoundedCornerShape(topStart=15.dp, topEnd=15.dp, bottomEnd = 15.dp, bottomStart=15.dp)


            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.padding(1.dp)
                ) {
                    Icon(
                        painter = painterResource(id =R.drawable.ic_calendar_foreground),
                        contentDescription = "Change",
                        tint = Color.Black,
                        modifier = Modifier.size(60.dp)
                    )
                    Text(text= stringResource(id = R.string.View_Calendar), textAlign = TextAlign.Center)
                }

            }
        }
    }

}

@Preview
@Composable
fun Launch(){
    PrimoMenu(navController = rememberNavController())
}