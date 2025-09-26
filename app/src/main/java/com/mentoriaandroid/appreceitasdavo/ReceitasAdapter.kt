package com.mentoriaandroid.appreceitasdavo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class ReceitasAdapter(
    val cliqueBotao: ( Receita )-> Unit
) : RecyclerView.Adapter<ReceitasAdapter.ReceitaViewHolder>(){

    private var listaReceitas = listOf<Receita>()

    fun configurarLista(lista: List<Receita>){
        listaReceitas = lista
        notifyDataSetChanged()

    }

    inner class ReceitaViewHolder(val itemView: View) : ViewHolder(itemView) {//ReceitaViewHolder, ViewHolder

        private lateinit var view: View
        private lateinit var textTitulo: TextView
        private lateinit var textTempo: TextView
        private lateinit var imgReceita: ImageView
        private lateinit var clItem: ConstraintLayout


        init {
            view = itemView
            textTitulo = view.findViewById(R.id.text_titulo)
            textTempo = view.findViewById(R.id.text_tempo)
            imgReceita = view.findViewById(R.id.img_receita)
            clItem = view.findViewById(R.id.cl_item)

        }

        fun bind( receita: Receita ){

            textTitulo.text = receita.titulo
            textTempo.text = receita.tempo

            imgReceita.setImageDrawable(
                ContextCompat.getDrawable(view.context, receita.resIdImagem)
            )

            //Evento de clique
            clItem.setOnClickListener {
                cliqueBotao(receita)
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReceitaViewHolder {

        val view = LayoutInflater
            .from( parent.context )
            .inflate( R.layout.item_receitas, parent, false )

        return ReceitaViewHolder( view )
    }

    override fun onBindViewHolder(holder: ReceitaViewHolder, position: Int) {
        val receita = listaReceitas[position]
        holder.bind( receita )

    }

    override fun getItemCount(): Int {
        return listaReceitas.size
    }


}