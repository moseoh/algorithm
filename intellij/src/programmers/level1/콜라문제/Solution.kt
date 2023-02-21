package src.programmers.level1.콜라문제

fun main(args: Array<String>) {
    val a = 3
    val b = 1
    val n = 20
    println(Solution().solution(a, b, n))
}

class Solution {
    fun solution(a: Int, b: Int, n: Int): Int {
        var currentCoke = n
        var totalCoke = 0

        while (currentCoke / a != 0) {
            val returnCoke = currentCoke / a * b
            currentCoke %= a
            currentCoke += returnCoke
            totalCoke += returnCoke
        }
        return totalCoke
    }
}