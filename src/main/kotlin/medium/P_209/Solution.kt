package medium.P_209

/**
 * packageName    : medium.P_209
 * fileName       : Solution
 * author         : okdori
 * date           : 3/28/24
 * description    :
 */
class Solution {
    fun minSubArrayLen(target: Int, nums: IntArray): Int {
        var result = Int.MAX_VALUE
        var cursor = 0
        var sum = 0

        for (i in nums.indices) {
            sum += nums[i]

            while (cursor <= i && sum >= target) {
                result = minOf(result, i - cursor + 1)
                sum -= nums[cursor]
                cursor++
            }
        }

        return if (result == Int.MAX_VALUE) 0 else result

//        for (i in nums.indices) {
//            for (j in i..nums.lastIndex) {
//                if (sum < target) {
//                    sum += nums[j]
//                    count++
//                } else {
//                    if (result == 0 || count < result) result = count
//                    break
//                }
//            }
//            if (sum >= target) {
//                if (result == 0 || count < result) result = count
//            }
//            count = 0
//            sum = 0
//        }
//
//        return result
    }
}
