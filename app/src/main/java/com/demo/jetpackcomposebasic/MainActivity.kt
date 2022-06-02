package com.demo.jetpackcomposebasic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.demo.jetpackcomposebasic.ui.theme.JetpackComposeBasicTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StatesComposableComposable()
        }
    }
}

@Composable
fun StatesComposableComposable() {
    var numRemember by remember { mutableStateOf(0) }
    var numRememberSaveable by rememberSaveable { mutableStateOf(0) }
    Column(modifier = Modifier.fillMaxSize()) {

        Text(text = "conteo: $numRemember")

        Divider(thickness = 20.dp, color = Color.Transparent)

        Button(onClick = { numRemember++ }) {
            Text(text = "Sumar")
        }

        Divider()

        Text(text = "conteo: $numRememberSaveable")

        Divider(thickness = 20.dp, color = Color.Transparent)

        Button(onClick = { numRememberSaveable++ }) {
            Text(text = "Sumar")
        }
    }
}

@Preview(showBackground = true, showSystemUi = true, device = Devices.DEFAULT)
@Composable
fun DefaultPreview() {
    JetpackComposeBasicTheme {
        StatesComposableComposable()
    }
}