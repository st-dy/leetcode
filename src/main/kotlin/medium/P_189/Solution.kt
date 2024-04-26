package medium.P_189

/**
 * author       : okdori
 * date         : 4/26/24
 * description  :
 */

class Solution {
    fun rotate(nums: IntArray, k: Int): Unit {
        val numList = nums.toMutableList()
        val numsSize = nums.size

        for (i in 1..k) {
            numList.add(0, numList.last())
            numList.removeAt(numsSize)
        }

        for ((idx, num) in numList.withIndex()) {
            nums[idx] = num
        }
    }
}
