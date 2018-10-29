package com.gmail.aleksmemby.currencylab2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    private val currencyCodes = arrayOf("USD", "EUR", "RUB", "PLN")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadInfo()
    }

    private fun loadInfo() {
        val context = this
        progressBar.visibility = View.VISIBLE
        doAsync{
            val loader = NbrbLoader(context, currencyCodes)
            val res = loader.start()
            uiThread {
                result_screen.adapter = CurrencyAdapter(res)
                result_screen.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL,false)
                progressBar.visibility = View.INVISIBLE
            }
        }
    }

    internal inner class CurrencyAdapter(list: ArrayList<Currency>) : RecyclerView.Adapter<CurrencyHolder>() {

        var currencies = ArrayList<Currency>()

        init {
            this.currencies = list
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrencyHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.result_row, parent, false)
            return CurrencyHolder(view, this@MainActivity)
        }

        override fun onBindViewHolder(holder: CurrencyHolder, position: Int) {
            val currency = currencies[position]
            holder.updateUI(currency)
        }

        override fun getItemCount(): Int {
            return currencies.size
        }
    }
}
