package easy.P_20

import java.util.Stack

/**
 * packageName    : easy.P_20
 * fileName       : Solution
 * author         : okdori
 * date           : 4/8/24
 * description    :
 */
class Solution {
    fun isValid(s: String): Boolean {
        if (s.length % 2 != 0) return false
        val brackets = mapOf('(' to ')', '{' to '}', '[' to ']')
        val leftBrackets = listOf('(', '{', '[')
        val stack = Stack<Char>()

        for (c in s) {
            when {
                c in leftBrackets -> stack.push(c)
                stack.empty() -> return false
                c != brackets.getValue(stack.pop()) -> return false
            }
        }

        return stack.empty()
    }
}
