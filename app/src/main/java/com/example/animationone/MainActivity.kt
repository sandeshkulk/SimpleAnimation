package com.example.animationone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.animationone.ui.theme.AnimationoneTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            var sizestate by remember { mutableStateOf(200.dp)}
            val size by animateDpAsState(targetValue = sizestate,
                // keyframes {
                // durationMillis=5000
                //   sizestate at 0 with LinearEasing
                //   sizestate*1.5f at 1000 with FastOutLinearInEasing
                // sizestate*2f at 5000 with
                //}



// spring(Spring.DampingRatioHighBouncy) 
                tween(
                    durationMillis = 3000,
                    delayMillis = 300,
                    easing = FastOutSlowInEasing)
            )
            val infiniteTransition = rememberInfiniteTransition()
            val color by infiniteTransition.animateColor(
                initialValue = Color.Gray,
                targetValue = Color.LightGray,
                animationSpec = infiniteRepeatable(
                    tween(durationMillis = 2000),
                    repeatMode = RepeatMode.Reverse
                )
            )
            Box(modifier = Modifier
                .size(size)
                .background(color), contentAlignment = Alignment.Center) {
                Button(onClick = {
                    sizestate+=50.dp
                }) {
                    Text(text = "Increase Size")
                }

            }
        }
    }
} 