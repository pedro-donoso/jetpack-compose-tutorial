package com.example.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyComponent()
        }
    }
}

@Composable
fun MyComponent() {
    Row() {
        MyImage()
        MyTexts()
    }
}


@Composable
fun MyImage(){
    Image(painterResource(R.drawable.ic_launcher_foreground),
        contentDescription = "Mi imagen de prueba")
}

@Composable
fun MyTexts() {
    Column {
        Text("¡Hola Jetpack Compose!")
        Text("¿Preparado?")
    }
}

@Composable
fun MyText(text: String) {
    Text(text)
}

@Preview
@Composable
fun PreviewComponents() {
    MyComponent()
}
