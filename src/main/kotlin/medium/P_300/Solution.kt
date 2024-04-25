package medium.P_300

/**
 * author       : okdori
 * date         : 4/25/24
 * description  :
 */

class Solution {
    fun lengthOfLIS(nums: IntArray): Int {
        if (nums.isEmpty()) return 0

        val dp = IntArray(nums.size) { 1 }

        for (i in nums.indices) {
            for (j in 0 until i) {
                if (nums[i] > nums[j]) {
                    dp[i] = maxOf(dp[i], dp[j] + 1)
                }
            }
        }

        return dp.maxOrNull() ?: 0
    }
}
