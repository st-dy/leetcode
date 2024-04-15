package easy.P_67

/**
 * author       : okdori
 * date         : 4/15/24
 * description  :
 */

class Solution {
    fun addBinary(a: String, b: String): String {
        return (a.toBigInteger(2) + b.toBigInteger(2)).toString(2)
    }
}
