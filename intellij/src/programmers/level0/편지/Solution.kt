package src.programmers.level0.편지

fun main(args: Array<String>) {
    val message = "happy birthday!"
    println(Solution().solution(message))
}


class Solution {
    fun solution(message: String): Int = message.length * 2
}
