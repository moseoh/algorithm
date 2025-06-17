package src.programmers.level2.다리를_지나는_트럭

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

    val bridge_length1 = 2
    val weight1 = 10
    val truck_weights1 = intArrayOf(7, 4, 5, 6)
    val answer1 = 8
    val result1 = Solution().solution(bridge_length1, weight1, truck_weights1)
    printResult(1, result1, answer1)

    val bridge_length2 = 100
    val weight2 = 100
    val truck_weights2 = intArrayOf(10)
    val answer2 = 101
    val result2 = Solution().solution(bridge_length2, weight2, truck_weights2)
    printResult(2, result2, answer2)

    val bridge_length3 = 100
    val weight3 = 100
    val truck_weights3 = intArrayOf(10, 10, 10, 10, 10, 10, 10, 10, 10, 10)
    val answer3 = 110
    val result3 = Solution().solution(bridge_length3, weight3, truck_weights3)
    printResult(3, result3, answer3)
}

class Solution {
    fun solution(bridge_length: Int, weight: Int, truck_weights: IntArray): Int {
        // 다리를 나타내는 큐. 다리의 길이만큼 0으로 채워 시작합니다.
        // 이 큐는 시간의 흐름을 나타내며, 각 슬롯은 1초를 의미합니다.
        val bridgeQueue: Queue<Int> = LinkedList(List(bridge_length) { 0 })
        val waitingTrucks: Queue<Int> = LinkedList(truck_weights.toMutableList())

        var time = 0
        var currentWeight = 0

        // 대기 트럭이 모두 다리에 올라갈 때까지 반복
        while (waitingTrucks.isNotEmpty()) {
            time++

            // 1. 다리에서 트럭이 나감
            // 다리 길이만큼의 시간이 지났으므로 맨 앞의 트럭(또는 0)이 빠져나옵니다.
            currentWeight -= bridgeQueue.poll()

            // 다음 대기 트럭의 무게를 가져옵니다.
            val nextTruckWeight = waitingTrucks.peek()

            // 2. 다리에 트럭이 들어옴
            // 다음 트럭이 들어와도 무게를 견딜 수 있으면
            if (currentWeight + nextTruckWeight <= weight) {
                // 대기열에서 트럭을 빼서 다리에 올립니다.
                currentWeight += waitingTrucks.poll()
                bridgeQueue.add(nextTruckWeight)
            } else {
                // 트럭이 못 올라가면 0을 추가하여 시간만 보내도록 합니다.
                bridgeQueue.add(0)
            }
        }

        // 마지막 트럭이 다리에 올라간 후, 다리 길이만큼 시간이 더 흘러야 완전히 건넙니다.
        return time + bridge_length
    }
}