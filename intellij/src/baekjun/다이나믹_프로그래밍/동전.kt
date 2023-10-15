package src.baekjun.다이나믹_프로그래밍

import java.io.ByteArrayInputStream
import java.util.*

fun main(args: Array<String>) {
    val testInput = "3\n" +
            "2\n" +
            "1 2\n" +
            "1000\n" +
            "3\n" +
            "1 5 10\n" +
            "100\n" +
            "2\n" +
            "5 7\n" +
            "22"
    System.setIn(ByteArrayInputStream(testInput.toByteArray()))

    val reader = System.`in`.bufferedReader()

    val sb = StringBuilder()
    val t = reader.readLine().toInt()

    repeat(t) {
        val n = reader.readLine().toInt()
        val st = StringTokenizer(reader.readLine())
        val coins = IntArray(n)
        for (i in 0 until n) {
            coins[i] = st.nextToken().toInt()
        }

        val m = reader.readLine().toInt()
        val dp = IntArray(m + 1)

        dp[0] = 1
        for (coin in coins) {
            for (j in coin..m) {
                dp[j] += dp[j - coin]
            }
        }

        sb.append(dp[m]).append("\n")
    }

    println(sb)

    reader.close()
}