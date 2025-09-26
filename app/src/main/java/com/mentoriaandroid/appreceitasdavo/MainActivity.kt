package com.mentoriaandroid.appreceitasdavo

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var rvReceitas: RecyclerView
    private lateinit var receitasAdapter: ReceitasAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        rvReceitas = findViewById(R.id.rv_receitas)

        val lista = listOf(
            Receita("Escondidinho de camarão", "25 min", R.drawable.ic_launcher_background,
            listOf("1KG de camarao", "Manteiga", "alho", "cebola")
            ),
            Receita("Panqueca de carne moída", "10 min", R.drawable.ic_launcher_background,
                listOf("1KG de picanha", "Manteiga", "alho", "cebola")
            ),
            Receita("Rocambole de carne moída", "35 min", R.drawable.ic_launcher_background,
                listOf("1KG de moida", "Manteiga", "alho", "cebola")
            ),
            Receita("Escondidinho de carne seca", "42 min", R.drawable.ic_launcher_background,
                listOf("1KG de carne seca", "Manteiga", "alho", "cebola")
            )
        )

        //Adapter
        //ReceitasAdaptaer, Adapter
        receitasAdapter = ReceitasAdapter { receita ->
            val intent = Intent(this, DetalhesActivity::class.java)
            intent.putExtra("receita", receita)
            startActivity( intent )
        }
        rvReceitas.adapter = receitasAdapter
        receitasAdapter.configurarLista( lista )

        //Layout
        rvReceitas.layoutManager = LinearLayoutManager(this)

    }
}