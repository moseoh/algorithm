package src.programmers.temp.푸드파이트대회

fun main(args: Array<String>) {
    val food = intArrayOf(1, 7, 1, 2)
    println(Solution().solution(food))
}


class Solution {
    fun solution(food: IntArray): String {
        val sb = StringBuilder()
        for (i in 1..food.lastIndex)
            repeat(food[i] / 2) { sb.append(i) }
        val reversed = sb.reversed()
        sb.append(0)
        sb.append(reversed)
        return sb.toString()
    }
}