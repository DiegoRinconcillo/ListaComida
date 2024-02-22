package com.mexiti.listacomidaor

import android.os.Bundle
import android.view.Menu
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mexiti.listacomidaor.data.DataSource
import com.mexiti.listacomidaor.model.Platillo
import com.mexiti.listacomidaor.ui.theme.ListaComidaOrTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ListaComidaOrTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MenuApp()
                }
            }
        }
    }
}

@Composable
fun MenuApp(){
    MenuCardList(platilloList = DataSource().LoadPlatillos())
}

@Composable
fun MenuCardList( platilloList: List<Platillo>,modifier: Modifier= Modifier   ){

    LazyColumn(modifier = modifier){
        items( platilloList ){
            platillo -> MenuCard(
            platillo = platillo,
                modifier = modifier.padding(10.dp)

            )
        }

    }

}

@Composable
fun MenuCard(platillo:Platillo, modifier: Modifier = Modifier ){
    Spacer(modifier = Modifier.height(10.dp))
    Card(modifier = Modifier) {

        Row(
                    modifier = Modifier
                        .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
        ){
            Image(
                painter = painterResource(id = platillo.drawableResourceId) ,
                contentDescription = stringResource(id = platillo.stringResourceId),
                modifier =
                Modifier
                    .size(190.dp, 190.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop

            )

            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = LocalContext.current.getString(platillo.stringResourceId),
                    modifier = Modifier,
                    fontSize=25.sp,
                    color= Color.Gray,

                    style = MaterialTheme.typography.headlineMedium,


                    )
                Text(
                    text = "MX $"+LocalContext.current.getString(platillo.stringResourceIdR),
                    modifier = Modifier,
                    fontSize=20.sp,
                    color= Color.Gray,

                    style = MaterialTheme.typography.headlineMedium,

                    )
                Text(
                    text = LocalContext.current.getString(platillo.stringResourceIdRes),
                    modifier = Modifier,
                    fontSize=20.sp,
                    fontWeight = FontWeight.Bold,
                    color= Color.Blue,
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.headlineMedium,

                    )
            }
        }

            

    }
}


@Composable
@Preview(showBackground = true)
fun ShowMenuCard(){
    MenuCardList(platilloList = DataSource().LoadPlatillos()  )
}




