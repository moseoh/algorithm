package src.programmers.level3.연속펄스부분수열의합

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

    val sequence1 = intArrayOf(2, 3, -6, 1, 3, -1, 2, 4)
    val answer1 = 10L
    val result1 = Solution().solution(sequence1)
    printResult(1, result1, answer1)
}

class Solution {
    fun solution(sequence: IntArray): Long {
        var answer: Long = 0
        for (i in 0..1) {
            val array = getPluseArray(sequence, i)
            val dp = LongArray(array.size + 1)
            dp[0] = 0
            for (j in 1 until dp.size) {
                dp[j] = dp[j - 1] + array[j - 1]
            }
            answer = answer.coerceAtLeast(dp.maxOrNull()!! - dp.minOrNull()!!)
        }

        return answer
    }

    private fun getPluseArray(array: IntArray, first: Int): IntArray {
        return array.mapIndexed { index, i -> if (index % 2 == first) i else i * -1 }.toIntArray()
    }
}