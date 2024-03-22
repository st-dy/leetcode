package easy.P_169

/**
 * packageName    : easy.P_169
 * fileName       : Solution
 * author         : okdori
 * date           : 3/22/24
 * description    :
 */
class Solution {
    fun majorityElement(nums: IntArray): Int {
        var majority = 0
        var count = 0

        for(num in nums) {
            if(count == 0) majority = num

            if(num == majority) {
                count++
            } else {
                count--
            }
        }

        return majority
    }
}
