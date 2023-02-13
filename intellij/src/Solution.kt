package src

fun main(args: Array<String>) {
    val emergency = intArrayOf(3, 76, 24)
    println(Solution().solution(emergency).contentToString())
}


class Solution {
    fun solution(emergency: IntArray): IntArray {
        val sorted = emergency.sortedDescending()
        return emergency.map {
            sorted.indexOf(it) + 1
        }.toIntArray()
    }
}