package src.programmers.level0._7의개수

fun main(args: Array<String>) {
    val array = intArrayOf(7, 77, 17)
    println(Solution().solution(array))
}


class Solution {
    fun solution(array: IntArray): Int = array.joinToString("").count { it == '7' }
}