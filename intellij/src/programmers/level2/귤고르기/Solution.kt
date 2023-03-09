package src.programmers.level2.귤고르기

import java.util.*

fun main(args: Array<String>) {
    val k = 6
    val tangerine = intArrayOf(1, 3, 2, 5, 4, 5, 2, 3)
    println(Solution().solution2(k, tangerine))
}

class Solution {
    fun solution2(k: Int, tangerine: IntArray): Int {
        var answer: Int = 0
        var limit = 0
        tangerine.groupBy { it }.toList().sortedByDescending { it.second.size }.forEach {
            if (limit >= k) {
                return answer
            }
            limit += it.second.size
            answer++
        }
        return answer
    }

    fun solution(k: Int, tangerine: IntArray): Int {
        val map = hashMapOf<Int, Int>()
        tangerine.map {
            val current = map[it] ?: 0
            map[it] = current + 1
        }

        val queue = PriorityQueue<Int>(Collections.reverseOrder())
        map.values.forEach { queue.add(it) }

        var answer = 0
        var sum = 0
        while (queue.isNotEmpty() && sum < k) {
            sum += queue.poll()
            answer++
        }

        return answer
    }
}