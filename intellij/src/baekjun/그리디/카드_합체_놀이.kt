package src.baekjun.그리디

import java.io.ByteArrayInputStream
import java.util.*

fun main(args: Array<String>) {
    val testInput = "4 2\n" +
            "4 2 3 1"
    System.setIn(ByteArrayInputStream(testInput.toByteArray()))

    val reader = System.`in`.bufferedReader()
    var st = StringTokenizer(reader.readLine())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()

    st = StringTokenizer(reader.readLine())
    val queue = PriorityQueue<Long>()

    repeat(n) {
        queue.add(st.nextToken().toLong())
    }

    repeat(m) {
        val added = queue.poll() + queue.poll()
        queue.add(added)
        queue.add(added)
    }

    println(queue.sum())

    reader.close()
}