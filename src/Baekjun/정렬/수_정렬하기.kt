package src.Baekjun.정렬

import java.util.*

fun main() {
    val N = readLine()!!.toInt()

    val arr = arrayOfNulls<Int>(N)
    for(i in 0 until N){
        arr[i] = readLine()!!.toInt()
    }

    Arrays.sort(arr)

    for(i in 0 until N){
        println(arr[i])
    }
}
