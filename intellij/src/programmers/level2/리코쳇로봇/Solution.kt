package src.programmers.level2.리코쳇로봇

import java.util.*

fun main(args: Array<String>) {
//    val board = arrayOf("...D..R", ".D.G...", "....D.D", "D....D.", "..D....")
//    val board = arrayOf(".D.R", "....", ".G..", "...D")
    val board = arrayOf("....R", ".....", "....D", ".....", "G....")
    println(Solution().solution(board))
}

class Solution {
    private val dx = intArrayOf(0, 1, 0, -1)
    private val dy = intArrayOf(1, 0, -1, 0)

    fun solution(board: Array<String>): Int {
        val que = LinkedList<Triple<Int, Int, Int>>()
        que.add(getStartIndex(board))
        val isVisited = Array(board.size) { BooleanArray(board[0].length) }
        while (que.isNotEmpty()) {
            val index = que.poll()
            val y = index.first
            val x = index.second
            val count = index.third

            if (board[y][x] == 'G') return count
            for (i in 0..3) {
                val nextIndex = getNextIndex(x, y, dx[i], dy[i], board)
                val ny = nextIndex.first
                val nx = nextIndex.second

                if (ny == y && nextIndex.second == x) continue
                if (isVisited[ny][nx]) continue
                que.add(Triple(ny, nx, index.third + 1))
                isVisited[ny][nx] = true
            }
        }
        return -1
    }

    private fun getNextIndex(
        x: Int,
        y: Int,
        dx: Int,
        dy: Int,
        board: Array<String>,
    ): Pair<Int, Int> {
        var currentX = x
        var currentY = y
        while (true) {
            if (currentX + dx >= board[0].length || currentX + dx < 0) return Pair(currentY, currentX)
            if (currentY + dy >= board.size || currentY + dy < 0) return Pair(currentY, currentX)
            if (board[currentY + dy][currentX + dx] == 'D') return Pair(currentY, currentX)
            currentX += dx
            currentY += dy
        }
    }

    private fun getStartIndex(board: Array<String>): Triple<Int, Int, Int> {
        for (i in board.indices) {
            board[i].forEachIndexed { index, c ->
                if (c == 'R') return Triple(i, index, 0)
            }
        }

        return Triple(-1, -1, -1)
    }
}