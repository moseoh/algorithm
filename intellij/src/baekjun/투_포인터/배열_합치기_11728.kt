package src.baekjun.투_포인터

import java.io.ByteArrayInputStream
import java.util.*

fun main(args: Array<String>) {
    val testInput = "2 1\n" +
            "4 7\n" +
            "1"
    System.setIn(ByteArrayInputStream(testInput.toByteArray()))

    val reader = System.`in`.bufferedReader()
    var st = StringTokenizer(reader.readLine())
    val a = st.nextToken().toInt()
    val b = st.nextToken().toInt()

    val arrayA = IntArray(a)
    val arrayB = IntArray(b)
    st = StringTokenizer(reader.readLine())
    for (i in arrayA.indices) {
        arrayA[i] = st.nextToken().toInt()
    }
    st = StringTokenizer(reader.readLine())
    for (i in arrayB.indices) {
        arrayB[i] = st.nextToken().toInt()
    }

    val merged = IntArray(a + b)
    var indexA = 0
    var indexB = 0
    var index = 0

    while (index < a + b) {
        if (indexA == a) {
            merged[index++] = arrayB[indexB++]
        } else if (indexB == b) {
            merged[index++] = arrayA[indexA++]
        } else if (arrayA[indexA] > arrayB[indexB]) {
            merged[index++] = arrayB[indexB++]
        } else {
            merged[index++] = arrayA[indexA++]
        }
    }

    println(merged.joinToString(" "))

    reader.close()
}