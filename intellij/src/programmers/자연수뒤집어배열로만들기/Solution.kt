package src.programmers.자연수뒤집어배열로만들기

fun main(args: Array<String>) {
    val n = 12345L
    println(Solution().solution(n).contentToString())
}

class Solution {
    fun solution(n: Long): IntArray =
        n.toString().reversed().map {
            Character.getNumericValue(it)
        }.toIntArray()
}