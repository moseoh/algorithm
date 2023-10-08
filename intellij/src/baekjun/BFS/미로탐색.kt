package src.baekjun.BFS

import java.io.ByteArrayInputStream
import java.util.*

fun main(args: Array<String>) {
    val testInput = "4 6\n" +
            "101111\n" +
            "101010\n" +
            "101011\n" +
            "111011"
    System.setIn(ByteArrayInputStream(testInput.toByteArray()))

    data class Index(val x: Int, val y: Int, val count: Int)

    val reader = System.`in`.bufferedReader()
    var st = StringTokenizer(reader.readLine())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()
    val matrix = Array(n) { IntArray(m) }

    for (i in 0 until n) {
        st = StringTokenizer(reader.readLine())
        val str = st.nextToken()
        for (j in 0 until m) {
            matrix[i][j] = str[j].digitToInt()
        }
    }

    var index = Index(0, 0, 1)
    val queue: Queue<Index> = LinkedList()
    queue.add(index)

    val dx = intArrayOf(1, 0, -1, 0)
    val dy = intArrayOf(0, 1, 0, -1)

    while (queue.isNotEmpty()) {
        index = queue.poll()
        if (index.x == n - 1 && index.y == m - 1) break

        for (i in 0 until 4) {
            val nextX = index.x + dx[i]
            val nextY = index.y + dy[i]

            if (nextX < 0 || nextX >= n) continue
            if (nextY < 0 || nextY >= m) continue
            if (matrix[nextX][nextY] == 0) continue

            matrix[nextX][nextY] = 0
            queue.add(Index(nextX, nextY, index.count + 1))
        }

    }

    println(index.count)
    reader.close()
}