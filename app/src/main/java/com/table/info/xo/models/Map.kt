package com.table.info.xo.models

/**
 * Created by akap on 07.09.2018.
 */
public class Map() {
    /**
     * Game field
     */
    var map = intArrayOf(0,0,0,0,0,0,0,0,0)

    public fun doStep(cellId: Int, player: Step): Boolean {
        when (player) {
            Step.PLAYER_1 -> map[cellId] = 1;
            Step.PLAYER_2 -> map[cellId] = 2;
        }

        return checkWin(cellId);
    }

    /**
     * Check win
     */
    private fun checkWin(cellId: Int): Boolean {

        val row = cellId - cellId % 3
        if (map[row] == map[row + 1] && map[row] == map[row + 2])
            return true

        val column = cellId % 3
        if (map[column] == map[column + 3])
            if (map[column] == map[column + 6]) return true

        if (cellId % 2 != 0) return false

        if (cellId % 4 == 0) {
            if (map[0] == map[4] && map[0] == map[8])
                return true
            if (cellId != 4) return false
        }
        return map[2] == map[4] && map[2] == map[6]
    }

}