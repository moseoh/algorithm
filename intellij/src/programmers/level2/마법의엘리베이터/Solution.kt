package src.programmers.level2.마법의엘리베이터

fun main(args: Array<String>) {
    val storey = 95
    println(Solution().solution(storey))
}

class Solution {
    fun solution(storey: Int): Int {
        var num = storey.toString().toInt()
        var sum = 0

        while (num != 0) {
            val n = num % 10
            num /= 10
            val nextN = num % 10

            if ((n + nextN >= 10 && n >= 5) || n > 5) {
                sum += 10 - n
                num += 1
            } else {
                sum += n
            }
        }

        return sum
    }
}