package com.table.info.xo

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.IdRes
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.table.info.xo.models.Map
import com.table.info.xo.models.Step

class MainActivity : AppCompatActivity(){

    /**
     * Do toast for activity
     */
    fun Context.toast(message: CharSequence) =
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

    /**
     * Game map
     */
    private var map: Map = Map()

    /**
     * Current Step
     */
    private var step: Step = Step.PLAYER_1;

    /**
     * OnCreate
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buttonsInit()
    }

    /**
     * Init buttons actions
     */
    private fun buttonsInit() {
        setButtonClickStep(R.id._1, 0)
        setButtonClickStep(R.id._2, 1)
        setButtonClickStep(R.id._3, 2)
        setButtonClickStep(R.id._4, 3)
        setButtonClickStep(R.id._5, 4)
        setButtonClickStep(R.id._6, 5)
        setButtonClickStep(R.id._7, 6)
        setButtonClickStep(R.id._8, 7)
        setButtonClickStep(R.id._9, 8)
    }

    /**
     * Restart game
     */
    private fun gameInit() {
        this.map = Map()
        this.step = Step.PLAYER_1
    }

    /**
     * Display current player step
     */
    private fun displayPlayerStep(text: CharSequence) {
        (findViewById<TextView>(R.id.player) as TextView).text = text
    }

    /**
     * Do step
     */
    private fun step(id: Int, @IdRes viewId: Int) {
        val s = map.doStep(id, step);

        when (step) {
            Step.PLAYER_1 -> findViewById<Button>(viewId).text = "X"
            Step.PLAYER_2 -> findViewById<Button>(viewId).text = "O"
        }

        toast(s.toString());
        step = if(step == Step.PLAYER_1) Step.PLAYER_2 else Step.PLAYER_1
        displayPlayerStep(step.toString());

    }

    /**
     * Easy connect button step click to function
     */
    private fun setButtonClickStep(@IdRes viewId: Int, cellId: Int){
        findViewById<Button>(viewId).text = ""
        findViewById<Button>(viewId).setOnClickListener { step(cellId, viewId) };
    }

}
