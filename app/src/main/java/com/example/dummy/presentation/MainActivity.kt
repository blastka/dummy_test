package com.example.dummy.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
            val productState = remember { mutableStateOf("Loading...") }

            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = productState.value,
                    modifier = Modifier.padding(16.dp)
                )
                Spacer(modifier = Modifier.height(160.dp))
                Button(
                    onClick = {
                        lifecycleScope.launch(Dispatchers.IO) {
                            val result = productApiService.getProductById(3)
                            productState.value = result.toString()
                        }
                    },
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text("Button")
                }
            }
        }
        (applicationContext as MainApp).appComponent.inject(this)
    }
}