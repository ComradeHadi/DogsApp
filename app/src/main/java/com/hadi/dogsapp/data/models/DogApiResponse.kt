package com.hadi.dogsapp.data.models

import com.google.gson.JsonObject
import com.google.gson.annotations.SerializedName

data class DogApiResponse<T>(
        @SerializedName("message")
        var result: T ,

        @SerializedName("status")
        val status: String
)
