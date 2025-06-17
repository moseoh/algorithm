package src.programmers.level2.다리를_지나는_트럭

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
        var answer = 0
        return answer
    }
}