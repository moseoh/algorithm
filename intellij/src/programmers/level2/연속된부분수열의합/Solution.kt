package src.programmers.level2.연속된부분수열의합

import java.util.*

fun main() {
    val sequence1 = intArrayOf(1, 2, 3, 4, 5)
    val k1 = 7
    val answer1 = intArrayOf(2, 3)
    val result1 = Solution().solution(sequence1, k1)
    check(result1.contentEquals(answer1)) {
        "\n\n테스트 케이스 1\n" +
                "\t- 실행 결과: ${result1.contentToString()}\n" +
                "\t- 기댓값: ${answer1.contentToString()}\n"
    }

    val sequence2 = intArrayOf(1, 1, 1, 2, 3, 4, 5)
    val k2 = 5
    val answer2 = intArrayOf(6, 6)
    val result2 = Solution().solution(sequence2, k2)
    check(result2.contentEquals(answer2)) {
        "\n\n테스트 케이스 2\n" +
                "\t- 실행 결과: ${result2.contentToString()}\n" +
                "\t- 기댓값: ${answer2.contentToString()}\n"
    }

    val sequence3 = intArrayOf(2, 2, 2, 2, 2)
    val k3 = 6
    val answer3 = intArrayOf(0, 2)
    val result3 = Solution().solution(sequence3, k3)
    check(result3.contentEquals(answer3)) {
        "\n\n테스트 케이스 3\n" +
                "\t- 실행 결과: ${result3.contentToString()}\n" +
                "\t- 기댓값: ${answer3.contentToString()}\n"
    }
}

class Solution {
    fun solution(sequence: IntArray, k: Int): IntArray {
        var answer = Pair(0, sequence.size)
        val que = LinkedList<Pair<Int, Int>>()
        var sum = 0
        for (i in sequence.indices) {
            que.add(Pair(i, sequence[i]))
            sum += que.last.second
            while (sum > k) {
                sum -= que.poll().second
            }

            if (sum == k) {
                val startIndex = que.first().first
                val endIndex = que.last().first
                if (endIndex - startIndex < answer.second - answer.first) {
                    answer = Pair(startIndex, endIndex)
                }
            }
        }

        return intArrayOf(answer.first, answer.second)
    }
}