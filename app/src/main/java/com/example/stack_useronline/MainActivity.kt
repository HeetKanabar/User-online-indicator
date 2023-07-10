package com.example.stack_useronline

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.stack_useronline.ui.theme.StackuserOnlineTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StackuserOnlineTheme {
                DrawUsers(
                    users = listOf(
                        User(image = R.drawable.person2, isOnline = true),
                        User(image = R.drawable.person2, isOnline = false),
                        User(image = R.drawable.person2, isOnline = true),
                    )
                )
            }
        }
    }
}
@Composable
fun DrawUsers(users: List<User>) {
    LazyRow(
        modifier = Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        items(users) {
            Box(Modifier.padding(10.dp)) {
                Image(
                    painter = painterResource(id = it.image),
                    contentDescription = "user",
                    modifier = Modifier
                        .clip(
                            RoundedCornerShape(50.dp)
                        )
                        .size(width = 75.dp, height = 75.dp),
                    contentScale = ContentScale.Crop,
                )
//                Image(
//                    painter = painterResource(id = R.drawable.dot),
//                    contentDescription = "dot",
//                    modifier = Modifier
//                        .clip(
//                            CircleShape
//                        )
//                        .border(5.dp, color = Color.Black, shape = CircleShape)
//                        .align(Alignment.BottomEnd)
//                )
                Box(
                    modifier = Modifier
                        .padding(end = 5.dp, bottom = 2.dp)
                        .size(15.dp)
                        .clip(CircleShape)
                        .align(Alignment.BottomEnd)
//                    .border(2.dp, color = Color.Gray, shape = CircleShape)
                        .background(color = if (it.isOnline) Color.Green else Color.Red)
                )
            }
        }
    }
}

data class User(@DrawableRes val image: Int, val isOnline: Boolean)