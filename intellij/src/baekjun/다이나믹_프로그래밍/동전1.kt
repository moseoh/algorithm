package src.baekjun.다이나믹_프로그래밍

import java.io.ByteArrayInputStream
import java.util.*

fun main(args: Array<String>) {
    val testInput = "3 10\n" +
            "1\n" +
            "2\n" +
            "5"
    System.setIn(ByteArrayInputStream(testInput.toByteArray()))

    val reader = System.`in`.bufferedReader()
    val st = StringTokenizer(reader.readLine())
    val n = st.nextToken().toInt()
    val k = st.nextToken().toInt()
    val dp = IntArray(k + 1)
    val coin = IntArray(n)
    for (i in 0 until n) {
        coin[i] = reader.readLine().toInt()
    }

    dp[0] = 1
    for (i in 0 until n) {
        for (j in coin[i]..k) {
            dp[j] += dp[j - coin[i]]
        }
    }

    println(dp[k])

    reader.close()
}