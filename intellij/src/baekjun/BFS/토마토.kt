package src.baekjun.BFS

import java.io.ByteArrayInputStream
import java.util.*

fun main(args: Array<String>) {
    val testInput = "2 2\n" +
            "1 -1\n" +
            "-1 1"
    System.setIn(ByteArrayInputStream(testInput.toByteArray()))

    data class Index(val x: Int, val y: Int)

    val reader = System.`in`.bufferedReader()
    var st = StringTokenizer(reader.readLine())
    val m = st.nextToken().toInt()
    val n = st.nextToken().toInt()
    val matrix = Array(n) { IntArray(m) }

    var goals = 0
    val queue: Queue<Index> = LinkedList()
    for (i in 0 until n) {
        st = StringTokenizer(reader.readLine())
        for (j in 0 until m) {
            matrix[i][j] = st.nextToken().toInt()
            if (matrix[i][j] == 1) {
                queue.add(Index(i, j))
            } else if (matrix[i][j] == 0) {
                goals++
            }
        }
    }

    val dx = intArrayOf(1, 0, -1, 0)
    val dy = intArrayOf(0, 1, 0, -1)
    var days = 0
    val nextQueue: Queue<Index> = LinkedList()

    while (queue.isNotEmpty()) {
        val index = queue.poll()
        for (i in 0 until 4) {
            val nextX = index.x + dx[i]
            val nextY = index.y + dy[i]

            if (nextX < 0 || nextX >= n) continue
            if (nextY < 0 || nextY >= m) continue
            if (matrix[nextX][nextY] == 1 || matrix[nextX][nextY] == -1) continue

            matrix[nextX][nextY] = 1
            goals--
            nextQueue.add(Index(nextX, nextY))
        }

        if (queue.isEmpty()) {
            queue.addAll(nextQueue)
            if (nextQueue.isNotEmpty()) {
                days++
            }
            nextQueue.clear()
        }
    }

    if (goals != 0) {
        println(-1)
    } else {
        println(days)
    }

    reader.close()
}