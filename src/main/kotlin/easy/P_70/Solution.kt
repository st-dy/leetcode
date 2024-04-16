package easy.P_70

/**
 * author       : okdori
 * date         : 4/16/24
 * description  :
 */

class Solution {
    fun climbStairs(n: Int): Int {
        var p = 0
        var c = 1
        for (i in 1..n) c += p.also { p = c }
        return c
    }
}
