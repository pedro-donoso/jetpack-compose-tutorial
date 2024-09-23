package com.example.compose

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose.ui.theme.ComposeTheme

private val messages: List<MyMessage> = listOf(
    MyMessage("Hola JetPack Compose 1", "¿Preparado?"),
    MyMessage("Hola JetPack Compose 2", "¿Preparado?"),
    MyMessage("Hola JetPack Compose 3", "¿Preparado?"),
    MyMessage("Hola JetPack Compose 4", "¿Preparado?"),
    MyMessage("Hola JetPack Compose 5", "¿Preparado?"),
    MyMessage("Hola JetPack Compose 6", "¿Preparado?"),
    MyMessage("Hola JetPack Compose 7", "¿Preparado?"),
    MyMessage("Hola JetPack Compose 8", "¿Preparado?"),
    MyMessage("Hola JetPack Compose 9", "¿Preparado?"),
    MyMessage("Hola JetPack Compose 10", "¿Preparado?"),
    MyMessage("Hola JetPack Compose 11", "¿Preparado?"),
    MyMessage("Hola JetPack Compose 12", "¿Preparado?")
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTheme {
                MyMessages(messages)
            }
        }
    }
}

data class MyMessage(val title: String, val body: String)

@Composable
fun MyMessages(messages: List<MyMessage>) {
    LazyColumn {
        items(messages) { message ->
            MyComponent(message)
        }
    }
}

@Composable
fun MyComponent(message: MyMessage) {
    Row(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
            .padding(8.dp)
    ) {
        MyImage()
        MyTexts(message)
    }
}

@Composable
fun MyImage() {
    Image(
        painterResource(R.drawable.ic_launcher_foreground),
        contentDescription = "Mi imagen de prueba",
        modifier = Modifier
            .clip(CircleShape)
            .background(MaterialTheme.colorScheme.primary)
            .size(64.dp)
    )
}

@Composable
fun MyTexts(messaage: MyMessage) {
    Column(modifier = Modifier.padding(start = 8.dp)) {
        MyText(
            messaage.title,
            MaterialTheme.colorScheme.onBackground,
            MaterialTheme.typography.titleLarge
        )
        Spacer(modifier = Modifier.height(16.dp))
        MyText(
            messaage.body,
            MaterialTheme.colorScheme.onBackground,
            MaterialTheme.typography.titleMedium
        )
    }
}

@Composable
fun MyText(text: String, color: Color, style: TextStyle) {
    Text(text, color = color, style = style)
}

@Preview(showSystemUi = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewComponents() {
    ComposeTheme {
        MyMessages(messages)
    }
}