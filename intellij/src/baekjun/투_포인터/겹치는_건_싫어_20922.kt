package src.baekjun.투_포인터

import java.io.ByteArrayInputStream
import java.util.*
import kotlin.math.max

fun main(args: Array<String>) {
    val testInput = "9 2\n" +
            "3 2 5 5 6 4 4 5 7"
    System.setIn(ByteArrayInputStream(testInput.toByteArray()))

    val reader = System.`in`.bufferedReader()
    var st = StringTokenizer(reader.readLine())
    val n = st.nextToken().toInt()
    val k = st.nextToken().toInt()
    st = StringTokenizer(reader.readLine())
    val array = IntArray(n)
    for (i in array.indices) {
        array[i] = st.nextToken().toInt()
    }

    val counting = IntArray(100_001)

    var max = 0
    var left = 0
    var right = 0

    while (left < n) {
        while (right < n) {
            if (counting[array[right]] == k) break
            counting[array[right++]]++
        }
        max = max(max, right - left)
        counting[array[left++]]--
    }

    println(max)

    reader.close()
}
