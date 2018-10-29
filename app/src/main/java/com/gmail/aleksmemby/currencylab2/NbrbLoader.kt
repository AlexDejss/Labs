package com.gmail.aleksmemby.currencylab2

import android.util.Log
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.stream.JsonReader
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException
import java.io.StringReader
import java.net.URL
import java.util.ArrayList

/**
 * @author Aleksey Kapura
 * 21.10.2018.
 */
class NbrbLoader(private val activity: MainActivity, private val currency_codes: Array<String>) {

    private val currencies = ArrayList<Currency>()

    fun start(): ArrayList<Currency> {

        for(code in currency_codes) {
            try{
                currencies.add(loadCurrency("http://www.nbrb.by/API/ExRates/Rates/$code?ParamMode=2"))
                Log.v("RES", "$currencies.size")
            } catch (e: Exception) {
                e.printStackTrace()
            }

        }

        return currencies
    }

    private fun loadCurrency(urlString: String): Currency {
        return Gson().fromJson(URL(urlString).readText(), Currency::class.java)
    }
}
