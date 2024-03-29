package easy.P_228

/**
 * packageName    : easy.P_228
 * fileName       : Solution
 * author         : okdori
 * date           : 3/29/24
 * description    :
 */
class Solution {
    fun summaryRanges(nums: IntArray): List<String> {
        if (nums.isEmpty()) return listOf()
        val result = mutableListOf<String>()
        var idx = 0
        var diff = nums[idx]
        var range = diff

        fun append() {
            if (range != nums[idx - 1]) {
                result.add("$range->${nums[idx - 1]}")
            } else {
                result.add(range.toString())
            }
        }

        while (idx < nums.size) {
            if (nums[idx] != diff + idx) {
                append()
                range = nums[idx]
                diff = nums[idx] - idx
            }
            idx++
        }

        append()
        return result
    }
}
