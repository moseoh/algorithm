package src.programmers.archive.toss._1

import kotlin.math.max

fun main() {
    val s = "21"
    val n = 2
    println(Solution().solution(s, n))
}

class Solution {
    fun solution(s: String, N: Int): Int {
        var answer = -1
        for (i in 0 until s.length - N + 1) {
            if (isMatch(i, s, N)) {
                answer = max(answer, s.substring(i, i + N).toInt())
            }
        }
        return answer
    }

    private fun isMatch(startIndex: Int, s: String, N: Int): Boolean {
        val list = mutableListOf<Int>()
        val numbers = List(N) { it + 1 }

        for (i in startIndex until startIndex + N) {
            list.add(s[i].digitToInt())
        }

        return numbers == list.sorted()
    }
}