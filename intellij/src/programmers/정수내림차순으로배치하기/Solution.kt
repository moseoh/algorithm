package src.programmers.정수내림차순으로배치하기

fun main(args: Array<String>) {
    val n = 118372L
    println(Solution().solution(n))
}

class Solution {
    fun solution(n: Long): Long =
        String(n.toString().toCharArray().sortedArrayDescending()).toLong()
}