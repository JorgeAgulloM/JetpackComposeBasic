package com.demo.jetpackcomposebasic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.demo.jetpackcomposebasic.ui.theme.JetpackComposeBasicTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BasicComponentsComposable()
        }
    }
}

@Composable
fun BasicComponentsComposable() {

    var textValue by rememberSaveable {  mutableStateOf("Título") }
    var textFieldValue by remember {  mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "Backgroud image",
            contentScale = ContentScale.FillWidth
        )
        Text(
            text = textValue,
            modifier = Modifier.fillMaxWidth(),
            style = TextStyle(
                color = Color.Magenta,
                fontSize = 28.sp,
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.Black,
                textAlign = TextAlign.Center
            )
        )
        TextField(
            value = textFieldValue,
            onValueChange = { newText ->
                textFieldValue = newText
            },
            label = { Text(text = "Inserta el texto") },
            leadingIcon = {
                Icon(
                    modifier = Modifier.size(96.dp),
                    painter = painterResource(
                        id = R.drawable.ic_launcher_foreground
                    ),
                    contentDescription = "Icon"
                )
            }
        )
        Button(onClick = {
            textValue = textFieldValue
        }) {
            Text(text = "Aceptar")
        }
    }
}


@Preview(showBackground = true, showSystemUi = true, device = Devices.DEFAULT)
@Composable
fun DefaultPreview() {
    JetpackComposeBasicTheme {
        BasicComponentsComposable()
    }
}