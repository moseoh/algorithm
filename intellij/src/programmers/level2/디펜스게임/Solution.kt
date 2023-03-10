package src.programmers.level2.디펜스게임

import java.util.Collections
import java.util.PriorityQueue

fun main(args: Array<String>) {
    val n = 7
    val k = 3
    val enemy = intArrayOf(4, 2, 4, 5, 3, 3, 1)
    println(Solution().solution(n, k, enemy))
}

class Solution {
    fun solution(n: Int, k: Int, enemy: IntArray): Int {
        val queue = PriorityQueue<Int>(Collections.reverseOrder())
        var sum = 0
        var answer = 0
        var ticket = k

        for (i in enemy.indices) {
            sum += enemy[i]
            queue.add(enemy[i])

            if (sum > n) {
                sum -= queue.poll()
                if (ticket == 0) break
                ticket--
            }

            answer++
        }

        return answer
    }
}