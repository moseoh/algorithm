package src.baekjun.다이나믹_프로그래밍

import java.io.ByteArrayInputStream

fun main(args: Array<String>) {
    val testInput = "30"
    System.setIn(ByteArrayInputStream(testInput.toByteArray()))

    val reader = System.`in`.bufferedReader()
    val n = reader.readLine().toInt()

    val dp = IntArray(31)
    dp[0] = 1
    dp[2] = 3
    for (i in 4..n) {
        dp[i] = dp[i - 2] * 3
        for (j in 4..i step 2) {
            dp[i] += dp[i - j] * 2
        }
    }


    println(dp[n])

    reader.close()
}