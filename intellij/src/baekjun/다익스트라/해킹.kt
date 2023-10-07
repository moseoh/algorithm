package src.baekjun.다익스트라

import java.util.*
import kotlin.math.max

private const val NOT_VISITED = Int.MAX_VALUE

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    data class Node(val index: Int, val time: Int) : Comparable<Node> {
        override fun compareTo(other: Node): Int = this.time - other.time
    }

    val sb = StringBuilder()
    val repeat = readLine().toInt()
    repeat(repeat) {
        // n: 컴퓨터 개수, d: 의존성 개수, c: 해킹당한 켬퓨터 번호
        var st = StringTokenizer(readLine())
        val n = st.nextToken().toInt()
        val d = st.nextToken().toInt()
        val c = st.nextToken().toInt()

        val graph = Array(n + 1) { ArrayList<Node>() }
        val dijkstra = IntArray(n + 1) { NOT_VISITED }
        repeat(d) {
            // b 감염 후 s초 후 a 감염
            st = StringTokenizer(readLine())
            val a = st.nextToken().toInt()
            val b = st.nextToken().toInt()
            val s = st.nextToken().toInt()
            graph[b].add(Node(a, s))
        }

        val queue = PriorityQueue<Node>()
        queue.offer(Node(c, 0))
        dijkstra[c] = 0

        while (queue.isNotEmpty()) {
            val node = queue.poll()
            if (dijkstra[node.index] < node.time) continue

            for (next in graph[node.index]) {
                val cost = dijkstra[node.index] + next.time
                if (cost < dijkstra[next.index]) {
                    dijkstra[next.index] = cost
                    queue.offer(next)
                }
            }
        }

        var count = 0
        var max = 0
        for (i in 1..n) {
            if (dijkstra[i] != NOT_VISITED) {
                count++
                max = max(max, dijkstra[i])
            }
        }

        sb.append("$count $max").append("\n")
    }

    println(sb)
}