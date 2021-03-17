package com.hadi.dogsapp.data.models

import com.google.gson.JsonObject
import com.google.gson.annotations.SerializedName

data class DogApiResponse(@SerializedName("message")var result: JsonObject?)
