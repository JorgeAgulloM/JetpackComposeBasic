package com.demo.jetpackcomposebasic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
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

}

@Preview(showBackground = true, showSystemUi = true, device = Devices.DEFAULT)
@Composable
fun DefaultPreview() {
    JetpackComposeBasicTheme {
        StatesComposableComposable()
    }
}