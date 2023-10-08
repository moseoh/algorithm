package src.baekjun.BFS

import java.util.*
import kotlin.math.max

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    var st = StringTokenizer(readLine())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()

    val dx = intArrayOf(1, 0, -1, 0)
    val dy = intArrayOf(0, 1, 0, -1)

    val matrix = Array(n) { IntArray(m) }
    for (i in 0 until n) {
        st = StringTokenizer(readLine())
        for (j in 0 until m) {
            matrix[i][j] = st.nextToken().toInt()
        }
    }

    var count = 0
    var maxSize = 0
    var size = 0

    fun search(x: Int, y: Int) {
        matrix[x][y] = 0
        size++

        for (i in 0 until 4) {
            val nextX = x + dx[i]
            val nextY = y + dy[i]

            if (nextX < 0 || nextX >= n) continue
            if (nextY < 0 || nextY >= m) continue
            if (matrix[nextX][nextY] == 0) continue

            search(nextX, nextY)
        }

        maxSize = max(maxSize, size)
    }

    for (i in 0 until n) {
        for (j in 0 until m) {
            if (matrix[i][j] == 1) {
                size = 0
                count++
                search(i, j)
            }
        }
    }

    println("$count\n$maxSize")
}