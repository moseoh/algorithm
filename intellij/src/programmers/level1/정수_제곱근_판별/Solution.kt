package src.programmers.level1.정수_제곱근_판별

import kotlin.math.sqrt

fun main() {
    fun printResult(index: Int, result: Long, answer: Long) {
        val correct = result == answer
        val sb = StringBuilder()
        sb.append("\n\n테스트 케이스 ").append(index).append(": ")
        sb.append(if (correct) "정답" else "오답").append("\n")
        sb.append("\t- 실행 결과: \t").append(result).append("\n")
        sb.append("\t- 기댓값: \t").append(answer).append("\n")
        if (correct) println(sb) else throw RuntimeException(sb.toString())
    }

    val n1 = 121L
    val answer1 = 144L
    val result1 = Solution().solution(n1)
    printResult(1, result1, answer1)

    val n2 = 3L
    val answer2 = -1L
    val result2 = Solution().solution(n2)
    printResult(2, result2, answer2)
}

class Solution {
    fun solution(n: Long): Long {
        val sqrt = sqrt(n.toDouble())
        val x = sqrt.toLong()
        return if (x *x ==n ) {
            (x+1) * (x+1)
        } else {
            -1L
        }
    }
}