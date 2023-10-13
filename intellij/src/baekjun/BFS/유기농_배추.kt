package src.baekjun.BFS

import java.io.ByteArrayInputStream
import java.util.*

fun main(args: Array<String>) {
    val testInput = "2\n" +
            "10 8 17\n" +
            "0 0\n" +
            "1 0\n" +
            "1 1\n" +
            "4 2\n" +
            "4 3\n" +
            "4 5\n" +
            "2 4\n" +
            "3 4\n" +
            "7 4\n" +
            "8 4\n" +
            "9 4\n" +
            "7 5\n" +
            "8 5\n" +
            "9 5\n" +
            "7 6\n" +
            "8 6\n" +
            "9 6\n" +
            "10 10 1\n" +
            "5 5"
    System.setIn(ByteArrayInputStream(testInput.toByteArray()))

    val reader = System.`in`.bufferedReader()
    val t = reader.readLine().toInt()
    val sb = StringBuilder()

    fun solution() {
        var st = StringTokenizer(reader.readLine())
        val m = st.nextToken().toInt()
        val n = st.nextToken().toInt()
        val k = st.nextToken().toInt()
        val matrix = Array(n) { IntArray(m) }

        repeat(k) {
            st = StringTokenizer(reader.readLine())
            val y = st.nextToken().toInt()
            val x = st.nextToken().toInt()
            matrix[x][y] = 1
        }

        val dx = intArrayOf(0, 1, 0, -1)
        val dy = intArrayOf(1, 0, -1, 0)

        fun removeBlock(x: Int, y: Int) {
            matrix[x][y] = 0
            for (i in 0..3) {
                val nextX = x + dx[i]
                val nextY = y + dy[i]

                if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= m) continue
                if (matrix[nextX][nextY] == 1) {
                    removeBlock(nextX, nextY)
                }
            }
        }

        var count = 0
        for (i in 0 until n) {
            for (j in 0 until m) {
                if (matrix[i][j] == 1) {
                    removeBlock(i, j)
                    count++
                }
            }
        }

        sb.append(count).append("\n")
    }

    repeat(t) {
        solution()
    }

    println(sb)
    reader.close()
}

