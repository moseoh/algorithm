package src.programmers.level3.합승_택시_요금

import java.util.*

fun main() {
    fun printResult(index: Int, result: Int, answer: Int) {
        val correct = result == answer
        val sb = StringBuilder()
        sb.append("\n\n테스트 케이스 ").append(index).append(": ")
        sb.append(if (correct) "정답" else "오답").append("\n")
        sb.append("\t- 실행 결과: \t").append(result).append("\n")
        sb.append("\t- 기댓값: \t").append(answer).append("\n")
        if (correct) println(sb) else throw RuntimeException(sb.toString())
    }

    val n1 = 6
    val s1 = 4
    val a1 = 6
    val b1 = 2
    val fares1 = arrayOf(
        intArrayOf(4, 1, 10),
        intArrayOf(3, 5, 24),
        intArrayOf(5, 6, 2),
        intArrayOf(3, 1, 41),
        intArrayOf(5, 1, 24),
        intArrayOf(4, 6, 50),
        intArrayOf(2, 4, 66),
        intArrayOf(2, 3, 22),
        intArrayOf(1, 6, 25)
    )
    val answer1 = 82
    val result1 = Solution().solution(n1, s1, a1, b1, fares1)
    printResult(1, result1, answer1)

    val n2 = 7
    val s2 = 3
    val a2 = 4
    val b2 = 1
    val fares2 = arrayOf(
        intArrayOf(5, 7, 9),
        intArrayOf(4, 6, 4),
        intArrayOf(3, 6, 1),
        intArrayOf(3, 2, 3),
        intArrayOf(2, 1, 6)
    )
    val answer2 = 14
    val result2 = Solution().solution(n2, s2, a2, b2, fares2)
    printResult(2, result2, answer2)

    val n3 = 6
    val s3 = 4
    val a3 = 5
    val b3 = 6
    val fares3 = arrayOf(
        intArrayOf(2, 6, 6),
        intArrayOf(6, 3, 7),
        intArrayOf(4, 6, 7),
        intArrayOf(6, 5, 11),
        intArrayOf(2, 5, 12),
        intArrayOf(5, 3, 20),
        intArrayOf(2, 4, 8),
        intArrayOf(4, 3, 9)
    )
    val answer3 = 18
    val result3 = Solution().solution(n3, s3, a3, b3, fares3)
    printResult(3, result3, answer3)
}

class Solution {
    fun solution2(n: Int, s: Int, a: Int, b: Int, fares: Array<IntArray>): Int {
        val graph = MutableList(n) { MutableList(n) { Int.MAX_VALUE / 4 } }

        for (i in 0 until n) {
            graph[i][i] = 0
        }
        fares.forEach {
            val x = it[0] - 1
            val y = it[1] - 1
            graph[x][y] = it[2]
            graph[y][x] = it[2]
        }

        for (k in 0 until n) {
            for (i in 0 until n) {
                if (i == k) {
                    continue
                }

                for (j in i + 1 until n) {
                    val sum = graph[i][k] + graph[k][j]
                    if (graph[i][j] >= sum) {
                        graph[i][j] = sum
                        graph[j][i] = sum
                    }
                }
            }
        }

        var answer = graph[s - 1][0] + graph[0][a - 1] + graph[0][b - 1]
        for (i in 1 until n) {
            answer = minOf(answer, graph[s - 1][i] + graph[i][a - 1] + graph[i][b - 1])
        }
        return answer
    }

    fun solution(n: Int, s: Int, a: Int, b: Int, fares: Array<IntArray>): Int {
        val nodeMap = getNodeMap(fares)

        val sLength = getMinCostArray(n, s, nodeMap)
        val aLength = getMinCostArray(n, a, nodeMap)
        val bLength = getMinCostArray(n, b, nodeMap)

        var answer = Integer.MAX_VALUE
        for (i in 1..n) {
            answer = minOf(bLength[i] + aLength[i] + sLength[i], answer)
        }
        return answer
    }

    private fun getMinCostArray(n: Int, start: Int, nodeMap: Map<Int, List<Node>>): IntArray {
        val costs = IntArray(n + 1) { Integer.MAX_VALUE }
        val pq = PriorityQueue<Node>()
        pq.add(Node(start, 0))
        costs[start] = 0

        while (!pq.isEmpty()) {
            val current = pq.poll()

            if (current.cost > costs[current.index]) continue

            for (node in nodeMap[current.index]!!) {
                val cost = costs[current.index] + node.cost
                if (cost < costs[node.index]) {
                    costs[node.index] = cost
                    pq.add(Node(node.index, cost))
                }
            }
        }

        return costs
    }

    private fun getNodeMap(fares: Array<IntArray>): MutableMap<Int, MutableList<Node>> {
        val nodeMap: MutableMap<Int, MutableList<Node>> = hashMapOf()

        for (fare in fares) {
            val node1 = Node(fare[0], fare[2])
            val list1 = nodeMap.getOrDefault(fare[1], mutableListOf())
            list1.add(node1)
            nodeMap[fare[1]] = list1

            val node2 = Node(fare[1], fare[2])
            val list2 = nodeMap.getOrDefault(fare[0], mutableListOf())
            list2.add(node2)
            nodeMap[fare[0]] = list2
        }

        return nodeMap
    }

    class Node(
        val index: Int,
        val cost: Int,
    ) : Comparable<Node> {
        override fun compareTo(other: Node): Int {
            return this.cost - other.cost
        }

        override fun toString(): String {
            return "Node(index=$index, cost=$cost)"
        }

    }
}