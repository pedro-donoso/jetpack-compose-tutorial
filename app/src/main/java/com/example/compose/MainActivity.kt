package com.example.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTexts()
        }
    }
}


@Composable
fun MyTexts() {
    Column {
        Text("Hola")
        Text("Mundo")
    }
}

@Composable
fun MyText(text: String) {
    Text(text)
}

@Preview
@Composable
fun PreviewTexts() {
    MyTexts()
}
