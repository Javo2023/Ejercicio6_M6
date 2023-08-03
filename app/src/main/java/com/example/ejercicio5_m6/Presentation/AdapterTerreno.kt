package com.example.ejercicio5_m6.Presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.ejercicio5_m6.databinding.ItemTerrenoBinding
import com.example.ejercicio5_m6.remote.Terreno



class AdapterTerreno : RecyclerView.Adapter<AdapterTerreno.ItemTerrenoViewHolder>(){

       lateinit var binding:ItemTerrenoBinding
       private val listItemTerrenos = mutableListOf<Terreno>()

    class ItemTerrenoViewHolder (val v:ItemTerrenoBinding): RecyclerView.ViewHolder(v.root){
        fun bind(terreno:Terreno){
            v.imgTerreno.load(terreno.img)
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

    fun setData(terreno:List<Terreno>){
        this.listItemTerrenos.clear()
        this.listItemTerrenos.addAll(terreno)
        notifyDataSetChanged()
    }


}