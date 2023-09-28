package src.programmers.level3.양과_늑대

import kotlin.math.max


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

    val info1 = intArrayOf(0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1)
    val edges1 = arrayOf(
        intArrayOf(0, 1),
        intArrayOf(1, 2),
        intArrayOf(1, 4),
        intArrayOf(0, 8),
        intArrayOf(8, 7),
        intArrayOf(9, 10),
        intArrayOf(9, 11),
        intArrayOf(4, 3),
        intArrayOf(6, 5),
        intArrayOf(4, 6),
        intArrayOf(8, 9)
    )
    val answer1 = 5
    val result1 = Solution().solution(info1, edges1)
    printResult(1, result1, answer1)

//    val info2 = intArrayOf(0, 1, 0, 1, 1, 0, 1, 0, 0, 1, 0)
//    val edges2 = arrayOf(
//        intArrayOf(0, 1),
//        intArrayOf(0, 2),
//        intArrayOf(1, 3),
//        intArrayOf(1, 4),
//        intArrayOf(2, 5),
//        intArrayOf(2, 6),
//        intArrayOf(3, 7),
//        intArrayOf(4, 8),
//        intArrayOf(6, 9),
//        intArrayOf(9, 10)
//    )
//    val answer2 = 5
//    val result2 = Solution().solution(info2, edges2)
//    printResult(2, result2, answer2)
}

class Solution {
    private lateinit var graph: Array<MutableList<Int>>
    private var maxSheepCnt = 0

    fun solution(info: IntArray, edges: Array<IntArray>): Int {
        graph = Array(info.size) { mutableListOf() }
        for (edge in edges) {
            graph[edge[0]].add(edge[1])
        }

        val list: MutableList<Int> = ArrayList()
        list.add(0)
        dfs(0, 0, 0, list, info)
        return maxSheepCnt
    }

    private fun dfs(index: Int, sheepCnt: Int, wolfCnt: Int, nextPos: List<Int>, info: IntArray) {
        println("index: $index, nextPost: $nextPos")

        var sheepCnt = sheepCnt
        var wolfCnt = wolfCnt
        if (info[index] == 0) sheepCnt++ else wolfCnt++
        if (wolfCnt >= sheepCnt) return
        maxSheepCnt = max(sheepCnt.toDouble(), maxSheepCnt.toDouble()).toInt()

        val list = mutableListOf<Int>()
        list.addAll(nextPos)
        list.remove(index)
        for (child in graph[index]) {
            list.add(child)
        }

        println(list)
        println()


        for (next in list) {
            dfs(next, sheepCnt, wolfCnt, list, info)
        }
    }
}