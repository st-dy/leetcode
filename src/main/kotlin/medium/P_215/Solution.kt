package medium.P_215

import java.util.PriorityQueue

/**
 * author       : okdori
 * date         : 4/12/24
 * description  :
 */

class Solution {
    fun findKthLargest(nums: IntArray, k: Int): Int {
        val deque = PriorityQueue<Int>(reverseOrder())
        deque.addAll(nums.asList())
        for (i in 1 until k) {
            println(deque.poll())
        }
        return deque.poll()

//        val heap = PriorityQueue<Int>()
//        for (num in nums) {
//            heap.add(num)
//            if (heap.size > k) {
//                heap.remove()
//            }
//        }
//        return heap.peek()
    }
}
