package com.hadi.dogsapp.domain.entities

import android.os.Parcel
import android.os.Parcelable

data class BreedEntity(val name: String, val subBreeds: List<String>): Parcelable {
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

        companion object CREATOR : Parcelable.Creator<BreedEntity> {
            override fun createFromParcel(parcel: Parcel): BreedEntity {
                return BreedEntity(parcel)
            }

            override fun newArray(size: Int): Array<BreedEntity?> {
                return arrayOfNulls(size)
            }
        }
    }
