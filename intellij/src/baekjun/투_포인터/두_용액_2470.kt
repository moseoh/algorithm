package src.baekjun.투_포인터

import java.io.ByteArrayInputStream
import java.util.*
import kotlin.math.abs

fun main() {
    val testInput = "3\n" +
            "-999999998 -999999999 -1000000000"
    System.setIn(ByteArrayInputStream(testInput.toByteArray()))

    val reader = System.`in`.bufferedReader()
    val n = reader.readLine().toInt()
    val arr = IntArray(n)
    val st = StringTokenizer(reader.readLine())
    for (i in 0 until n) {
        arr[i] = st.nextToken().toInt()
    }
    Arrays.sort(arr)

    if (arr[0] > 0) {
        println("${arr[0]} ${arr[1]}")
        return
    }

    if (arr[n - 1] < 0) {
        println("${arr[n - 2]} ${arr[n - 1]}")
        return
    }

    var target = Int.MAX_VALUE
    var left = 0
    var right = n - 1
    var answer = intArrayOf(0, n - 1)

    while (left < right && target != 0) {
        val sum = arr[left] + arr[right]
        if (target > abs(sum)) {
            answer = intArrayOf(arr[left], arr[right])
            target = abs(sum)
        }

        if (sum > 0) {
            right--
        } else {
            left++
        }
    }

    println("${answer[0]} ${answer[1]}")

    reader.close()
}