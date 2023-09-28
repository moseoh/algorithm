package src.programmers.level3.가장_먼_노드

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
    val edge1 = arrayOf(
        intArrayOf(3, 6),
        intArrayOf(4, 3),
        intArrayOf(3, 2),
        intArrayOf(1, 3),
        intArrayOf(1, 2),
        intArrayOf(2, 4),
        intArrayOf(5, 2),
    )
    val answer1 = 3
    val result1 = Solution().solution(n1, edge1)
    printResult(1, result1, answer1)
}

class Solution {
    fun solution(n: Int, edge: Array<IntArray>): Int {
        val graph = Array(n + 1) { mutableListOf<Int>() }
        for (e in edge) {
            graph[e[0]].add(e[1])
            graph[e[1]].add(e[0])
        }

        val isVisited = BooleanArray(n + 1)
        val depths = IntArray(n + 1)
        val queue: Queue<Int> = LinkedList()

        var max = 0
        queue.add(1)
        isVisited[1] = true
        while (queue.isNotEmpty()) {
            val index = queue.poll()
            graph[index].forEach {
                if (!isVisited[it]) {
                    isVisited[it] = true
                    queue.add(it)
                    depths[it] = depths[index] + 1
                    max = maxOf(max, depths[it])
                }
            }
        }

        return depths.count { it == max }
    }

}