package src.programmers.level0.세균증식

fun main(args: Array<String>) {
    val n = 2
    val t = 10
    println(Solution().solution(n, t))
}

class Solution {
    fun solution(n: Int, t: Int): Int = n shl t
}