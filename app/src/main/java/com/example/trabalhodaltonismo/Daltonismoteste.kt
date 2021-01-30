package com.example.trabalhodaltonismo

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.trabalhodaltonismo.databinding.ActivityDaltonismotesteBinding

class Daltonismoteste : AppCompatActivity() {
    lateinit var binding: ActivityDaltonismotesteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_daltonismoteste)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_daltonismoteste)

        when(intent.getStringExtra("questao")) {
            "1"->{
                binding.imageView.setImageResource(R.drawable.teste1)
            }
            "2"->{
                binding.imageView.setImageResource(R.drawable.teste2)
            }
            "3"->{
                binding.imageView.setImageResource(R.drawable.teste3)
            }
        }


        binding.buttonCancelar.setOnClickListener{
            setResult(Activity.RESULT_CANCELED)
            finish()
        }

        binding.buttonOk.setOnClickListener{
            val res = binding.editTextNumberResposta.text.toString();
            if (res != ""){
                val i = Intent()
                i.putExtra("RESPOSTA", binding.editTextNumberResposta.text.toString())
                setResult(Activity.RESULT_OK, i)
                finish()
            } else {
                Toast.makeText(this, "Nao pode ser vazio", Toast.LENGTH_SHORT).show()
            }
        }
    }
}