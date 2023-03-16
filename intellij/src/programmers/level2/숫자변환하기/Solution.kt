package src.programmers.level2.숫자변환하기

fun main(args: Array<String>) {
    val x = 4
    val y = 40
    val n = 2
    println(Solution().solution(x, y, n))
}

class Solution {
    fun solution(x: Int, y: Int, n: Int): Int {
        return dp(x, y, n)[y]
    }

    private fun dp(x: Int, y: Int, n: Int): IntArray {
        val dp = IntArray(y + 1) { -1 }
        dp[x] = 0
        for (i in x..y) {
            var min = Int.MAX_VALUE
            if (i % 3 == 0 && dp[i / 3] != -1) {
                min = (dp[i / 3] + 1).coerceAtMost(min)
            }
            if (i % 2 == 0 && dp[i / 2] != -1) {
                min = (dp[i / 2] + 1).coerceAtMost(min)
            }
            if (i - n > 0 && dp[i - n] != -1) {
                min = (dp[i - n] + 1).coerceAtMost(min)
            }
            
            if (min != Int.MAX_VALUE) {
                dp[i] = min
            }
        }
        return dp
    }
}