package medium.P_64

/**
 * author       : okdori
 * date         : 4/23/24
 * description  :
 */

class Solution {
    fun minPathSum(grid: Array<IntArray>): Int {
        val rows = grid.size - 1
        val cols = grid[0].size - 1

        for (row in 0 .. rows) {
            for (col in 0 .. cols) {
                if (row == 0 && col == 0) continue
                grid[row][col] += when {
                    row == 0 -> grid[row][col - 1]
                    col == 0 -> grid[row - 1][col]
                    else -> minOf(grid[row][col - 1], grid[row - 1][col])
                }
            }
        }

        return grid[rows][cols]
    }
}
