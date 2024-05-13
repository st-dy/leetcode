package medium.P_17

/**
 * author       : okdori
 * date         : 5/10/24
 * description  :
 */

class Solution {
    fun letterCombinations(digits: String): List<String> {
        if (digits.isEmpty()) return listOf()

        val button = mapOf(
            '2' to listOf("a", "b", "c"),
            '3' to listOf("d", "e", "f"),
            '4' to listOf("g", "h", "i"),
            '5' to listOf("j", "k", "l"),
            '6' to listOf("m", "n", "o"),
            '7' to listOf("p", "q", "r", "s"),
            '8' to listOf("t", "u", "v"),
            '9' to listOf("w", "x", "y", "z"),
        )
        val result = mutableListOf<String>()

        fun dfs(idx: Int, cur: String) {
            if (idx == digits.length) {
                result.add(cur)
                return
            }
            for (i in button[digits[idx]]!!) {
                dfs(idx + 1, cur + i)
            }
        }

        dfs(0, "")
        return result
    }
}

