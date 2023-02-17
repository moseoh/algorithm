package src.programmers.level0.문자열밀기

fun main(args: Array<String>) {
    val A = "hello"
    val B = "elloh"
    println(Solution().solution(A, B))
}


class Solution {
    fun solution(A: String, B: String): Int {
        println((B + B).indexOf(A))
        val sb = StringBuilder(A)
        for (i in A.indices) {
            if (B == sb.toString())
                return i
            sb.insert(0, sb[sb.lastIndex])
            sb.deleteCharAt(sb.lastIndex)
        }
        return -1
    }
}