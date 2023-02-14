package src.programmers.기사단원의무기

fun main(args: Array<String>) {
    val number = 5
    val limit = 3
    val power = 2
    println(Solution().solution(number, limit, power))
}

class Solution {
    fun solution(number: Int, limit: Int, power: Int): Int =
        IntArray(number) { getCount(it + 1) }
            .reduce { total, value ->
                if (value > limit) total + power
                else total + value
            }

    private fun getCount(n: Int): Int {
        var count = 0
        var i = 1
        while (i * i < n) {
            if (n % i++ == 0) count += 2
        }
        if (i * i == n) count++
        return count
    }
}