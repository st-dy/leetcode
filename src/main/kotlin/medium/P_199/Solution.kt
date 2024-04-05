package medium.P_199

import structure.TreeNode
import java.util.*


/**
 * packageName    : medium.P_199
 * fileName       : Solution
 * author         : okdori
 * date           : 4/5/24
 * description    :
 */
class Solution {
    fun rightSideView(root: TreeNode?): List<Int> {
        val queue: Queue<TreeNode> = LinkedList()
        val result: MutableList<Int> = ArrayList()
        queue.offer(root)

        while (!queue.isEmpty()) {
            val size = queue.size
            var node: TreeNode? = null

            for (i in 0 until size) {
                node = queue.poll()
                if (node == null) break
                node.left?.let { queue.offer(it) }
                node.right?.let { queue.offer(it) }
            }

            node?.let { result.add(node.`val`) }
        }

        return result
    }
}
