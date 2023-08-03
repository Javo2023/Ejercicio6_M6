package com.example.ejercicio5_m6.Presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.ejercicio5_m6.R
import com.example.ejercicio5_m6.databinding.FragmentListadoTerrenosBinding



class ListadoTerrenosFragment : Fragment() {

    lateinit var binding: FragmentListadoTerrenosBinding
    private val terrenoVM: TerrenoVM by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListadoTerrenosBinding.inflate(layoutInflater, container, false)
        initAdapter()
        // Inflate the layout for this fragment
        binding.btnCargar.setOnClickListener{
            terrenoVM.getListaTerrenos()
        }
        return binding.root
    }
    private fun initAdapter() {
        terrenoVM.getListaTerrenos()
        val adapter = AdapterTerreno()
        binding.recyclerView.adapter = adapter
        terrenoVM.terrenosLiveData.observe(viewLifecycleOwner){
            adapter.setData(it)
        }


    }

}


