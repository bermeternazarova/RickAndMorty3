package com.example.rickandmorty3.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.rickandmorty3.databinding.FragmentCharacterDetailsBinding
import com.example.rickandmorty3.extencion.glide
import com.example.rickandmorty3.model.Result


class CharacterDetailsFragment : Fragment() {
    private lateinit var binding: FragmentCharacterDetailsBinding
    private lateinit var result: Result
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        binding = FragmentCharacterDetailsBinding.inflate(LayoutInflater.from(context),container,false)
        initViews()
        info()
        return binding.root
    }

    private fun info() {
        if (arguments!=null){
        result = arguments?.getSerializable("key") as Result
            binding.tvName.text = result.name
            binding.tvSpecie2.text = result.species
            binding.tvGender2.text = result.gender
            binding.tvStatus2.text = result.status
            binding.tvOrigin2.text = result.origin.name
            binding.tvType2.text = result.type
            binding.tvLocation2.text =result.location.name
            binding.imageView.glide(result.image)
        }}

    private fun initViews() {
        binding.tvGoBack.setOnClickListener {
            findNavController().navigateUp()
        }
    }
}