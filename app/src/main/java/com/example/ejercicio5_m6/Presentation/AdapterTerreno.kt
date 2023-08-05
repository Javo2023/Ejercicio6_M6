package com.example.ejercicio5_m6.Presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.ejercicio5_m6.R
import com.example.ejercicio5_m6.data.data.local.TerrenoEntity
import com.example.ejercicio5_m6.databinding.ItemTerrenoBinding
import com.example.ejercicio5_m6.data.data.remote.Terreno



class AdapterTerreno : RecyclerView.Adapter<AdapterTerreno.ItemTerrenoViewHolder>(){

       lateinit var binding:ItemTerrenoBinding
       private val listItemTerrenos = mutableListOf<TerrenoEntity>()

    class ItemTerrenoViewHolder (val v:ItemTerrenoBinding): RecyclerView.ViewHolder(v.root){
        fun bind(terreno: TerrenoEntity){
            v.imgTerreno.load(terreno.imagen)
            v.cardTerreno.setOnClickListener{
                val bundle = Bundle()
                bundle.putString("id", terreno.id)
                Navigation.findNavController(v.root).navigate(R.id.action_listadoTerrenosFragment_to_detalleFragment)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemTerrenoViewHolder {
        binding = ItemTerrenoBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return ItemTerrenoViewHolder(binding)

    }

    override fun getItemCount(): Int {
        return listItemTerrenos.size
    }

    override fun onBindViewHolder(holder: ItemTerrenoViewHolder, position: Int) {
        val terreno = listItemTerrenos[position]
        holder.bind(terreno)

    }

    fun setData(terreno:List<TerrenoEntity>){
        this.listItemTerrenos.clear()
        this.listItemTerrenos.addAll(terreno)
        notifyDataSetChanged()
    }


}