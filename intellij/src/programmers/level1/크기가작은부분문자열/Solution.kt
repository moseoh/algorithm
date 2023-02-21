package src.programmers.level1.크기가작은부분문자열

fun main(args: Array<String>) {
    val t = "10203"
    val p = "2"
    println(Solution().solution(t, p))
}

class Solution {
    fun solution(t: String, p: String): Int =
        (0..t.length - p.length).map { t.substring(0 + it, p.length + it) }
            .count { p.toLong() >= it.toLong() }
}