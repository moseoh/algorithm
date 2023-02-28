package src.programmers.archive.etc.test.test1

import java.util.*


fun main(args: Array<String>) {
//    val board = arrayOf(
//        intArrayOf(1, 2, 0, 0),
//        intArrayOf(1, 0, 2, 0),
//        intArrayOf(1, 0, 0, 0),
//        intArrayOf(1, 0, 0, 1),
//    )
//    val k = 2
//    val ax = 1
//    val ay = 1
//    val bx = 2
//    val by = 2
    val board = arrayOf(
        intArrayOf(0, 0, 1, 0, 0, 0),
        intArrayOf(0, 2, 0, 0, 0, 1),
        intArrayOf(0, 0, 2, 1, 0, 0),
        intArrayOf(0, 0, 0, 0, 0, 0),
        intArrayOf(0, 0, 0, 0, 1, 0),
        intArrayOf(0, 1, 0, 0, 0, 0),
    )
    val k = 2
    val ax = 1
    val ay = 2
    val bx = 0
    val by = 5
    println(Solution().solution(board, k, ax, ay, bx, by))
}

// 폭탄 1
// 벽 2
// 폭탄 범위 3
// A 현재 위치 20
// A 도착 위치 29
// B 현재 위치 30
// B 도착 위치 39
class Solution {
    companion object {
        const val BOMB = 1
        const val WALL = 2
        const val BOMB_RANGE = 3
        const val A = 20
        const val A_GOAL = 29
        const val B = 30
        const val B_GOAL = 39
        val DX = intArrayOf(1, 0, -1, 0)
        val DY = intArrayOf(0, 1, 0, -1)
    }

    fun solution(board: Array<IntArray>, k: Int, ax: Int, ay: Int, bx: Int, by: Int): Int {
        board.forEach { println(it.contentToString()) }
        println()

        // 폭탄위 터지는 범위를 3으로 표시
        board.forEachIndexed { indexY, arr ->
            arr.forEachIndexed { indexX, i ->
                if (i == 1) fillBombRange(board, k, indexX, indexY)
            }
        }

        board.forEach { println(it.contentToString()) }

        var firstABoard = board.copyOf()
        var firstBBoard = board.copyOf()

        // 안전한 공간 찾기
        val safeCount = board.sumOf { arr -> arr.count { it == 0 } }
        // 두캐릭터가 숨을 공간이 없다면 실패
        if (safeCount < 2) return -1
        return 1
    }

    // 너비 우선 탐색
    fun getMoveToSafeArea(board: Array<IntArray>, indexX: Int, indexY: Int): Int {
        val length = board.size
        val que: Queue<IntArray> = LinkedList()
        // x, y, distance
        var node = intArrayOf(indexX, indexY, 1)
        que.add(node)
        board[0][0] = 0
        while (!que.isEmpty()) {
            node = que.poll()
            if (node[0] == length - 1 && node[1] == length - 1) {
                return node[2]
            }
            for (i in 0..4) {
                val nextX = node[0] + DX[i]
                val nextY = node[1] + DY[i]
                if (!isMovable(board, length, length, nextX, nextY)) continue
                que.add(intArrayOf(nextX, nextY, node[2] + 1))
                board[nextX][nextY] = 0
            }
        }
        return -1
    }

    private fun isMovable(maps: Array<IntArray>, n: Int, m: Int, x: Int, y: Int): Boolean {
        if (n <= x || x < 0 || m <= y || y < 0) return false
        return maps[x][y] != 0
    }

    private fun fillBombRange(board: Array<IntArray>, k: Int, indexX: Int, indexY: Int) {
        fillBombXRange(board, k, indexX, indexY, 1)
        fillBombXRange(board, k, indexX, indexY, -1)
        fillBombYRange(board, k, indexX, indexY, 1)
        fillBombYRange(board, k, indexX, indexY, -1)
    }

    private tailrec fun fillBombXRange(
        board: Array<IntArray>,
        k: Int,
        indexX: Int,
        indexY: Int,
        move: Int,
        moved: Int = 0
    ) {
        if (moved == k) return

        val nextIndex = indexX + move
        if (nextIndex < 0) return
        if (board[indexY].size <= nextIndex) return
        if (board[indexY][nextIndex] == BOMB) return
        if (board[indexY][nextIndex] == WALL) return

        board[indexY][nextIndex] = BOMB_RANGE
        fillBombXRange(board, k, nextIndex, indexY, move, moved + 1)
    }

    private tailrec fun fillBombYRange(
        board: Array<IntArray>,
        k: Int,
        indexX: Int,
        indexY: Int,
        move: Int,
        moved: Int = 0
    ) {
        if (moved == k) return

        val nextIndex = indexY + move
        if (nextIndex < 0) return
        if (board.size <= nextIndex) return
        if (board[nextIndex][indexX] == BOMB) return
        if (board[nextIndex][indexX] == WALL) return

        board[nextIndex][indexX] = BOMB_RANGE
        fillBombYRange(board, k, indexX, nextIndex, move, moved + 1)
    }
}