package medium.P_120

/**
 * author       : okdori
 * date         : 4/22/24
 * description  :
 */

class Solution {
    fun minimumTotal(triangle: List<List<Int>>): Int {
        val rows = triangle.size
        val route = IntArray(rows + 1) { 0 }

        for (row in (rows - 1) downTo 0) {
            for (i in 0 until triangle[row].size) {
                route[i] = minOf(route[i], route[i + 1]) + triangle[row][i]
            }
        }

        return route[0]
    }
}
