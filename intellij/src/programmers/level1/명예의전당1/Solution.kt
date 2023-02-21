package src.programmers.level1.명예의전당1

fun main(args: Array<String>) {
    val k = 3
    val score = intArrayOf(10, 100, 20, 150, 1, 100, 200)
    println(Solution().solution(k, score).contentToString())
}

class Solution {
    fun solution(k: Int, score: IntArray): IntArray {
        val reward = mutableListOf<Int>()
        val result = mutableListOf<Int>()
        score.forEach {
            reward.add(it)
            reward.sortDescending()
            if (reward.size > k) reward.removeLast()
            result.add(reward.last())
        }
        return result.toIntArray()
    }
}