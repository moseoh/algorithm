package src.programmers.level1.가장가까운같은글자

fun main(args: Array<String>) {
    val s = "foobar"
    println(Solution().solution(s).contentToString())
}

class Solution {
    fun solution(s: String): IntArray =
        s.mapIndexed { index, char -> s.substring(0, index).lastIndexOf(char).let { if (it != -1) index - it else it } }
            .toIntArray()
}