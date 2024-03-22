package hard.P_224

import java.util.*

/**
 * packageName    : hard.P_224
 * fileName       : Solution
 * author         : okdori
 * date           : 3/22/24
 * description    :
 */
class Solution {
    fun calculate(s: String): Int {
        val stack = Stack<Int>()
        var result = 0
        var sign = 1
        var num = 0

        fun operation() {
            result += sign * num
            num = 0
        }

        for (i in s.indices) {
            when (s[i]) {
                '+' -> {
                    operation()
                    sign = 1
                }
                '-' -> {
                    operation()
                    sign = -1
                }
                '(' -> {
                    stack.push(result)
                    stack.push(sign)
                    result = 0
                    sign = 1
                }
                ')' -> {
                    operation()
                    result = stack.pop() * result + stack.pop()
                }

                else -> {
                    if (s[i].isDigit()) {
                        num = num * 10 + (s[i] - '0')
                    }
                }
            }
        }

        operation()
        return result
    }
}

