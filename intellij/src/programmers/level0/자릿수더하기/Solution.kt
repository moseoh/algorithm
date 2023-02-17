package src.programmers.level0.자릿수더하기

fun main(args: Array<String>) {
    val n = 1234
    println(Solution().solution(n))
}

class Solution {
    fun solution(n: Int): Int = n.toString().split("").filter(String::isNotBlank).sumBy { it.toInt() }
    fun solution2(n: Int): Int = n.toString().toList().sumBy { Character.getNumericValue(it) }
}