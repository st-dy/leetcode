package medium.P_80

/**
 * packageName    : medium.P_80
 * fileName       : Solution
 * author         : okdori
 * date           : 3/22/24
 * description    :
 */
class Solution {
    fun removeDuplicates(nums: IntArray): Int {
        var j = 1
        var doubleCheck = 1
        for (i in 1 until nums.size) {
            if (nums[i] != nums[i - 1]) {
                nums[j] = nums[i];
                j++;
                doubleCheck = 1
            } else if (nums[i] == nums[i - 1]) {
                when (doubleCheck) {
                    1 -> {
                        nums[j] = nums[i];
                        j++;
                        doubleCheck++
                    }
                    2 -> {
                        doubleCheck = 0
                    }
                }
            }
        }
        return j
    }
}
