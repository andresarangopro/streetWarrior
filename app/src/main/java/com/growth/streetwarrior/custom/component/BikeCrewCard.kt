package com.growth.streetwarrior.custom.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.growth.streetwarrior.R


data class Message(val id:String, val message:String)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductCard(
    msg:Message
){
    Card{
        Row(modifier = Modifier.padding(all = 8.dp)){
            Image(painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = "Contact profile picture",
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape))
            Column{
                Text(text = "Hello ${msg.id}")
                Text(text = "Hello ${msg.message}")
            }
        }
    }
}


@Preview
@Composable
fun previewPproductCard(){
    ProductCard(Message("holi","holi"))
}