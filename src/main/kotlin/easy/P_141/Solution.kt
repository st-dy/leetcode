package easy.P_141

/**
 * packageName    : easy.P_141
 * fileName       : Solution
 * author         : okdori
 * date           : 4/1/24
 * description    :
 */

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
    fun hasCycle(head: ListNode?): Boolean {
        var normal = head
        var faster = normal?.next

        while (normal != null) {
            if (normal == faster) return true
            normal = normal?.next
            faster = faster?.next?.next
        }
        return false
    }
}
