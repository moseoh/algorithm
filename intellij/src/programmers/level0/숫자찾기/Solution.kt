package src.programmers.level0.숫자찾기

fun main(args: Array<String>) {
    val num = 29183
    val k = 1
    println(Solution().solution(num, k))
}

class Solution {
    fun solution(num: Int, k: Int): Int = "-$num".indexOf(k.toString())
}