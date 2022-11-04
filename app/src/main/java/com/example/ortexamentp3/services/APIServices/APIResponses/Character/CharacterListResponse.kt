package com.example.ortexamentp3.services.APIServices.APIResponses.Character

import com.example.ortexamentp3.domain.viewModel.Character
import com.google.gson.annotations.SerializedName
import java.util.*

class CharacterListResponse (

     @SerializedName("results")  var results : List<Character>

)