package src.programmers.level0.종이자르기

fun main(args: Array<String>) {
    val M = 2
    val N = 2
    println(Solution().solution(M, N))
}


class Solution {
    fun solution(M: Int, N: Int): Int = N * M - 1
}