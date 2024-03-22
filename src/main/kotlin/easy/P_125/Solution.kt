package easy.P_125

/**
 * packageName    : easy.P_125
 * fileName       : Solution
 * author         : okdori
 * date           : 3/22/24
 * description    :
 */
class Solution {
    fun isPalindrome(s: String): Boolean =
        s.filter { it.isLetterOrDigit() }.toLowerCase().let { it == it.reversed() }
}
