package com.example.tanteo

import android.os.Parcel
import android.os.Parcelable

data class Points(
    var de1:Int = 0, var de2:Int = 0, var de3:Int = 0
): Parcelable{
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt()
    ) {
    }

    fun totalPoints() = de1 + de2 * 2 + de3 * 3
    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(de1)
        parcel.writeInt(de2)
        parcel.writeInt(de3)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Points> {
        override fun createFromParcel(parcel: Parcel): Points {
            return Points(parcel)
        }

        override fun newArray(size: Int): Array<Points?> {
            return arrayOfNulls(size)
        }
    }
}
