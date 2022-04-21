package com.growth.streetwarrior

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.growth.streetwarrior.ui.theme.RallyTheme
import com.growth.streetwarrior.ui.theme.StreetWarriorTheme
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
           StreetWarriorApp()
        }
    }
}

@Composable
fun StreetWarriorApp(){
    RallyTheme {
        val allScreens = StreetWarriorsScreen.values().toList()
        var currentScreen by rememberSaveable { mutableStateOf(StreetWarriorsScreen.BikeCrews) }
        Scaffold(

        ) { innerPadding ->
            Box(Modifier.padding(innerPadding)) {
                currentScreen.content(
                    onScreenChange = { screen ->
                        currentScreen = StreetWarriorsScreen.valueOf(screen)
                    }
                )
            }
        }
    }
}

data class Message(val author:String, val body:String)

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

//@Composable
//fun MessageCard(name: String){
//    Text(text = "Hello $name")
//}

@Composable
fun MessageCard(msg:Message){
    Row(modifier = Modifier.padding(all = 8.dp)){
        Image(painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "Contact profile picture",
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape))
        Column{
            Text(text = "Hello ${msg.author}")
            Text(text = "Hello ${msg.body}")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun previewMessageCard(){
    MessageCard(
        msg = Message("Colleague","Hey, take a look")
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    StreetWarriorTheme {
        Greeting("Android")
    }
}