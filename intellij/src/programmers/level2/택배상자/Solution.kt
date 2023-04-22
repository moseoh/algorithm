package src.programmers.level2.택배상자

import java.util.*

fun main() {
    val order1 = intArrayOf(4, 3, 1, 2, 5)
    val answer1 = 2
    val result1 = Solution().solution(order1)
    check(result1 == answer1) {
        "\n\n테스트 케이스 1\n" +
                "\t- 실행 결과: $result1\n" +
                "\t- 기댓값: $answer1\n"
    }

    val order2 = intArrayOf(5, 4, 3, 2, 1)
    val answer2 = 5
    val result2 = Solution().solution(order2)
    check(result2 == answer2) {
        "\n\n테스트 케이스 2\n" +
                "\t- 실행 결과: $result2\n" +
                "\t- 기댓값: $answer2\n"
    }
}

class Solution {
    fun solution(order: IntArray): Int {
        val subContainer = Stack<Int>()
        val container = (1..order.size).toCollection(LinkedList())
        val truck = mutableListOf<Int>()

        var index = 0
        while (true) {
            subContainer.push(container.pop())

            while (subContainer.isNotEmpty() && subContainer.peek() == order[index]) {
                truck.add(subContainer.pop())
                index++
            }

            if (
                (container.isEmpty() && subContainer.isEmpty()) ||
                (container.isEmpty() && subContainer.isNotEmpty() && subContainer.peek() != order[index])
            ) {
                break
            }
        }

        return truck.size
    }
}