package com.example.basic_codelab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.basic_codelab.ui.theme.Basic_codelabTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Basic_codelabTheme {
                // A surface container using the 'background' color from the theme
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colorScheme.background
//                ) {
//                    Greeting("Android")
//                }
                myApp(modifier = Modifier.fillMaxSize())

            }
        }
    }
}

@Composable
private fun myApp(modifier: Modifier) {
    Surface(
        modifier = modifier,
        color = MaterialTheme.colorScheme.background
    ) {
        Greeting("android")
    }
}

@Composable
fun Greeting(name: String) {

    Column {
        Text("First row")
        Text("Second row")
        Text(
            text = "Hello $name!",
            fontSize = 20.sp,
        )
        Text(
            text = "Hello $name!",
            fontSize = 20.sp,
        )
        Text(
            text = "Hello $name!",
            fontSize = 20.sp,
        )

    }

}

@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {
    Basic_codelabTheme() {
        myApp(modifier = Modifier.fillMaxSize())
    }
}