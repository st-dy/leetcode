package medium.P_128

/**
 * author       : okdori
 * date         : 5/2/24
 * description  :
 */

class Solution {
    fun longestConsecutive(nums: IntArray): Int {
        if (nums.isEmpty()) return 0
        nums.sort()
        var result = 0
        var count = 1

        for (i in 1 until nums.size) {
            if (nums[i - 1] + 1 == nums[i]) {
                count++
            } else if (nums[i - 1] == nums[i]) {
              continue
            } else {
                if (result < count) result = count
                count = 1
            }
        }

        return if (result < count) count else result
    }
}
