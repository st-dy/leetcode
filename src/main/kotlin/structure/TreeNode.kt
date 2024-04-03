package structure

import java.util.*
import kotlin.math.pow

/**
 * packageName    : structure
 * fileName       : TreeNode
 * author         : okdori
 * date           : 4/3/24
 * description    :
 */

class TreeNode(x: Int) : Cloneable {
    var `val`: Int = x
    var left: TreeNode? = null
    var right: TreeNode? = null

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as TreeNode

        if (`val` != other.`val`) return false
        if (left != other.left) return false
        if (right != other.right) return false

        return true
    }

    override fun hashCode(): Int {
        var result = `val`
        result = 31 * result + (left?.hashCode() ?: 0)
        result = 31 * result + (right?.hashCode() ?: 0)
        return result
    }

    override fun toString(): String {
        return "TreeNode(`val`=$`val`, left=$left, right=$right)"
    }

    public override fun clone(): TreeNode {
        try {
            return super.clone() as TreeNode
        } catch (e: CloneNotSupportedException) {
            throw AssertionError()
        }
    }

    internal object BTreePrinter {
        fun printNode(root: TreeNode?) {
            val maxLevel = maxLevel(root)
            printNodeInternal(listOf(root), 1, maxLevel)
        }

        private fun printNodeInternal(nodes: List<TreeNode?>, level: Int, maxLevel: Int) {
            if (nodes.isEmpty() || isAllElementsNull(nodes)) {
                return
            }
            val floor = maxLevel - level
            val edgeLines = 2.0.pow(maxOf(floor - 1, 0).toDouble()).toInt()
            val firstSpaces = 2.0.pow(floor.toDouble()).toInt() - 1
            val betweenSpaces = 2.0.pow((floor + 1).toDouble()).toInt() - 1
            printWhitespaces(firstSpaces)
            val newNodes: MutableList<TreeNode?> = ArrayList()
            for (node in nodes) {
                if (node != null) {
                    print(node.`val`)
                    newNodes.add(node.left)
                    newNodes.add(node.right)
                } else {
                    newNodes.add(null)
                    newNodes.add(null)
                    print(" ")
                }
                printWhitespaces(betweenSpaces)
            }
            println()

            // Full Graph
//            for (i in 1..edgeLines) {
            // Simplify Graph
            for (i in edgeLines..edgeLines) {
                for (node in nodes) {
                    printWhitespaces(firstSpaces - i)
                    if (node == null) {
                        printWhitespaces(edgeLines + edgeLines + i + 1)
                        continue
                    }
                    if (node.left != null) {
                        print("/")
                    } else {
                        printWhitespaces(1)
                    }
                    printWhitespaces(i + i - 1)
                    if (node.right != null) {
                        print("\\")
                    } else {
                        printWhitespaces(1)
                    }
                    printWhitespaces(edgeLines + edgeLines - i)
                }
                println()
            }
            printNodeInternal(newNodes, level + 1, maxLevel)
        }

        private fun printWhitespaces(count: Int) {
            if (count > 0) print("%${count}s".format(" "))
        }

        private fun maxLevel(node: TreeNode?): Int {
            if (node == null) return 0
            return 1+ maxOf(maxLevel(node.left), maxLevel(node.right))
        }

        private fun <T> isAllElementsNull(list: List<T?>): Boolean {
            for (`object` in list) {
                if (`object` != null) {
                    return false
                }
            }
            return true
        }
    }

    companion object {
        fun of(vararg array: Int?): TreeNode? {
            require(array.isNotEmpty())

            val treeNodeQueue: Queue<TreeNode> = LinkedList()
            val integerQueue: Queue<Int> = LinkedList()
            for (i in 1 until array.size) {
                integerQueue.offer(array[i])
            }

            val treeNode = array[0]?.let { TreeNode(it) }
            treeNodeQueue.offer(treeNode)

            while (!integerQueue.isEmpty()) {
                val leftVal = integerQueue.poll()
                val rightVal = if (integerQueue.isEmpty()) null else integerQueue.poll()
                val current = treeNodeQueue.poll()
                if (leftVal != null) {
                    val left = TreeNode(leftVal)
                    assert(current != null)
                    current!!.left = left
                    treeNodeQueue.offer(left)
                }
                if (rightVal != null) {
                    val right = TreeNode(rightVal)
                    assert(current != null)
                    current!!.right = right
                    treeNodeQueue.offer(right)
                }
            }
            return treeNode
        }

        fun print(treeNode: TreeNode?) {
            BTreePrinter.printNode(treeNode)
        }
    }
}
