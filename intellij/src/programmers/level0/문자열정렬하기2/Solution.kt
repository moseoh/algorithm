package src.programmers.level0.문자열정렬하기2

fun main(args: Array<String>) {
    val my_string: String = "Bcad"
    println(Solution().solution(my_string))
}

class Solution {
    fun solution(my_string: String): String = my_string.toLowerCase().toCharArray().sortedArray().joinToString("")
}