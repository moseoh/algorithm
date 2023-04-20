package src.programmers.level2.롤케이크자르기

fun main() {
    val topping1 = intArrayOf(1, 2, 1, 3, 1, 4, 1, 2)
    val answer1 = 2
    val result1 = Solution().solution(topping1)
    check(result1 == answer1) {
        "\n\n테스트 케이스 1\n" +
                "\t- 실행 결과: $result1\n" +
                "\t- 기댓값: $answer1\n"
    }

    val topping2 = intArrayOf(1, 2, 3, 1, 4)
    val answer2 = 0
    val result2 = Solution().solution(topping2)
    check(result2 == answer2) {
        "\n\n테스트 케이스 2\n" +
                "\t- 실행 결과: $result2\n" +
                "\t- 기댓값: $answer2\n"
    }
}

class Solution {
    fun solution(topping: IntArray): Int {
        var answer = 0
        val leftSet = mutableSetOf<Int>()
        val array = IntArray(topping.sorted().size + 1)
        var rightSize = 0
        topping.forEach { if (array[it]++ == 0) rightSize++ }

        topping.forEach {
            leftSet.add(it)
            if (--array[it] == 0) rightSize--
            if (leftSet.size == rightSize) {
                answer++
            }
        }

        return answer
    }
}