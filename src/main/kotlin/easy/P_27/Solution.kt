package easy.P_27

/**
 * packageName    : easy.P_27
 * fileName       : Solution
 * author         : okdori
 * date           : 3/22/24
 * description    :
 */
class Solution {
    fun removeElement(nums: IntArray, value: Int): Int {
        var idx = 0
        for (i in 0 until nums.size) {
            if (nums[i] != value) {
                nums[idx++] = nums[i]
            }
        }
        return idx
    }
}
