package src.baekjun.다익스트라

import java.util.*

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    data class Node(val index: Int, val count: Int = 0, val prev: Node? = null)

    fun isOutOfIndex(n: Int) = n < 0 || n > 100_000

    val st = StringTokenizer(readLine())
    val n = st.nextToken().toInt()
    val k = st.nextToken().toInt()

//    val visited = mutableSetOf<Int>()
    val isVisited = BooleanArray(100_001)
    var node: Node? = null
    val queue: Queue<Node> = LinkedList()
    queue.offer(Node(n))

    while (queue.isNotEmpty()) {
        node = queue.poll()
        if (node.index == k) break

        val nextIndexes = intArrayOf(node.index + 1, node.index - 1, node.index * 2)
        for (nextIndex in nextIndexes) {
            if (!isOutOfIndex(nextIndex) && !isVisited[nextIndex]) {
                queue.offer(Node(nextIndex, node.count + 1, node))
                isVisited[nextIndex] = true
            }
//            if (!isOutOfIndex(nextIndex) && !visited.contains(nextIndex)) {
//                queue.offer(Node(nextIndex, node.count + 1, node))
//                visited.add(nextIndex)
//            }
        }
    }

    val sb = StringBuilder()
    sb.append(node!!.count).append("\n")
    val list = mutableListOf<Int>()
    while (node != null) {
        list.add(node.index)
        node = node.prev
    }
    list.reverse()
    list.forEach { sb.append(it).append(" ") }

    println(sb)
}