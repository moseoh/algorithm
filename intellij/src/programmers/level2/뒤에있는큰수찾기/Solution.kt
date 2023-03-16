package src.programmers.level2.뒤에있는큰수찾기

import java.util.*

fun main(args: Array<String>) {
    val numbers = intArrayOf(9, 1, 5, 3, 6, 2)
    println(Solution().solution(numbers).contentToString())
}

class Solution {
    fun solution(numbers: IntArray): IntArray {
        val answer = IntArray(numbers.size) { -1 }
        numbers.reverse()
        val stack = Stack<Int>()
        for (i in numbers.indices) {
            while (stack.isNotEmpty()) {
                if (stack.peek() > numbers[i]) {
                    answer[i] = stack.peek()
                    break
                } else {
                    stack.pop()
                }
            }
            stack.push(numbers[i])
        }
        answer.reverse()
        return answer
    }
}