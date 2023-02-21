package src.programmers.level1.과일장수

fun main(args: Array<String>) {
    val k = 3
    val m = 4
    val score = intArrayOf(1, 2, 3, 1, 2, 3, 1)
    println(Solution().solution(k, m, score))
}

class Solution {
    fun solution(k: Int, m: Int, score: IntArray): Int {
        val appleList = score.sortedDescending().toMutableList()
        appleList.add(0, 0)
        
        return appleList.mapIndexed { index, i ->
            if (index % m == 0) i * m
            else 0
        }.sum()
    }
}