package src.programmers.level1.제일_작은_수_제거하기

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

    val arr1 = intArrayOf(4, 3, 2, 1)
    val answer1 = intArrayOf(4, 3, 2)
    val result1 = Solution().solution(arr1)
    printResult(1, result1, answer1)

    val arr2 = intArrayOf(10)
    val answer2 = intArrayOf(-1)
    val result2 = Solution().solution(arr2)
    printResult(2, result2, answer2)
}

class Solution {
    fun solution(arr: IntArray): IntArray {
        val min = arr.minOrNull() ?: return intArrayOf(-1)
        val answer = arr.filter { it != min }
        return if (answer.isEmpty()) {
            intArrayOf(-1)
        } else {
            answer.toIntArray()
        }
    }
}