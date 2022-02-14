package com.example.tanteo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.tanteo.databinding.ActivityMainBinding

val TAG = "Tanteo"
lateinit var miViewModel: MiViewModel

class MainActivity : AppCompatActivity() {
    val binding: ActivityMainBinding by lazy{
        ActivityMainBinding.inflate(layoutInflater)
    }
    val local = Points()
    val visitante = Points()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        //miViewModel = ViewModelProvider(this).get(MiViewModel::class.java)
        binding.localMasUnoButton.setOnClickListener {
            local.de1 = local.de1 + 1

            binding.localMasUnoTV.text = local.de1.toString()
            binding.localScore.text = local.totalPoints().toString()
        }
        binding.localMasDosButton.setOnClickListener {
            local.de2 = local.de2 + 1

            binding.localMasDosTV.text = local.de2.toString()
            binding.localScore.text = local.totalPoints().toString()
        }
        binding.localMasTresButton.setOnClickListener {
            local.de3++

            binding.localMasTresTV.text = local.de3.toString()
            binding.localScore.text = local.totalPoints().toString()
        }
        binding.visitMasUnoButton.setOnClickListener {
            visitante.de1++

            binding.visitMasUnoTV.text = visitante.de1.toString()
            binding.visitScore.text = visitante.totalPoints().toString()
        }
        binding.visitMasDosButton.setOnClickListener {
            visitante.de2++

            binding.visitMasDosTV.text = visitante.de2.toString()
            binding.visitScore.text = visitante.totalPoints().toString()
        }
        binding.visitMasTresButton.setOnClickListener {
            visitante.de3++

            binding.visitMasTresTV.text = visitante.de3.toString()
            binding.visitScore.text = visitante.totalPoints().toString()
        }
        binding.estadisticasButton.setOnClickListener{
            val bundle = Bundle().apply{
                putInt("LDE1", local.de1)
                putInt("VDE1", visitante.de1)
                /*putParcelable("Puntos", local)*/
            }
            val intent = Intent(this, MainActivity2::class.java).apply{
                putExtras(bundle)
            }
            startActivity(intent)
        }
    }
}