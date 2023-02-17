package src.programmers.archive.etc.Level2.시소짝꿍

fun main(args: Array<String>) {
    val weights = intArrayOf(
        100, 180, 360, 100,
        100, 180, 360, 100,
        100, 180, 360, 100,
        100, 180, 360, 100,
        100, 180, 360, 100,
        100, 180, 360, 100,
        100, 180, 360, 100,
        100, 180, 360, 100,
        100, 180, 360, 100,
        100, 180, 360, 100,
        100, 180, 360, 100,
        100, 180, 360, 100,
        100, 180, 360, 100,
        100, 180, 360, 100,
        100, 180, 360, 100,
        100, 180, 360, 100,
        100, 180, 360, 100,
        100, 180, 360, 100,
        100, 180, 360, 100,
        100, 180, 360, 100,
        100, 180, 360, 100,
    )
    val startTime = System.currentTimeMillis()
    for (i in 0..10000) {
        println(Solution().solution(weights))
    }
    val endTime = System.currentTimeMillis()
    println("소요시간: ${endTime - startTime}")
}

class Solution {
    fun solution(weights: IntArray): Long {
        val lengths = intArrayOf(2, 3, 4)
        var answer: Long = 0
        for (i in 0 until weights.size - 1) {
            for (j in i + 1 until weights.size) {
                if (isPartner(weights[i], weights[j], lengths)) {
                    answer++
                }
            }
        }

        return answer
    }

    private fun isPartner(a: Int, b: Int, lengths: IntArray): Boolean {
        if (a == b) return true
        if (a * 2 == b * 3) return true
        if (a * 2 == b * 4) return true
        if (a * 3 == b * 2) return true
        if (a * 3 == b * 4) return true
        if (a * 4 == b * 2) return true
        if (a * 4 == b * 3) return true
        return false
    }
}