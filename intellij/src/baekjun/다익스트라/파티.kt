package src.baekjun.다익스트라

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.max


private const val NULL = Int.MIN_VALUE
private const val IS_NOT_VISITED = Int.MAX_VALUE

fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    val st = StringTokenizer(readLine())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()
    val x = st.nextToken().toInt()

    val (graph, graphReversed) = initGraph(n, m, this)
    val minDistance = dijkstra(graph, n, x)
    val minDistanceReversed = dijkstra(graphReversed, n, x)

    println(getMax(minDistance, minDistanceReversed, n))
}

fun initGraph(n: Int, m: Int, br: BufferedReader): Pair<Array<IntArray>, Array<IntArray>> {
    val graph = Array(n + 1) { IntArray(n + 1) { NULL } }
    val graphReversed = Array(n + 1) { IntArray(n + 1) { NULL } }
    repeat(m) {
        val st = StringTokenizer(br.readLine())
        val from = st.nextToken().toInt()
        val to = st.nextToken().toInt()
        val distance = st.nextToken().toInt()
        graph[from][to] = distance
        graphReversed[to][from] = distance
    }
    return Pair(graph, graphReversed)
}

fun dijkstra(graph: Array<IntArray>, n: Int, x: Int): IntArray {
    val minDistance = IntArray(n + 1) { IS_NOT_VISITED }
    val queue = PriorityQueue<Node>()
    queue.offer(Node(x, 0))
    minDistance[x] = 0

    while (queue.isNotEmpty()) {
        val node = queue.poll()

        if (minDistance[node.index] < node.distance) continue

        for (j in 1..n) {
            if (graph[node.index][j] == NULL) continue

            val cost = minDistance[node.index] + graph[node.index][j]

            if (cost < minDistance[j]) {
                minDistance[j] = cost
                queue.offer(Node(j, cost))
            }

        }
    }

    return minDistance
}

fun getMax(minDistance: IntArray, minDistanceReversed: IntArray, n: Int): Int {
    var max = Int.MIN_VALUE
    for (i in 1..n) {
        max = max(max, minDistance[i] + minDistanceReversed[i])
    }
    return max
}

data class Node(
    val index: Int,
    val distance: Int
) : Comparable<Node> {
    override fun compareTo(other: Node): Int {
        return this.distance - other.distance
    }
}

//fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
//    val st = StringTokenizer(readLine())
//    val n = st.nextToken().toInt()
//    val m = st.nextToken().toInt()
//    val x = st.nextToken().toInt()
//
//    val graph = initGraph(n, m, this)
//    val minDistance = dijkstra(graph, n, x)
//
//    println(getMax(minDistance, n, x))
//}
//
//fun initGraph(n: Int, m: Int, br: BufferedReader): Array<IntArray> {
//    val graph = Array(n + 1) { IntArray(n + 1) { NULL } }
//    repeat(m) {
//        val st = StringTokenizer(br.readLine())
//        val from = st.nextToken().toInt()
//        val to = st.nextToken().toInt()
//        val distance = st.nextToken().toInt()
//        graph[from][to] = distance
//    }
//    return graph
//}
//
//fun dijkstra(graph: Array<IntArray>, n: Int, x: Int): Array<IntArray> {
//    val minDistance = Array(n + 1) { IntArray(n + 1) { IS_NOT_VISITED } }
//
//    for (i in 1..n) {
//        val queue = PriorityQueue<Node>()
//        queue.offer(Node(i, 0))
//        minDistance[i][i] = 0
//
//        while (queue.isNotEmpty()) {
//            val node = queue.poll()
//
//            if (minDistance[i][node.index] < node.distance) continue
//
//            for (j in 1..n) {
//                if (graph[node.index][j] == NULL) continue
//
//                val cost = minDistance[i][node.index] + graph[node.index][j]
//
//                if (cost < minDistance[i][j]) {
//                    minDistance[i][j] = cost
//                    queue.offer(Node(j, cost))
//                }
//            }
//
//        }
//    }
//
//    return minDistance
//}

//fun getMax(minDistance: Array<IntArray>, n: Int, x: Int): Int {
//    var max = Int.MIN_VALUE
//    for (i in 1..n) {
//        max = max(max, minDistance[i][x] + minDistance[x][i])
//    }
//    return max
//}

