package com.hadi.dogsapp.data.models

import com.google.gson.JsonArray
import com.google.gson.JsonObject
import com.google.gson.annotations.SerializedName

data class DogImageApiResponse(@SerializedName("message") var result: JsonArray?)
