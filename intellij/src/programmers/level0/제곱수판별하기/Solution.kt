package src.programmers.level0.제곱수판별하기

import kotlin.math.sqrt

fun main(args: Array<String>) {
    val n = 144
    println(Solution().solution(n))
}

class Solution {
    fun solution(n: Int): Int =
        if (sqrt(n.toDouble()) % 1 == 0.toDouble()) 1 else 2
}