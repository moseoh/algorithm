package src.programmers.level2.비밀_코드_해독

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

    val n1 = 10
    val q1 = arrayOf(intArrayOf(1, 2, 3, 4, 5), intArrayOf(6, 7, 8, 9, 10), intArrayOf(3, 7, 8, 9, 10), intArrayOf(2, 5, 7, 9, 10), intArrayOf(3, 4, 5, 6, 7))
    val ans1 = intArrayOf(2, 3, 4, 3, 3)
    val answer1 = 3
    val result1 = Solution().solution(n1, q1, ans1)
    printResult(1, result1, answer1)

    val n2 = 15
    val q2 = arrayOf(intArrayOf(2, 3, 9, 12, 13), intArrayOf(1, 4, 6, 7, 9), intArrayOf(1, 2, 8, 10, 12), intArrayOf(6, 7, 11, 13, 15), intArrayOf(1, 4, 10, 11, 14))
    val ans2 = intArrayOf(2, 1, 3, 0, 1)
    val answer2 = 5
    val result2 = Solution().solution(n2, q2, ans2)
    printResult(2, result2, answer2)
}

class Solution {
    fun solution(n: Int, q: Array<IntArray>, ans: IntArray): Int {
        val answers = q.map { it.toSet() }
        var count: Int = 0

        fun backtrack(start: Int, current: MutableList<Int>) {
            if (current.size == 5) {
                for ((i, a) in answers.withIndex()) {
                    if (current.count { it in a } != ans[i]) return
                }
                count++
                return
            }

            for (num in start..n) {
                current.add(num)
                backtrack(num + 1, current)
                current.removeLast()
            }
        }

        backtrack(1, mutableListOf())
        return count
    }

}