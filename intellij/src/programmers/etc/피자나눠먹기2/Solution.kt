package src.programmers.etc.피자나눠먹기2

fun main(args: Array<String>) {
    val n = 10
    println(Solution().solution(n))
}


class Solution {
    fun solution(n: Int): Int {
        return lcm(n, 6) / 6
    }

    // 최대공약수
    private fun gcd(a: Int, b: Int): Int {
        return if (b == 0) a else gcd(b, a % b)
    }

    // 최소공배수
    private fun lcm(a: Int, b: Int): Int {
        return a / gcd(a, b) * b
    }
}