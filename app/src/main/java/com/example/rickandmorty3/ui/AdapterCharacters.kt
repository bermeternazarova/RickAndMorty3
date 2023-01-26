package com.example.rickandmorty3.ui

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmorty3.databinding.ItemCharactersBinding
import com.example.rickandmorty3.extencion.glide
import com.example.rickandmorty3.model.*

class AdapterCharacters(private var characters: Characters,private var onClick:(Int)->Unit):RecyclerView.Adapter<AdapterCharacters.ViewHolderCharacters> (){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderCharacters {
        return ViewHolderCharacters(ItemCharactersBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolderCharacters, position: Int) {
        holder.bind(characters.results[position])
    }

    override fun getItemCount(): Int {
    return characters.results.size
    }
    fun getInfo(pos :Int):Result{
     return characters.results[pos]
    }
    inner  class ViewHolderCharacters(private var binding: ItemCharactersBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(result: Result) {
            Log.e("adapter", "bind: $result")
            binding.tvItemCharacter.text = result.name
            binding.tvSpecies.text = result.species
            binding.ivOfHeroes.glide(result.image)
            itemView.setOnClickListener{
                onClick(adapterPosition)
            }
        }
    }
}