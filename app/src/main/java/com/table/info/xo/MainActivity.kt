package com.table.info.xo

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.table.info.xo.models.Map
import com.table.info.xo.models.Step
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(){

    /**
     * Game map
     */
    private var map: Map = Map()

    /**
     * Current Step
     */
    private var step: Step = Step.PLAYER_1

    /**
     * OnCreate
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buttonsInit()
        player.text = step.toString()
    }

    /**
     * Init buttons actions
     */
    private fun buttonsInit() {
        setButtonClickStep(_1, 0)
        setButtonClickStep(_2, 1)
        setButtonClickStep(_3, 2)
        setButtonClickStep(_4, 3)
        setButtonClickStep(_5, 4)
        setButtonClickStep(_6, 5)
        setButtonClickStep(_7, 6)
        setButtonClickStep(_8, 7)
        setButtonClickStep(_9, 8)
    }

    /**
     * Restart game
     */
    fun gameInit(v: View) {
        this.map = Map()
        this.step = Step.PLAYER_1
        buttonsInit()
        reset.isEnabled = false
        winner.text = ""
        player.text = step.toString()
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
    private fun step(id: Int, view: Button) {
        val result = map.doStep(id, step)

        when (step) {
            Step.PLAYER_1 -> view.text = "X"
            Step.PLAYER_2 -> view.text = "O"
        }


        
        if (result) {
            reset.isEnabled = true
            winner.text = "${step} is victorious"
        }

        step = if(step == Step.PLAYER_1) Step.PLAYER_2 else Step.PLAYER_1
        displayPlayerStep(step.toString())

    }

    /**
     * Easy connect button step click to function
     */
    private fun setButtonClickStep(view: Button, cellId: Int){
        view.text = ""
        view.setOnClickListener { step(cellId, view) }
    }

}
