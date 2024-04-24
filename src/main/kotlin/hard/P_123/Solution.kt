package hard.P_123

/**
 * author       : okdori
 * date         : 4/24/24
 * description  :
 */

class Solution {
    fun maxProfit(prices: IntArray): Int {
        var firstSell = 0
        var secondSell = 0
        var firstBuy = Int.MAX_VALUE
        var secondBuy = Int.MAX_VALUE

        for (price in prices) {
            firstBuy = minOf(firstBuy, price);
            firstSell = maxOf(firstSell, price - firstBuy);
            secondBuy = minOf(secondBuy, price - firstSell);
            secondSell = maxOf(secondSell, price - secondBuy);
        }

        return secondSell
    }
}
