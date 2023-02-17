package src.programmers.level0.배열의유사도

fun main(args: Array<String>) {
    val s1 = arrayOf("a", "b", "c")
    val s2 = arrayOf("com", "b", "d", "p", "c")
    println(Solution().solution(s1, s2))
}

class Solution {
    fun solution(s1: Array<String>, s2: Array<String>): Int = s1.count(s2::contains)
}