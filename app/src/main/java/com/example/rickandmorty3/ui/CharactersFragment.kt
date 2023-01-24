package com.example.rickandmorty3.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.rickandmorty3.R
import com.example.rickandmorty3.data.RemoteRepository
import com.example.rickandmorty3.databinding.FragmentCharactersBinding
import com.example.rickandmorty3.model.Characters

@Suppress("DEPRECATION")
class CharactersFragment : Fragment() {
    private lateinit var binding: FragmentCharactersBinding
    private lateinit var adapter:AdapterCharacters
    private val repository = RemoteRepository()
    private var page =1

    override fun onCreate(savedInstanceState: Bundle?) {
        setHasOptionsMenu(true)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
       binding= FragmentCharactersBinding.inflate(LayoutInflater.from(context),container,false)
       initMethod()
        initListeners()
        return binding.root
    }

    private fun initListeners() {
        binding.nextBtn.setOnClickListener{
            ++page
            initMethod()
        }
    }

    private fun initMethod() {
        repository.getCharacters(page,this::onSuccess ,this::onFailure)
    }

    private fun onSuccess(characters: Characters){
        Log.e("TAG", "onSuccess: $characters")
        adapter = AdapterCharacters(characters,this::onCLick)
        binding.rv.adapter = adapter
    }

    private fun onCLick(id:Int){
        findNavController().navigate(R.id.infoFragment)
    }

    private fun onFailure(message:String){
        Log.e("bmv", "onFailure:$message")
    }

    @Deprecated("Deprecated in Java")
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_list,menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    @SuppressLint("ResourceType")
    @Deprecated("Deprecated in Java", ReplaceWith(
        "super.onOptionsItemSelected(item)",
        "androidx.fragment.app.Fragment"
    )
    )
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.menu_characters-> findNavController().navigate(R.id.infoFragment)
            R.id.menu_episodes -> findNavController().navigate(R.id.episodesFragment)
            R.id.menu_locations -> findNavController().navigate(R.id.locationsFragment)
        }
        return super.onOptionsItemSelected(item)
    }
}