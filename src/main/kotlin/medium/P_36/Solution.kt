package medium.P_36

/**
 * packageName    : medium.P_36
 * fileName       : Solution
 * author         : okdori
 * date           : 3/25/24
 * description    :
 */
class Solution {
    fun isValidSudoku(board: Array<CharArray>): Boolean {
        var rowList = mutableListOf<Int>()
        var columnList = mutableListOf<Int>()
        var box1List = mutableListOf<Int>()
        var box2List = mutableListOf<Int>()
        var box3List = mutableListOf<Int>()

        val checkList = mutableListOf<MutableList<Int>>()
        fun validCheckList(): Boolean {
            for (list in checkList) {
                list.removeAll(listOf(-1))
                if (list.size != list.distinct().size) return false
            }
            return true
        }

        for (i in 0..8) {
            for (j in 0..8) {
                // row test
                rowList.add(Character.getNumericValue(board[i][j]))
                // column test
                columnList.add(Character.getNumericValue(board[j][i]))
            }
            checkList.add(rowList)
            checkList.add(columnList)
            rowList = mutableListOf()
            columnList = mutableListOf()
        }

        // box test
        for (i in listOf(0, 3, 6)) {
            for (j in 0..2) {
                box1List.add(Character.getNumericValue(board[i][j]))
                box1List.add(Character.getNumericValue(board[i+1][j]))
                box1List.add(Character.getNumericValue(board[i+2][j]))
                box2List.add(Character.getNumericValue(board[i][j+3]))
                box2List.add(Character.getNumericValue(board[i+1][j+3]))
                box2List.add(Character.getNumericValue(board[i+2][j+3]))
                box3List.add(Character.getNumericValue(board[i][j+6]))
                box3List.add(Character.getNumericValue(board[i+1][j+6]))
                box3List.add(Character.getNumericValue(board[i+2][j+6]))
            }
            checkList.add(box1List)
            checkList.add(box2List)
            checkList.add(box3List)
            box1List = mutableListOf()
            box2List = mutableListOf()
            box3List = mutableListOf()
        }

        return validCheckList()
    }
}
