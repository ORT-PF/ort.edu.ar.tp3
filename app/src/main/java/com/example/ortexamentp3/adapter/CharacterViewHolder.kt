package com.example.ortexamentp3.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ortexamentp3.Character.CharacterListResponse
import com.example.ortexamentp3.R
import com.example.ortexamentp3.viewModel.Character

class CharacterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val titleText: TextView = itemView.findViewById(R.id.item_title)

    fun bind(character : CharacterListResponse) {
        titleText.text = character.name
    }

}