package src.baekjun.다이나믹_프로그래밍

import java.io.ByteArrayInputStream
import java.util.*
import kotlin.math.max

fun main(args: Array<String>) {
    val testInput = "10\n" +
            "5 50\n" +
            "4 40\n" +
            "3 30\n" +
            "2 20\n" +
            "1 10\n" +
            "1 10\n" +
            "2 20\n" +
            "3 30\n" +
            "4 40\n" +
            "5 50"
    System.setIn(ByteArrayInputStream(testInput.toByteArray()))

    data class Job(val time: Int, val cost: Int)

    val reader = System.`in`.bufferedReader()
    var st = StringTokenizer(reader.readLine())
    val n = st.nextToken().toInt()
    val list = mutableListOf<Job>()
    val dp = IntArray(n + 1)
    repeat(n) {
        st = StringTokenizer(reader.readLine())
        list.add(Job(st.nextToken().toInt(), st.nextToken().toInt()))
    }

    var answer = 0
    for (i in 0 until n) {
        if (i != 0)
            dp[i] = max(dp[i], dp[i - 1])
        val target = i + list[i].time
        if (target > n) continue
        dp[target] = max(dp[i] + list[i].cost, dp[target])
        answer = max(answer, dp[target])
    }

    println(answer)

    reader.close()
}
