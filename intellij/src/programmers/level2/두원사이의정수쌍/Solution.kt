package src.programmers.level2.두원사이의정수쌍

import kotlin.math.ceil
import kotlin.math.floor
import kotlin.math.sqrt

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

    val r12 = 2
    val r22 = 4
    val answer2 = 20L
    val result2 = Solution().solution(r12, r22)
    check(result2 == answer2) {
        "\n\n테스트 케이스 2\n" +
                "\t- 실행 결과: $result2\n" +
                "\t- 기댓값: $answer2\n"
    }
}


internal class Solution {
    fun solution(r1: Int, r2: Int): Long {
        var answer: Long = 0
        for (i in 1..r2) {
            val start = ceil(sqrt((r1.toLong() * r1 - i.toLong() * i).toDouble())).toInt()
            val end = floor(sqrt((r2.toLong() * r2 - i.toLong() * i).toDouble())).toInt()
            answer += (end - start + 1).toLong()
        }
        return answer * 4
    }
}