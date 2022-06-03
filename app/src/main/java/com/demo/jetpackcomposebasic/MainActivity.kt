package com.demo.jetpackcomposebasic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.demo.jetpackcomposebasic.ui.theme.JetpackComposeBasicTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lists()

        }
    }
}

@Composable
fun Lists() {
    var shouldShowOnBoarding by rememberSaveable { mutableStateOf(true) }

    if (shouldShowOnBoarding) {
        OnBoardingScreen {
            shouldShowOnBoarding = false
        }
    } else {
        ListaVertical()
    }
}

@Composable
fun OnBoardingScreen(onBoardingClicked: () -> Unit) {
    Surface() {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Welcome to de Basics")
            Button(
                onClick = {},
                modifier = Modifier.padding(vertical = 24.dp)
            ) {
                Text(text = "Continue")
            }
        }
    }
}

@Composable
fun ListaVertical(){

}

data class Producto(val nombre: String, val precio: Double)

data class Publicidad(val titulo: String)

private val listaProductos = listOf<Producto>(
    Producto(nombre = "Manzana", precio = 18.33),
    Producto(nombre = "Carne", precio = 180.21),
    Producto(nombre = "Leche", precio = 24.50),
    Producto(nombre = "Pescado", precio = 75.40),
    Producto(nombre = "Huevo", precio = 32.99),
    Producto(nombre = "Cereal", precio = 21.56),
    Producto(nombre = "Naranja", precio = 2.90),
    Producto(nombre = "Café", precio = 43.60),
    Producto(nombre = "Jabón", precio = 10.11)
)

private val listaPublicidad = listOf<Publicidad>(
    Publicidad("Lista publicitária 1"),
    Publicidad("Lista publicitária 2"),
    Publicidad("Lista publicitária 3"),
    Publicidad("Lista publicitária 4"),
)


@Preview(showBackground = true, showSystemUi = true, device = Devices.DEFAULT)
@Composable
fun DefaultPreview() {
    JetpackComposeBasicTheme {
        Lists()
    }
}