package com.example.dummy.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.lifecycleScope
import com.example.dummy.MainApp
import com.example.dummy.data.ProductApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


class MainActivity : ComponentActivity() {

    @Inject
    lateinit var productApiService: ProductApiService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

        }
        (applicationContext as MainApp).appComponent.inject(this)
    }
}

@Preview
@Composable
fun Loggin() {
    val loggin = remember {
        mutableStateOf("Unknow")
    }
    val password = remember {
        mutableStateOf("Unknow")
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.5f),
            Arrangement.Center,
            Alignment.CenterHorizontally
        ) {
            Box( modifier = Modifier.padding(30.dp),
                contentAlignment = Alignment.Center
            ) {

                TextField(value = loggin.value, onValueChange = {
                    loggin.value = it
                })
            }
            Box(
                contentAlignment = Alignment.Center
            ) {

                TextField(value = password.value, onValueChange = {
                    password.value = it
                }, )
            }
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            contentAlignment = Alignment.BottomCenter
        ) {
            Button(onClick = { /*TODO*/ }) {
                Text(text = "Click")
            }
        }
    }
}