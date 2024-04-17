package medium.P_198

/**
 * author       : okdori
 * date         : 4/17/24
 * description  :
 */

class Solution {
    fun rob(nums: IntArray): Int {
        if (nums.size == 1) return nums[0]
        val result = IntArray(nums.size) { 0 }

        result[0] = nums[0]
        result[1] = maxOf(nums[0], nums[1])

        for (i in 2 until nums.size) {
            result[i] = maxOf(result[i - 1], result[i - 2] + nums[i])
        }

        return result.last()
    }
}
