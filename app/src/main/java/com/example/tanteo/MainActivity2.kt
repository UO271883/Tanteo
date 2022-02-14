package com.example.tanteo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tanteo.databinding.ActivityMain2Binding
import com.example.tanteo.databinding.ActivityMainBinding

class MainActivity2 : AppCompatActivity() {
    val binding: ActivityMain2Binding by lazy{
        ActivityMain2Binding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val loc1 = intent.extras?.getInt("LDE1")
        val vis1 = intent.extras?.getInt("VDE1")
        if (loc1 != null) {
            binding.progressBar2.progress = loc1
        }
        binding.textView6.text = vis1.toString()
    }
}