package src.programmers.level2.이진변환반복하기

fun main(args: Array<String>) {
    val s = "110010101001"
    println(Solution().solution(s).contentToString())
}

class Solution {
    fun solution(s: String): IntArray {
        var str = s
        var count = 0
        var sum = 0
        while (str != "1") {
            count++
            sum += str.count { it == '0' }
            str = Integer.toBinaryString(str.replace("0".toRegex(), "").length)
        }

        return intArrayOf(count, sum)
    }
}