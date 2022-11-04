package com.example.ortexamentp3.viewModel

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Character (val id : String?, val name : String?, val especies : String?, val origin : Origin) : Serializable

   /* @SerializedName("id") var id : String?,
    @SerializedName("name") var name : String?,
    @SerializedName("especies") var especies : String?,
    @SerializedName("origin") var origin : Origin
*/



