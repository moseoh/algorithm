package src.programmers.고득점kit.스택큐.다리를지나는트럭

import java.util.*

fun main() {
    val bridge_length1 = 2
    val weight1 = 10
    val truck_weights1 = intArrayOf(7, 4, 5, 6)
    check(Solution().solution(bridge_length1, weight1, truck_weights1) == 8) { "오답" }

    val bridge_length2 = 100
    val weight2 = 100
    val truck_weights2 = intArrayOf(10)
    check(Solution().solution(bridge_length2, weight2, truck_weights2) == 101) { "오답" }

    val bridge_length3 = 100
    val weight3 = 100
    val truck_weights3 = intArrayOf(10, 10, 10, 10, 10, 10, 10, 10, 10, 10)
    check(Solution().solution(bridge_length3, weight3, truck_weights3) == 110) { "오답" }
}

class Solution {
    fun solution(bridge_length: Int, weight: Int, truck_weights: IntArray): Int {
        val truckQue: Queue<Int> = LinkedList()
        val bridgeQue: Queue<Pair<Int, Int>> = LinkedList()
        truck_weights.forEach { truckQue.add(it) }

        var answer = 0
        while (!(truckQue.isEmpty() && bridgeQue.isEmpty())) {
            answer++
            if (bridgeQue.isNotEmpty() && bridgeQue.peek().second + bridge_length == answer) {
                bridgeQue.poll()
            }

            if (truckQue.isNotEmpty() && bridgeQue.sumOf { it.first } + truckQue.peek() <= weight) {
                bridgeQue.add(Pair(truckQue.poll(), answer))
            }
        }

        return answer
    }
}
