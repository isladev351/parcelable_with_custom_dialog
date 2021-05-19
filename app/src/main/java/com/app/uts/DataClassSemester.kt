package com.app.uts

import android.os.Parcel
import android.os.Parcelable

data class DataClassSemester(
    var sm1: String?,
    val sm2: String?,
    val sm3: String? ,
    val sm4: String?,
    val sm5: String?,
    val sm6: String?,
    val sm7: String?
):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(sm1)
        parcel.writeString(sm2)
        parcel.writeString(sm3)
        parcel.writeString(sm4)
        parcel.writeString(sm5)
        parcel.writeString(sm6)
        parcel.writeString(sm7)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<DataClassSemester> {
        override fun createFromParcel(parcel: Parcel): DataClassSemester {
            return DataClassSemester(parcel)
        }

        override fun newArray(size: Int): Array<DataClassSemester?> {
            return arrayOfNulls(size)
        }
    }
}