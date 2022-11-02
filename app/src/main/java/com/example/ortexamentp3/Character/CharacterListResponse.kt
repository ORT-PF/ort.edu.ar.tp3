package com.example.ortexamentp3.Character

import com.google.gson.annotations.SerializedName

class CharacterListResponse (

    @SerializedName("id") var id : String?,
    @SerializedName("name") var name : String?,
    @SerializedName("especies") var especies : String?,
    @SerializedName("origin") var origin : String?

)