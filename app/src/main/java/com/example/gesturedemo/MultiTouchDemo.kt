package com.example.gesturedemo

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.rememberTransformableState
import androidx.compose.foundation.gestures.transformable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp

@Composable
fun MultiTouchDemo(modifier: Modifier = Modifier) {
    var scale by remember { mutableStateOf(1f) }

    val state = rememberTransformableState { scaleChange, offsetChange, rotationChange ->
        scale *= scaleChange
    }

    Box(contentAlignment = Alignment.Center, modifier = modifier.fillMaxSize()) {
        Box(
            Modifier
                .graphicsLayer(
                    scaleX = scale,
                    scaleY = scale
                )
                .transformable(state = state)
                .background(Color.Blue)
                .size(100.dp)
        )
    }
}