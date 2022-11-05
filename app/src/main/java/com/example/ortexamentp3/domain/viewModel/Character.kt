package com.example.ortexamentp3.domain.viewModel

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Character (val id : String?, val name : String?, val species : String?, val origin : Origin, val image: String, val status: String) : Serializable


