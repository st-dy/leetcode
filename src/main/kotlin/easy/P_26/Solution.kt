package easy.P_26

/**
 * packageName    : easy.P_26
 * fileName       : Solution
 * author         : okdori
 * date           : 3/22/24
 * description    :
 */
class Solution {
    fun removeDuplicates(nums: IntArray): Int {
        var j = 1
        for (i in 1 until nums.size) {
            if (nums[i] != nums[i - 1]) {
                nums[j] = nums[i];
                j++;
            }
        }
        return j
    }
}
