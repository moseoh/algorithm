package src.programmers.level2.혼자서하는틱택토

fun main() {
    val board1 = arrayOf("O.X", ".O.", "..X")
    check(Solution().solution(board1) == 1) { "오답" }

    val board2 = arrayOf("OOO", "...", "XXX")
    check(Solution().solution(board2) == 0) { "오답" }

    val board3 = arrayOf("...", ".X.", "...")
    check(Solution().solution(board3) == 0) { "오답" }

    val board4 = arrayOf("...", "...", "...")
    check(Solution().solution(board4) == 1) { "오답" }

    val board5 = arrayOf("OXO", ".OX", "OXX")
    check(Solution().solution(board5) == 0) { "오답" }

    val board6 = arrayOf("OOO", "OXX", "OXX")
    check(Solution().solution(board6) == 1) { "오답" }
}

class Solution {
    fun solution(board: Array<String>): Int = if (isValid(board)) 1 else 0

    private fun isValid(board: Array<String>): Boolean {
        fun getCount(board: Array<String>): Pair<Int, Int> {
            val countO = board.joinToString().count { it == 'O' }
            val countX = board.joinToString().count { it == 'X' }
            return Pair(countO, countX)
        }

        fun isWinner(board: Array<String>, char: Char): Boolean {
            for (i in 0..2) {
                if (board[i][0] == char && board[i][1] == char && board[i][2] == char) return true
                if (board[0][i] == char && board[1][i] == char && board[2][i] == char) return true
            }
            if (board[0][0] == char && board[1][1] == char && board[2][2] == char) return true
            if (board[0][2] == char && board[1][1] == char && board[2][0] == char) return true
            return false
        }

        val count = getCount(board)
        if (count.first < count.second) return false
        if (count.first > count.second + 1) return false

        val winO = isWinner(board, 'O')
        val winX = isWinner(board, 'X')
        if (winO && winX) return false

        if (winO && count.first != count.second + 1) return false
        if (winX && count.first != count.second) return false

        return true
    }
}
