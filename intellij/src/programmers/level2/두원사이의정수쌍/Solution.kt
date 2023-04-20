package src.programmers.level2.두원사이의정수쌍

import kotlin.math.pow

fun main() {
    val r11 = 2
    val r21 = 3
    val answer1 = 20L
    val result1 = Solution().solution(r11, r21)
    check(result1 == answer1) {
        "\n\n테스트 케이스 1\n" +
                "\t- 실행 결과: $result1\n" +
                "\t- 기댓값: $answer1\n"
    }
}

class Solution {
    fun solution(r1: Int, r2: Int): Long {
        val min = r1.toDouble().pow(2).toInt()
        val max = r2.toDouble().pow(2).toInt()

        var answer = 0L
        for (i in 0..r2) {
            for (j in 0..r2) {
                val num = (i.toDouble().pow(2) + j.toDouble().pow(2)).toInt()
                if (num in min..max) {
                    answer += if (j == 0 || i == 0) 2 else 4
                }
            }
        }
        return answer
    }
}