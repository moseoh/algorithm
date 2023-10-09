package src.baekjun.BFS

import java.io.ByteArrayInputStream
import java.util.*

fun main(args: Array<String>) {
//    val testInput = "5 9"
    val testInput = "100 0"

    System.setIn(ByteArrayInputStream(testInput.toByteArray()))

    data class Point(val index: Int, val count: Int)

    val reader = System.`in`.bufferedReader()
    val st = StringTokenizer(reader.readLine())
    val n = st.nextToken().toInt()
    val k = st.nextToken().toInt()

    if (n >= k) {
        println(n - k)
        return
    }

    val isVisited = BooleanArray(100_001)
    val queue: Queue<Point> = LinkedList()

    var point = Point(n, 0)
    queue.add(point)

    while (queue.isNotEmpty()) {
        point = queue.poll()
        isVisited[point.index] = true

        if (point.index == k) break

        for (i in 0 until 3) {
            val nextIndex = when (i) {
                0 -> point.index - 1
                1 -> point.index + 1
                2 -> point.index * 2
                else -> throw RuntimeException()
            }

            if (nextIndex in 0..100_000 && !isVisited[nextIndex]) {
                queue.offer(Point(nextIndex, point.count + 1))
            }
        }
    }

    println(point.count)
    reader.close()
}