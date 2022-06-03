package com.demo.jetpackcomposebasic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.coerceAtLeast
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
        OnBoardingScreen { shouldShowOnBoarding = false }
    } else {
        Column {
            HorizontalList()
            VerticalList()
        }
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
                onClick = {
                    onBoardingClicked.invoke()
                },
                modifier = Modifier.padding(vertical = 24.dp)
            ) {
                Text(text = "Continue")
            }
        }
    }
}

@Composable
fun VerticalList() {
    LazyColumn(contentPadding = PaddingValues(16.dp)) {
        item {
            Text(text = "Mi lista")
        }
        items(items = productList) { product ->
            ProductViewVertical(product.name, product.price)
        }
    }
}

@Composable
fun HorizontalList() {
    LazyRow(contentPadding = PaddingValues(16.dp), modifier = Modifier.fillMaxHeight(0.35f)) {
        item {
            Text(text = "Mi lista")
        }
        items(items = productList) { product ->
            ProductViewHorizontal(product.name, product.price)
        }
    }
}

@Composable
fun ProductViewVertical(name: String, price: Double) {

    var expanded by remember {
        mutableStateOf(false)
    }

    val extraPadding by animateDpAsState(
        if (expanded) 96.dp else 0.dp,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessLow
        )
    )

    Surface(
        color = MaterialTheme.colors.primary,
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
        Row(modifier = Modifier.padding(24.dp)) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(bottom = extraPadding.coerceAtLeast(0.dp))
            ) {
                Text(text = name)
                Text(text = price.toString())
            }
            OutlinedButton(onClick = {
                expanded = !expanded
            }) {
                Text(text = if (expanded) "Show less" else "Show more")
            }
        }
    }
}

@Composable
fun ProductViewHorizontal(name: String, price: Double) {

    var expanded by remember {
        mutableStateOf(false)
    }

    val extraPadding by animateDpAsState(
        if (expanded) 96.dp else 0.dp,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessLow
        )
    )

    Surface(
        color = MaterialTheme.colors.primary,
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
        Column(modifier = Modifier.padding(24.dp)) {
            Column(
                modifier = Modifier
                    .padding(bottom = extraPadding.coerceAtLeast(0.dp))
            ) {
                Text(text = name)
                Text(text = price.toString())
            }
            OutlinedButton(onClick = {
                expanded = !expanded
            }) {
                Text(text = if (expanded) "Show less" else "Show more")
            }
        }
    }
}

data class Product(val name: String, val price: Double)

data class Publicity(val title: String)

private val productList = listOf<Product>(
    Product(name = "Manzana", price = 18.33),
    Product(name = "Carne", price = 180.21),
    Product(name = "Leche", price = 24.50),
    Product(name = "Pescado", price = 75.40),
    Product(name = "Huevo", price = 32.99),
    Product(name = "Cereal", price = 21.56),
    Product(name = "Naranja", price = 2.90),
    Product(name = "Café", price = 43.60),
    Product(name = "Jabón", price = 10.11),
    Product(name = "Manzana", price = 18.33),
    Product(name = "Carne", price = 180.21),
    Product(name = "Leche", price = 24.50),
    Product(name = "Pescado", price = 75.40),
    Product(name = "Huevo", price = 32.99),
    Product(name = "Cereal", price = 21.56),
    Product(name = "Naranja", price = 2.90),
    Product(name = "Café", price = 43.60),
    Product(name = "Jabón", price = 10.11)
)

private val PublicityList = listOf<Publicity>(
    Publicity("Lista publicitária 1"),
    Publicity("Lista publicitária 2"),
    Publicity("Lista publicitária 3"),
    Publicity("Lista publicitária 4"),
)


@Preview(showBackground = true, showSystemUi = true, device = Devices.DEFAULT)
@Composable
fun DefaultPreview() {
    JetpackComposeBasicTheme {
        Lists()
    }
}