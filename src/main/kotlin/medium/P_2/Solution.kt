package medium.P_2

import structure.ListNode

/**
 * packageName    : medium.P_2
 * fileName       : Solution
 * author         : okdori
 * date           : 4/1/24
 * description    :
 */
class Solution {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        var (list1, list2) = l1 to l2
        val head = ListNode(-1)
        var cursor = head
        var carry = 0

        while (list1 != null || list2 != null || carry > 0) {
            val x = list1?.`val` ?: 0
            val y = list2?.`val` ?: 0
            val sum = (x + y + carry) % 10
            carry = (x + y + carry) / 10
            cursor.next = ListNode(sum)
            cursor = cursor.next!!
            if (list1 != null) list1 = list1.next
            if (list2 != null) list2 = list2.next
        }

        return head.next
    }
}
