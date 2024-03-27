package hard.P_68

/**
 * packageName    : hard.P_68
 * fileName       : Solution
 * author         : okdori
 * date           : 3/27/24
 * description    :
 */
class Solution {
    fun fullJustify(words: Array<String>, maxWidth: Int): List<String> {
        val result: MutableList<String> = mutableListOf()
//        var line = words[0]
        val line = StringBuilder(words[0])

        fun addPadding() {
            result.add(line.toString().padEnd(maxWidth, ' '))
        }

        fun addLine() {
            if (line.contains(" ")) {
                var idx = 0
                val charList = line.toMutableList()
                val idxList = charList.withIndex().filter { c -> c.value == ' ' }.map { c -> c.index }.toList()
                end@ while (charList.size < maxWidth) {
                    for ((index, i) in idxList.withIndex()) {
                        if (charList.size == maxWidth) break@end
                        charList.add(i + idx + index, ' ')
                    }
                    idx++
                }
                result.add(charList.joinToString(""))
            } else {
                addPadding()
            }
        }

        for (i in 1..<words.size) {
            if (line.length + words[i].length <= maxWidth - 1) {
//                line += " " + words[i]
                line.append(" ")
                line.append(words[i])
            } else {
                addLine()
//                line = words[i]
                line.clear()
                line.append(words[i])
            }
        }
        addPadding()

        return result
    }
}
