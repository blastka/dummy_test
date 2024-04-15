package com.example.dummy.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.dummy.R
import com.example.dummy.data.ProductApiService
import com.example.dummy.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject


class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var productApiService: ProductApiService

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        (applicationContext as MainApp).appComponent.inject(this)
        binding.button.setOnClickListener {
            lifecycleScope.launch(Dispatchers.IO) {
                val result = productApiService.getProductById()
                withContext(Dispatchers.Main){
                    binding.textView.text = result.toString()
                }
            }

        }
    }
}