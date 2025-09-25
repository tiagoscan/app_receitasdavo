package com.mentoriaandroid.appreceitasdavo

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
            Receita("Escondidinho de camarão", "25 min", R.drawable.ic_launcher_background),
            Receita("Panqueca de carne moída", "10 min", R.drawable.ic_launcher_background),
            Receita("Rocambole de carne moída", "35 min", R.drawable.ic_launcher_background),
            Receita("Escondidinho de carne seca", "42 min", R.drawable.ic_launcher_background)
        )

        //Adapter
        receitasAdapter = ReceitasAdapter()//ReceitasAdapter, Adapter
        rvReceitas.adapter = receitasAdapter
        receitasAdapter.configurarLista( lista )

        //Layout
        rvReceitas.layoutManager = LinearLayoutManager(this)

    }
}