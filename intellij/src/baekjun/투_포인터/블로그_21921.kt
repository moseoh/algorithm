package src.baekjun.투_포인터

import java.io.ByteArrayInputStream
import java.util.*

fun main(args: Array<String>) {
    val testInput = "7 5\n" +
            "1 1 1 1 1 5 1"
    System.setIn(ByteArrayInputStream(testInput.toByteArray()))

    val reader = System.`in`.bufferedReader()
    var st = StringTokenizer(reader.readLine())
    val n = st.nextToken().toInt()
    val x = st.nextToken().toInt()

    val arr = IntArray(n)
    st = StringTokenizer(reader.readLine())
    for (i in arr.indices) {
        arr[i] = st.nextToken().toInt()
    }

    var sum = 0
    for (i in 0 until x) {
        sum += arr[i]
    }

    var max = sum
    var count = 1
    for (i in x until n) {
        sum += arr[i]
        sum -= arr[i - x]
        if (max == sum) {
            count++
        } else if (max < sum) {
            max = sum
            count = 1
        }
    }

    println(if (max == 0) "SAD" else "$max\n$count")

    reader.close()
}