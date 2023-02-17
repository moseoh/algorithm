package src.programmers.level0.문자열안에문자열

fun main(args: Array<String>) {
    val str1 = "ab6CDE443fgh22iJKlmn1o"
    val str2 = "6CD"
    println(Solution().solution(str1, str2))
}

class Solution {
    fun solution(str1: String, str2: String): Int =
        if (str1 in str2) 1 else 2
}