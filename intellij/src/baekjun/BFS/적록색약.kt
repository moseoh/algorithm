package src.baekjun.BFS

import java.io.ByteArrayInputStream

fun main(args: Array<String>) {
    val testInput = "5\n" +
            "RRRBB\n" +
            "GGBBB\n" +
            "BBBRR\n" +
            "BBRRR\n" +
            "RRRRR"
    System.setIn(ByteArrayInputStream(testInput.toByteArray()))

    val reader = System.`in`.bufferedReader()
    val n = reader.readLine().toInt()
    val arr = Array(n) { CharArray(n) }
    val arr2 = Array(n) { CharArray(n) }

    for (i in 0 until n) {
        arr[i] = reader.readLine().toCharArray()
        arr2[i] = arr[i].copyOf()
    }

    fun run(matrix: Array<CharArray>, weakness: Boolean, n: Int): Int {
        fun isSame(color1: Char, color2: Char): Boolean {
            if (weakness) {
                if (color1 == 'R' && color2 == 'G') return true
                if (color1 == 'G' && color2 == 'R') return true
            }

            return color1 == color2
        }

        val dx = intArrayOf(1, 0, -1, 0)
        val dy = intArrayOf(0, 1, 0, -1)
        fun block(x: Int, y: Int) {
            val color = matrix[x][y]
            matrix[x][y] = 'X'
            for (i in 0..3) {
                val nextX = x + dx[i]
                val nextY = y + dy[i]

                if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= n) continue
                if (isSame(color, matrix[nextX][nextY])) {
                    block(nextX, nextY)
                }
            }
        }

        var count = 0
        for (i in 0 until n) {
            for (j in 0 until n) {
                if (matrix[i][j] != 'X') {
                    count++
                    block(i, j)
                }
            }
        }
        return count
    }

    val sb = StringBuilder()
    sb.append(run(arr, false, n))
        .append("\n")
    sb.append(run(arr2, true, n))
    println(sb)

    reader.close()
}
