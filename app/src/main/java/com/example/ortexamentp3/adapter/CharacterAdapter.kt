package com.example.ortexamentp3.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ortexamentp3.Character.CharacterListResponse
import com.example.ortexamentp3.R
import com.example.ortexamentp3.listener.OnCharacterClickedListener
import com.example.ortexamentp3.viewModel.Character
import retrofit2.Callback

class CharacterAdapter(
    private val characterList: List<Character>,
    private val onCharacterClickedListener: OnCharacterClickedListener
    ): RecyclerView.Adapter<CharacterViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.character_item, parent, false)
        return CharacterViewHolder(view)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val character = characterList[position]
        holder.bind(character)

        holder.itemView.setOnClickListener { onCharacterClickedListener.onProductSelected(character)}

    }

    override fun getItemCount(): Int {
        return characterList.size
    }


}