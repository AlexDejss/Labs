package com.gmail.aleksmemby.currencylab2

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView

/**
 * @author Aleksey Kapura
 * 21.10.2018.
 */
class CurrencyHolder(itemView: View, activity: MainActivity) : RecyclerView.ViewHolder(itemView) {

    private val Name: TextView = itemView.findViewById(R.id.names)
    private val BY: TextView = itemView.findViewById(R.id.nbrb)

    fun updateUI(currency: Currency) {
        Name.text = currency.name
        BY.text = currency.rate.toString()
    }
}
