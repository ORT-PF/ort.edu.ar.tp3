package com.example.ortexamentp3.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ortexamentp3.R
import com.example.ortexamentp3.domain.viewModel.Character

class FavCharacterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val characterName: TextView = itemView.findViewById(R.id.textViewName)
    private val characterStatus : TextView = itemView.findViewById(R.id.textViewStatus)
    private val characterImage  : ImageView = itemView.findViewById(R.id.character_image)

    fun bind(character : Character) {
        characterName.text = character.name
        characterStatus.text = "Status:" + character.status // ojo debe ser Status
        Glide.with(itemView)
            .load(character.image)
            .into(characterImage)
    }

}