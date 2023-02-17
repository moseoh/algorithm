package src.programmers.level0.n의배수고르기

fun main(args: Array<String>) {
    val n = 3
    val numlist = intArrayOf(4, 5, 6, 7, 8, 9, 10, 11, 12)
    println(Solution().solution(n, numlist).contentToString())
}

class Solution {
    fun solution(n: Int, numlist: IntArray): IntArray = numlist.filter { it % n == 0 }.toIntArray()
}