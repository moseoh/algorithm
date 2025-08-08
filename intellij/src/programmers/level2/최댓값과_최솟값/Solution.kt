package src.programmers.level2.최댓값과_최솟값

fun main() {
    fun printResult(index: Int, result: String, answer: String) {
        val correct = result == answer
        val sb = StringBuilder()
        sb.append("\n\n테스트 케이스 ").append(index).append(": ")
        sb.append(if (correct) "정답" else "오답").append("\n")
        sb.append("\t- 실행 결과: \t").append(result).append("\n")
        sb.append("\t- 기댓값: \t").append(answer).append("\n")
        if (correct) println(sb) else throw RuntimeException(sb.toString())
    }

    val s1 = "1 2 3 4"
    val answer1 = "1 4"
    val result1 = Solution().solution(s1)
    printResult(1, result1, answer1)

    val s2 = "-1 -2 -3 -4"
    val answer2 = "-4 -1"
    val result2 = Solution().solution(s2)
    printResult(2, result2, answer2)

    val s3 = "-1 -1"
    val answer3 = "-1 -1"
    val result3 = Solution().solution(s3)
    printResult(3, result3, answer3)
}

class Solution {
    fun solution(s: String): String {
        val list: List<Int> = s.split(" ").map { it.toInt() }.sorted()
        return "${list[0]} ${list[list.size - 1]}"
    }
}