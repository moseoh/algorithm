package src.programmers.level0.옹알이1

fun main(args: Array<String>) {
    val babbling = arrayOf("aya", "yee", "u", "maa", "wyeoo")
    println(Solution().solution(babbling))
}


class Solution {
    fun solution(babbling: Array<String>): Int =
        babbling.map {
            it.replace("aya|ye|woo|ma".toRegex(), "")
        }.count { it.isEmpty() }
}