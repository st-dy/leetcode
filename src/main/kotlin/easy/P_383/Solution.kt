package easy.P_383

/**
 * packageName    : easy.P_383
 * fileName       : Solution
 * author         : okdori
 * date           : 3/26/24
 * description    :
 */
class Solution {
    fun canConstruct(ransomNote: String, magazine: String): Boolean {
        val magazineMap = mutableMapOf<Char, Int>()
        for (c in magazine) {
            magazineMap.put(c, magazineMap.getOrPut(c) { 0 } + 1)
        }
        for (c in ransomNote) {
            if (magazineMap.put(c, magazineMap.getOrPut(c) { 0 } - 1)!! < 1) return false
        }
        return true
    }
}
