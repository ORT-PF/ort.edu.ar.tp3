package com.example.ortexamentp3.Character

import com.example.ortexamentp3.viewModel.Character
import com.google.gson.annotations.SerializedName
import java.util.*

class CharacterListResponse (

     @SerializedName("results")  var results : List<Character>

)