package src.programmers.level0.OX퀴즈

import java.lang.RuntimeException
import java.lang.UnsupportedOperationException

fun main(args: Array<String>) {
    val quiz = arrayOf("3 - 4 = -3", "5 + 6 = 11")
    println(Solution().solution(quiz).contentToString())
}

class Solution {
    fun solution(quiz: Array<String>): Array<String> = quiz.map { it ->
        val str = it.split(" ")
        val n1 = str[0].toInt()
        val op = str[1]
        val n2 = str[2].toInt()
        val answer = str[4].toInt()
        val result =
            when (op) {
                "+" -> n1 + n2
                "-" -> n1 - n2
                else -> throw RuntimeException()
            }
        if (result == answer) "O" else "X"
    }.toTypedArray()

    fun solution2(quiz: Array<String>): Array<String> =
        quiz.map { it.split(" ").filterNot(String::isBlank) }.map { (n1, op, n2, _, result) ->
            if (operatorFromString(op).invoke(n1.toInt(), n2.toInt()) == result.toInt()) "O" else "X"
        }.toTypedArray()

    private fun operatorFromString(op: String): (Int, Int) -> Int {
        return when (op) {
            "+" -> { n1, n2 -> n1 + n2 }
            "-" -> { n1, n2 -> n1 - n2 }
            else -> throw UnsupportedOperationException()
        }
    }
}