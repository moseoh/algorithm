package src.programmers.level2.양궁대회

fun main() {
    fun printResult(index: Int, result: IntArray, answer: IntArray) {
        val correct = result.contentEquals(answer)
        val sb = StringBuilder()
        sb.append("\n\n테스트 케이스 ").append(index).append(": ")
        sb.append(if (correct) "정답" else "오답").append("\n")
        sb.append("\t- 실행 결과: \t").append(result.contentToString()).append("\n")
        sb.append("\t- 기댓값: \t").append(answer.contentToString()).append("\n")
        if (correct) println(sb) else throw RuntimeException(sb.toString())
    }

    val n1 = 5
    val info1 = intArrayOf(2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0)
    val answer1 = intArrayOf(0, 2, 2, 0, 1, 0, 0, 0, 0, 0, 0)
    val result1 = Solution().solution(n1, info1)
    printResult(1, result1, answer1)

    val n2 = 1
    val info2 = intArrayOf(1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
    val answer2 = intArrayOf(-1)
    val result2 = Solution().solution(n2, info2)
    printResult(2, result2, answer2)

    val n3 = 9
    val info3 = intArrayOf(0, 0, 1, 2, 0, 1, 1, 1, 1, 1, 1)
    val answer3 = intArrayOf(1, 1, 2, 0, 1, 2, 2, 0, 0, 0, 0)
    val result3 = Solution().solution(n3, info3)
    printResult(3, result3, answer3)

    val n4 = 10
    val info4 = intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 3, 4, 3)
    val answer4 = intArrayOf(1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 2)
    val result4 = Solution().solution(n4, info4)
    printResult(4, result4, answer4)
}

class Solution {
    fun solution(n: Int, info: IntArray): IntArray {
        var apacheScore = 0
        val rounds = mutableListOf<Round>()
        for (i in info.indices) {
            val score = info.size - i - 1
            rounds.add(Round(i, info[i] + 1, score))
            if (info[i] > 0) apacheScore += score
        }

        rounds.sortByDescending { it.expectedValue }
        var arrowCount = 0
        var lionScore = 0
        val answer = IntArray(info.size)
        rounds.forEach {
            if (arrowCount + it.arrowCount <= n) {
                arrowCount += it.arrowCount
                lionScore += it.expectedScore
                answer[it.index] = it.arrowCount
            }
        }

        answer[10] += n - arrowCount
        return if (apacheScore >= lionScore) intArrayOf(-1) else answer
    }

    data class Round(
        val index: Int,
        val arrowCount: Int,
        val expectedScore: Int,
        val expectedValue: Double
    ) {
        constructor(
            index: Int,
            arrowCount: Int,
            score: Int,
        ) : this(
            index,
            arrowCount,
            if (arrowCount > 1) score * 2 else score,
            if (arrowCount > 1) score * 2 / arrowCount.toDouble() else score / arrowCount.toDouble()
        )

    }
}