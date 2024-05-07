package medium.P_71

import java.util.Stack

/**
 * author       : okdori
 * date         : 5/7/24
 * description  :
 */

class Solution {
//    fun simplifyPath(path: String) = with(Stack<String>()) {
//        for (p in path.split("/")) when (p) {
//            "", "." -> continue
//            ".." -> if (size > 0) pop()
//            else -> push(p)
//        }
//        "/" + joinToString("/")
//    }

    fun simplifyPath(path: String): String {
        val stack = mutableListOf<String>()
        path.split("/").forEach { part ->
            when (part) {
                "", "." -> Unit
                ".." -> if (stack.isNotEmpty()) stack.removeLast()
                else -> stack.add(part)
            }
        }
        return "/${stack.joinToString("/")}"
    }
}
