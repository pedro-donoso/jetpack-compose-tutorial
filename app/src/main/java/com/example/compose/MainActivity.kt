package com.example.compose

// importaciones
import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose.ui.theme.ComposeTheme

// lista de mensajes
private val messages: List<MyMessage> = listOf(
    // cada mensaje tiene un titulo y un cuerpo
    MyMessage(
        "Hola JetPack Compose 1",
        "¿Preparado? Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer sed libero erat. Lorem ipsum dolor sit amet, consectetur adipiscing elit. "
    ),
    MyMessage(
        "Hola JetPack Compose 2",
        "¿Preparado? Vestibulum sit amet justo sit amet risus sagittal sodales id sed neque. Donec nec est ligula. Aenean mattis sodales tincidunt. Phasellus"
    ),
    MyMessage(
        "Hola JetPack Compose 3",
        "¿Preparado? lectus orci, efficitur non porttitor eget, porta a odio. Quisque venenatis, mauris a ultrices fringilla, metus ipsum maximus sapien, eu"
    ),
    MyMessage(
        "Hola JetPack Compose 4",
        "¿Preparado? ultricies sapien massa in lectus. Nullam quis pellentesque felis. Suspendisse viverra interdum aliquam."
    ),
    MyMessage(
        "Hola JetPack Compose 5",
        "¿Preparado? Phasellus mattis sem ut est ultrices volutpat. Donec ultricies nisi ut ipsum mollis aliquet. Fusce pellentesque sollicitudin risus, sit amet"
    ),
    MyMessage(
        "Hola JetPack Compose 6",
        "¿Preparado? rhoncus eros malesuada id. Nunc et velit ipsum. Sed ac arcu rutrum, consequat nisi vel, rutrum turpis. Nulla malesuada arcu ac commodo"
    ),
    MyMessage(
        "Hola JetPack Compose 7",
        "¿Preparado? porta. Praesent tortor dolor, volutpat sed lorem eu, porta vestibulum magna. Donec sit amet volutpat leo, sed sodales mauris. Donec nisl"
    ),
    MyMessage(
        "Hola JetPack Compose 8",
        "¿Preparado? sapien, scelerisque ac velit sed, maximus imperdiet lacus. Nam faucibus augue ac est eleifend sollicitudin. Aliquam eget eros bibendum,"
    ),
    MyMessage(
        "Hola JetPack Compose 9",
        "¿Preparado? varius sapien ut, ullamcorper erat. Vivamus nec ex urna. Vestibulum vel velit eget nulla finibus malesuada. Quisque eget pulvinar odio. Sed"
    ),
    MyMessage(
        "Hola JetPack Compose 10",
        "¿Preparado? In eu orci in nulla pellentesque efficitur. Nullam ut orci in enim accumsan ornare. Praesent fringilla neque efficitur odio varius fermentum."
    ),
    MyMessage(
        "Hola JetPack Compose 11",
        "¿Preparado? Morbi elementum in odio sed vestibulum. Suspendisse accumsan purus nec quam pulvinar dapibus. Morbi neque tortor, ullamcorper in"
    ),
    MyMessage(
        "Hola JetPack Compose 12",
        "¿Preparado? massa ac, egestas volutpat nunc. Nullam metus elit, consequat ac scelerisque eu, mattis id dui. Nam a iaculis nunc, non laoreet nisi."
    )
)

// clase principal de la actividad
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // el tema de la aplicacion
            ComposeTheme {
                // el contenido de la actividad
                MyMessages(messages)
            }
        }
    }
}

// clase de mensaje con titulo y cuerpo
data class MyMessage(val title: String, val body: String, val expanded: Boolean = false)

@Composable
// funcion que muestra una lista de mensajes
fun MyMessages(messages: List<MyMessage>) {
    // una lista vertical
    LazyColumn {
        // para cada mensaje se muestra un componente
        items(messages) { message ->
            // se muestra el componente
            MyComponent(message)
        }
    }
}

@Composable
// funcion que muestra un componente
fun MyComponent(message: MyMessage) {
    // un contenedor con un color de fondo y un padding
    Row(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
            .padding(20.dp)
    ) {
        // se muestra la imagen y el texto
        MyImage()
        MyTexts(message)
    }
}

@Composable
// funcion que muestra una imagen
fun MyImage() {
    // una imagen con un circulo de esquina y un color de fondo
    Image(
        // se usa un recurso de imagen
        painterResource(R.drawable.ic_launcher_foreground),
        contentDescription = "Mi imagen de prueba",
        modifier = Modifier
            .clip(CircleShape)
            .background(MaterialTheme.colorScheme.primary)
            .size(64.dp)
    )
}

@Composable
// funcion que muestra el texto
fun MyTexts(message: MyMessage) {

    // el texto se puede expandir
    var expanded by remember { mutableStateOf(false) }

    // un contenedor con un padding y un clickeable
    Column(modifier = Modifier
        .padding(start = 8.dp)
        .clickable {
            expanded = !expanded
        }) {
        // se muestra el texto
        MyText(
            message.title,
            MaterialTheme.colorScheme.onBackground,
            MaterialTheme.typography.titleLarge
        )
        // se muestra un espacio
        Spacer(modifier = Modifier.height(16.dp))
        // se muestra el texto
        MyText(
            message.body,
            MaterialTheme.colorScheme.onBackground,
            MaterialTheme.typography.titleMedium,
            if (expanded) Int.MAX_VALUE else 1
        )
    }
}

@Composable
// funcion que muestra un texto
fun MyText(text: String, color: Color, style: TextStyle, lines: Int = Int.MAX_VALUE) {
    Text(text, color = color, style = style, maxLines = lines)
}

@Preview(showSystemUi = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
// funcion de vista previa
fun PreviewComponents() {
    ComposeTheme {
        MyMessages(messages)
    }
}