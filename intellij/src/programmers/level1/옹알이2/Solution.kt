package src.programmers.level1.옹알이2

fun main(args: Array<String>) {
    val babbling = arrayOf("ayaye", "uuu", "yeye", "yemawoo", "ayaayaa")
    println(Solution().solution(babbling))
}

class Solution {
    fun solution(babbling: Array<String>): Int =
        babbling.map {
            if (it.contains("ayaaya|yeye|woowoo|mama".toRegex())) "x"
            else it.replace("aya|ye|woo|ma".toRegex(), "")
        }.count { it.isEmpty() }
}