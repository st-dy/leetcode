package easy.P_104

import structure.TreeNode

/**
 * packageName    : easy.P_104
 * fileName       : Solution
 * author         : okdori
 * date           : 4/3/24
 * description    :
 */
class Solution {
    fun maxDepth(root: TreeNode?): Int {
        if (root == null) return 0
        return 1 + maxOf(maxDepth(root.left), maxDepth(root.right))
    }
}
