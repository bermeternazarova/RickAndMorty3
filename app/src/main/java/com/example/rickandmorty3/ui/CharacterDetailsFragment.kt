package com.example.rickandmorty3.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.rickandmorty3.databinding.FragmentCharacterDetailsBinding


class CharacterDetailsFragment : Fragment() {
    private lateinit var binding: FragmentCharacterDetailsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        binding = FragmentCharacterDetailsBinding.inflate(LayoutInflater.from(context),container,false)
        initViews()
        return binding.root
    }

    private fun initViews() {
        binding.tvGoBack.setOnClickListener {
            findNavController().navigateUp()
        }
    }
}