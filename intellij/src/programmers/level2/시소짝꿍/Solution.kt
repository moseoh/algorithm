package src.programmers.level2.시소짝꿍

fun main(args: Array<String>) {
    val weights = intArrayOf(800, 800, 900, 300, 400)
    println(Solution().solution(weights))
}

class Solution {
    fun solution(weights: IntArray): Long {
        val arr = IntArray(size = 1001)
        var answer = 0L
        weights.forEach {
            canNum(it).forEach { n -> answer += arr[n] }
            arr[it] += 1
        }

        return answer
    }

    private fun canNum(num: Int): IntArray {
        val arr = doubleArrayOf(
            num.toDouble(),
            num / 2.0,
            num * 2 / 3.0,
            num * 3 / 4.0,
            num * 2.0,
            num * 3 / 2.0,
            num * 4 / 3.0
        )

        return arr.filter { it <= 1000 && it.toInt().toDouble() == it }.map { it.toInt() }.toIntArray()
    }
}