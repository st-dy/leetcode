package hard.P_25

import structure.ListNode
import java.util.Stack

/**
 * packageName    : hard.P_25
 * fileName       : Solution
 * author         : okdori
 * date           : 4/9/24
 * description    :
 */
class Solution {
    fun reverseKGroup(head: ListNode?, k: Int): ListNode? {
        var node = head
        val valStack = Stack<Int>()
        val valList = mutableListOf<Int>()

        while (node != null) {
            if (valList.size == k) {
                valList.reversed().map { valStack.push(it) }
                valList.clear()
            }
            valList.add(node.`val`)
            node = node.next
        }

        if (valList.isNotEmpty()) {
            if (valList.size == k) valList.reversed().map { valStack.push(it) }
            else valList.map { valStack.push(it) }
        }
        return reverseNode(ListNode(valStack.pop()), valStack)
    }

    private fun reverseNode(node: ListNode, valStack: Stack<Int>): ListNode? {
        if (valStack.isEmpty()) return node
        return reverseNode(ListNode(valStack.pop()).apply { next = node }, valStack)
    }
}
