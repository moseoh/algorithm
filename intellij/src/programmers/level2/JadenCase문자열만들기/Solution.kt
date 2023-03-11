package src.programmers.level2.JadenCase문자열만들기

fun main(args: Array<String>) {
    val s = "3people unFollowed me  asd  "
    println(Solution().solution(s))
}

class Solution {
    fun solution(s: String): String =
        s.split(" ").joinToString(" ") {
            it.lowercase().replaceFirstChar { c -> c.titlecase() }
        }
}