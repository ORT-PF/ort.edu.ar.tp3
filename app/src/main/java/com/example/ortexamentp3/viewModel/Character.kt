package com.example.ortexamentp3.viewModel

import com.google.gson.annotations.SerializedName

data class Character(

    @SerializedName("id") var id : String?,
    @SerializedName("name") var name : String?,
    @SerializedName("especies") var especies : String?,
    @SerializedName("origin") var origin : Origin

)


