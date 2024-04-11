package easy.P_35

/**
 * author       : okdori
 * date         : 4/11/24
 * description  :
 */

class Solution {
    fun searchInsert(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.size
        var mid = 0

        while (left < right) {
            mid = (left + right) / 2
            if (nums[mid] >= target) right = mid
            else left = mid + 1
        }

        return left

//        var diff = 0
//        while (true) {
//            if (right - left < 2) break
//            diff = nums[mid] - target
//            when {
//                diff < 0 -> {
//                    left = mid
//                    mid = (left + right) / 2
//                }
//                diff == 0 -> return mid
//                diff > 0 -> {
//                    right = mid
//                    mid = (left + right) / 2
//                }
//            }
//        }
//
//        return if (nums[left] < target) left + 1 else left
    }
}
