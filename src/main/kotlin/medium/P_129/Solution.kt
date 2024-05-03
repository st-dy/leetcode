package medium.P_129

import structure.TreeNode

/**
 * author       : okdori
 * date         : 5/3/24
 * description  :
 */

class Solution {
    fun sumNumbers(root: TreeNode?): Int {
        var result = 0

        fun sum(node: TreeNode?, sum: Int) {
            node?.let {
                val current = sum + it.`val`
                if (it.left == null && it.right == null) result += current
                it.left?.let { sum(it, current * 10) }
                it.right?.let { sum(it, current * 10) }
            }
        }

        sum(root, result)
        return result
    }
}
