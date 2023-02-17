package src.programmers.level0.가장큰수찾기

fun main(args: Array<String>) {
    val array = intArrayOf(1, 8, 3)
    println(Solution().solution(array).contentToString())
}

class Solution {
    fun solution(array: IntArray): IntArray = array.maxOf { it }.let {
        intArrayOf(it, array.indexOf(it))
    }
}