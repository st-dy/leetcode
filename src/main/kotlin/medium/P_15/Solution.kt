package medium.P_15

import java.util.*


/**
 * author       : okdori
 * date         : 4/29/24
 * description  :
 */

class Solution {
    private var result: MutableList<List<Int>> = ArrayList()

    private fun twoSum(nums: IntArray, pivot: Int, pivotIndex: Int) {
        var left = pivotIndex + 1
        var right = nums.size - 1
        val target = -pivot

        var sum: Int
        while (left < right) {
            sum = nums[left] + nums[right]
            if (sum == target) {
                result.add(listOf(pivot, nums[left++], nums[right--]))
                while (left < right && nums[left] == nums[left - 1]) left++
            }
            else if (sum < target) left++
            else right--
        }
    }

    fun threeSum(nums: IntArray): List<List<Int>> {
        Arrays.sort(nums)

        var pivot: Int
        var i = 0
        while (i < nums.size && nums[i] <= 0) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                i++
                continue
            }
            pivot = nums[i]
            twoSum(nums, pivot, i)
            i++
        }
        return result
    }
}
