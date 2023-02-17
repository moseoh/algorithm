package src.programmers.level0.약수구하기

fun main(args: Array<String>) {
    val n = 24
    println(Solution().solution(n).contentToString())
}

class Solution {
    fun solution(n: Int): IntArray = (1..n).filter { n % it == 0 }.toIntArray()
}