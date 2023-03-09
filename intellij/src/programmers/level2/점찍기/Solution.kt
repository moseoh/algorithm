package src.programmers.level2.점찍기

import kotlin.math.pow
import kotlin.math.sqrt

fun main(args: Array<String>) {
    val k = 1
    val d = 5
    println(Solution().solution(k, d))
}

class Solution {
    fun solution(k: Int, d: Int): Long {
        var answer: Long = 0
        for (i in 0..d step k) {
            answer += (sqrt(d.toDouble().pow(2.0) - i.toDouble().pow(2.0)).toInt() / k + 1)
        }
        return answer
    }
}