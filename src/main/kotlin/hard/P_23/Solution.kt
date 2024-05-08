package hard.P_23

import structure.ListNode

/**
 * author       : okdori
 * date         : 5/8/24
 * description  :
 */

class Solution {
    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        if (lists.isEmpty()) return null
        val intList = mutableListOf<Int>()
        for (list in lists) {
            var tmp = list
            while (tmp != null) {
                intList.add(tmp.`val`)
                tmp = tmp.next
            }
        }

        if (intList.isEmpty()) return null
        intList.sort()

        val result = ListNode(intList[0])
        intList.removeAt(0)
        var tmpNode = result
        for (i in intList) {
            tmpNode.next = ListNode(i)
            tmpNode = tmpNode.next!!
        }
        return result
    }
}
