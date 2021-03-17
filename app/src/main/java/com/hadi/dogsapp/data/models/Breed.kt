package com.hadi.dogsapp.data.models

import android.os.Parcel
import android.os.Parcelable

data class Breed(val name: String, val subBreeds: List<String>): Parcelable {
        constructor(parcel: Parcel) : this(
            parcel.readString()!!,
            parcel.createStringArrayList()!!
        )

        override fun writeToParcel(parcel: Parcel, flags: Int) {
            parcel.writeString(name)
            parcel.writeStringList(subBreeds)
        }

        override fun describeContents(): Int {
            return 0
        }

        companion object CREATOR : Parcelable.Creator<Breed> {
            override fun createFromParcel(parcel: Parcel): Breed {
                return Breed(parcel)
            }

            override fun newArray(size: Int): Array<Breed?> {
                return arrayOfNulls(size)
            }
        }
    }
