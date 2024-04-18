package easy.P_108

import structure.TreeNode

/**
 * author       : okdori
 * date         : 4/18/24
 * description  :
 */

class Solution {
    fun sortedArrayToBST(num: IntArray): TreeNode? {
        return makeTree(num, 0, num.size - 1)
    }

    private fun makeTree(num: IntArray, left: Int, right: Int): TreeNode? {
        if (left > right) return null
        val mid = (left + right) / 2
        val midNode = TreeNode(num[mid])

        midNode.left = makeTree(num, left, mid - 1)
        midNode.right = makeTree(num, mid + 1, right)

        return midNode
    }
}
