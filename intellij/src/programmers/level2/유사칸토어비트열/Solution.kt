package src.programmers.level2.유사칸토어비트열

import kotlin.math.pow

fun main(args: Array<String>) {
    val n = 3
    val l = 1L
    val r = 1L
    println(Solution().solution(n, l, r))
}

class Solution {
    fun solution(n: Int, l: Long, r: Long): Int {
        val sum = 4.0.pow(n).toLong()
        val prefixSum = sum(n, l)
        val suffixSum = sum(n, (5.0.pow(n) - r + 1).toLong())
        return (sum - prefixSum - suffixSum).toInt()
    }

    fun sum(n: Int, i: Long): Long {
        if (n == 1) return if (i > 3) i - 2 else if (i > 0) i - 1 else 0

        val num = 5.0.pow(n - 1).toLong()
        val sectionSum = 4.0.pow(n - 1).toLong()

        val sectionIndex = if (i % num == 0L) i / num - 1 else i / num
        val index = if (i % num == 0L) num else i % num

        return if (sectionIndex > 2L) (sectionIndex - 1) * sectionSum + sum(n - 1, index)
        else if (sectionIndex == 2L) sectionSum * 2
        else sectionIndex * sectionSum + sum(n - 1, index)
    }
}