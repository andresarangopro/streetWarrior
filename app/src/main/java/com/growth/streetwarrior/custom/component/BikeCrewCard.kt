package com.growth.streetwarrior.custom.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.growth.streetwarrior.Message
import com.growth.streetwarrior.R

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
                Text(text = "Hello ${msg.author}")
                Text(text = "Hello ${msg.body}")
            }
        }
    }
}


@Preview
@Composable
fun previewPproductCard(){
    ProductCard(Message("holi","holi"))
}