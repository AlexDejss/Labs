package com.gmail.aleksmemby.currencylab2

import com.google.gson.annotations.SerializedName

/**
 * @author Aleksey Kapura
 * 21.10.2018.
 */
class Currency (
        @SerializedName("Cur_ID") val id: Number,
        @SerializedName("Cur_Abbreviation") val abbreviation: String,
        @SerializedName("Cur_Scale") val scale: Number,
        @SerializedName("Cur_Name") val name: String,
        @SerializedName("Cur_OfficialRate") val rate: Number
)