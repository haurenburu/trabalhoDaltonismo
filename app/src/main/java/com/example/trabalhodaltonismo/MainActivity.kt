package com.example.trabalhodaltonismo

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.trabalhodaltonismo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    var testeDaltonismo = TesteDaltonismo()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.testeDaltonismo = testeDaltonismo

        binding.buttonTeste1.setOnClickListener {
            val intent = Intent(this, Daltonismoteste::class.java)
            intent.putExtra("questao", "1")
            startActivityForResult(intent, 1)
        }

        binding.buttonTeste2.setOnClickListener {
            val intent = Intent(this, Daltonismoteste::class.java)
            intent.putExtra("questao", "2")
            startActivityForResult(intent, 2)
        }

        binding.buttonTeste3.setOnClickListener {
            val intent = Intent(this, Daltonismoteste::class.java)
            intent.putExtra("questao", "3")
            startActivityForResult(intent, 3)
        }

        binding.buttonVerificar.setOnClickListener{
            if (
                binding.testeDaltonismo!!.resposta1 == "Resposta_1" ||
                binding.testeDaltonismo!!.resposta2 == "Resposta_2" ||
                binding.testeDaltonismo!!.resposta3 == "Resposta_3"
            ) {
                Toast.makeText(this, "Preencha os 3 testes", Toast.LENGTH_SHORT).show()
            } else {
                if (
                    binding.testeDaltonismo!!.resposta1 == "29" &&
                    binding.testeDaltonismo!!.resposta2 == "74" &&
                    binding.testeDaltonismo!!.resposta3 == "8"
                ) {
                    binding.testeDaltonismo!!.resultado = "Visao normal"
                    binding.invalidateAll()
                } else {
                    binding.testeDaltonismo!!.resultado = "Daltonismo"
                    binding.invalidateAll()
                }
            }
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == 1) {
            if (resultCode == Activity.RESULT_OK) {
                binding.testeDaltonismo!!.resposta1 = data?.getStringExtra("RESPOSTA").toString()
                binding.invalidateAll()
            }
        } else if(requestCode == 2) {
            if (resultCode == Activity.RESULT_OK) {
                binding.testeDaltonismo!!.resposta2 = data?.getStringExtra("RESPOSTA").toString()
                binding.invalidateAll()
            }
        } else if(requestCode == 3) {
            if (resultCode == Activity.RESULT_OK) {
                binding.testeDaltonismo!!.resposta3 = data?.getStringExtra("RESPOSTA").toString()
                binding.invalidateAll()
            }
        }
    }
}