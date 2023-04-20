package src.programmers.level2.요격시스템


fun main() {
    val targets1 = arrayOf(
        intArrayOf(4, 5),
        intArrayOf(4, 8),
        intArrayOf(10, 14),
        intArrayOf(11, 13),
        intArrayOf(5, 12),
        intArrayOf(3, 7),
        intArrayOf(1, 4)
    )
    val answer1 = 3
    val result1 = Solution().solution(targets1)
    check(result1 == answer1) {
        "\n\n테스트 케이스 1\n" +
                "\t- 실행 결과: $result1\n" +
                "\t- 기댓값: $answer1\n"
    }
}

class Solution {
    fun solution(targets: Array<IntArray>): Int {
        targets.sortBy { it[1] }

        var end = targets[0][1]
        var answer = 1
        for (tar in targets) {
            if (tar[0] >= end) {
                end = tar[1]
                answer++
            }
        }
        return answer
    }
}