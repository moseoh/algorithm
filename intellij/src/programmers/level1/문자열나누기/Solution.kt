package src.programmers.level1.문자열나누기

fun main(args: Array<String>) {
    val s = "aaabbaccccabba"
    println(Solution().solution(s))
}

class Solution {
    fun solution(s: String): Int {
        var answer = 0
        var str = s
        while (str.isNotEmpty()) {
            str = slice(str)
            answer++
        }
        return answer
    }

    private fun slice(s: String): String {
        var sameCount = 0
        var diffCount = 0
        for (i in s.indices) {
            if (s[i] == s[0]) sameCount++
            else diffCount++
            if (sameCount == diffCount) break
        }
        return s.substring(sameCount + diffCount)
    }
}