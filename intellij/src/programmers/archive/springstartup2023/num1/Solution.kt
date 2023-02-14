package src.programmers.archive.springstartup2023.num1

fun main(args: Array<String>) {
    val lotteries = arrayOf(intArrayOf(10, 19, 800), intArrayOf(20, 39, 200), intArrayOf(100, 199, 500))
    println(Solution().solution(lotteries))
}


class Solution {
    fun solution(lotteries: Array<IntArray>): Int = lotteries.mapIndexed { index, it ->
        val targetCount = it[0]
        val currentCount = it[1] + 1
        val rate = targetCount / currentCount.toDouble()
        Lotto(index + 1, it[2], if (rate >= 1) 1.0 else rate)
    }.sortedWith(compareBy(Lotto::rate, Lotto::prize)).toMutableList().last().index

    class Lotto(
        val index: Int,
        val prize: Int,
        val rate: Double,
    )
}