package easy.P_100

import structure.TreeNode

/**
 * packageName    : easy.P_100
 * fileName       : Solution
 * author         : okdori
 * date           : 4/4/24
 * description    :
 */
class Solution {
    fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
        if (p == null && q == null) return true
        if (p?.`val` != q?.`val`) return false
        return isSameTree(p?.left, q?.left) && isSameTree(p?.right, q?.right)
    }
}
