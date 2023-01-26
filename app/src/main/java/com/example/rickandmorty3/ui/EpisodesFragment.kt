package com.example.rickandmorty3.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.rickandmorty3.databinding.FragmentEpisodesBinding

class EpisodesFragment : Fragment() {
    private lateinit var binding: FragmentEpisodesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= FragmentEpisodesBinding.inflate(LayoutInflater.from(context),container,false)
        initListeners()
        return binding.root
    }

    private fun initListeners() {
        binding.tvGoBack.setOnClickListener {
            findNavController().navigateUp()
        }}}