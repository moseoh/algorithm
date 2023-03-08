package src.programmers.level2.덧칠하기

fun main(args: Array<String>) {
    val n = 8
    val m = 4
    val section = intArrayOf(2, 3, 6)
    println(Solution().solution2(n, m, section))
}

class Solution {
    fun solution2(n: Int, m: Int, section: IntArray): Int {
        var cnt = 0
        var paintIdx = 1
        section.forEach {
            if (paintIdx <= it) {
                ++cnt
                paintIdx = it + m
            }
        }
        return cnt
    }

    fun solution(n: Int, m: Int, section: IntArray): Int {
        val isPainted = BooleanArray(n) { true }
        section.forEach { isPainted[it - 1] = false }

        var count = 0
        isPainted.forEachIndexed { index, it ->
            if (!it) {
                doPaint(index, m, isPainted)
                count++
            }
        }

        return count
    }

    private fun doPaint(index: Int, m: Int, isPainted: BooleanArray) =
        (index until (index + m).coerceAtMost(isPainted.size)).forEach {
            isPainted[it] = true
        }

}