package src.programmers.level2.서버_증설_횟수

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

    val players1 = intArrayOf(0, 2, 3, 3, 1, 2, 0, 0, 0, 0, 4, 2, 0, 6, 0, 4, 2, 13, 3, 5, 10, 0, 1, 5)
    val m1 = 3
    val k1 = 5
    val answer1 = 7
    val result1 = Solution().solution(players1, m1, k1)
    printResult(1, result1, answer1)

    val players2 = intArrayOf(0, 0, 0, 10, 0, 12, 0, 15, 0, 1, 0, 1, 0, 0, 0, 5, 0, 0, 11, 0, 8, 0, 0, 0)
    val m2 = 5
    val k2 = 1
    val answer2 = 11
    val result2 = Solution().solution(players2, m2, k2)
    printResult(2, result2, answer2)

    val players3 = intArrayOf(0, 0, 0, 0, 0, 2, 0, 0, 0, 1, 0, 5, 0, 2, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1)
    val m3 = 1
    val k3 = 1
    val answer3 = 12
    val result3 = Solution().solution(players3, m3, k3)
    printResult(3, result3, answer3)
}

class Solution {
    fun solution(players: IntArray, m: Int, k: Int): Int {
        val length = players.size
        val servers = IntArray(length) { 0 }

        var answer: Int = 0
        for (i in 0 until length) {
            var needServerCount = players[i] / m

            for (j in max(0, i - k + 1)..i) {
                needServerCount -= servers[j]
                if (needServerCount <= 0) break
            }

            if (needServerCount <= 0) {
                continue
            }
            answer += needServerCount
            servers[i] = needServerCount
        }

        return answer
    }
}