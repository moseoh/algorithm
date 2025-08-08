package src.programmers.level1.약수의_합

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

    val n1 = 12
    val answer1 = 28
    val result1 = Solution().solution(n1)
    printResult(1, result1, answer1)

    val n2 = 5
    val answer2 = 6
    val result2 = Solution().solution(n2)
    printResult(2, result2, answer2)

    val n3 = 0
    val answer3 = 0
    val result3 = Solution().solution(n3)
    printResult(3, result3, answer3)
}

class Solution {
    fun solution(n: Int): Int {
        return (1..n).filter { n % it == 0 }.sum()
    }
}