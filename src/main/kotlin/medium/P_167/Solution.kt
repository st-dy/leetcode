package medium.P_167

/**
 * author       : okdori
 * date         : 4/30/24
 * description  :
 */

class Solution {
    fun twoSum(numbers: IntArray, target: Int): IntArray {
        var left = 0
        var right = numbers.size - 1

        while (left < right) {
            val sum = numbers[left] + numbers[right]
            when {
                sum == target -> break
                sum < target -> left++
                sum > target -> right--
            }
        }

        return intArrayOf(left + 1, right + 1)
    }
}
