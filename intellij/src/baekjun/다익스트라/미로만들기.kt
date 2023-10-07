package src.baekjun.다익스트라

import java.util.*


private data class Index(val x: Int, val y: Int) {
    fun move(index: Index): Index = Index(this.x + index.x, this.y + index.y)
}

private data class Node(val index: Index, val count: Int) : Comparable<Node> {
    override fun compareTo(other: Node): Int = this.count - other.count
}

private val DIRECTION = arrayOf(
    Index(-1, 0),
    Index(0, -1),
    Index(1, 0),
    Index(0, 1),
)

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    fun isOutOfIndex(index: Index, matrix: Array<BooleanArray>, n: Int): Boolean {
        return index.x < 0 || index.y < 0 || index.x >= n || index.y >= n
    }

    val n = readLine().toInt()
    val matrix = Array(n) { BooleanArray(n) }
    val isVisited = Array(n) { BooleanArray(n) }
    for (x in 0 until n) {
        val arr = readLine().toCharArray()
        for (y in 0 until n) {
            matrix[x][y] = arr[y] == '1'
        }
    }

    val queue = PriorityQueue<Node>()
    queue.add(Node(Index(0, 0), 0))
    lateinit var node: Node

    while (queue.isNotEmpty()) {
        node = queue.poll()
        isVisited[node.index.x][node.index.y] = true
        if (node.index.x == n - 1 && node.index.y == n - 1) break

        for (direction in DIRECTION) {
            val nextIndex = node.index.move(direction)
            if (!isOutOfIndex(nextIndex, matrix, n) && !isVisited[nextIndex.x][nextIndex.y]) {
                queue.add(
                    Node(
                        nextIndex,
                        if (matrix[nextIndex.x][nextIndex.y]) node.count else node.count + 1
                    )
                )
            }
        }
    }

    println(node.count)
}