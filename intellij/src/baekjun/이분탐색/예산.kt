package src.baekjun.이분탐색

import java.io.ByteArrayInputStream
import java.util.*
import kotlin.math.max
import kotlin.math.min

fun main() {
    val testInput = "4\n" +
            "120 110 140 150\n" +
            "485"
    System.setIn(ByteArrayInputStream(testInput.toByteArray()))

    val reader = System.`in`.bufferedReader()
    val N = reader.readLine().toInt()
    val tokens = StringTokenizer(reader.readLine())
    val array = IntArray(N)
    val money = reader.readLine().toInt()

    var left = 0
    var right = 0

    repeat(N) {
        array[it] = tokens.nextToken().toInt()
        right = max(right, array[it])
    }

    while (left <= right) {
        val mid = (left + right) / 2

        var budget = 0
        repeat(N) {
            budget += min(mid, array[it])
        }

        if (budget <= money) left = mid + 1
        else right = mid - 1
    }


    println(right)

    reader.close()
}