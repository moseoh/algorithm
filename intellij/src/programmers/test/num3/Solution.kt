package src.programmers.test.num3

import javax.swing.text.StyledEditorKit.BoldAction

fun main(args: Array<String>) {
    val queries = arrayOf(intArrayOf(2, 0), intArrayOf(3, 1))
//    val queries = arrayOf(intArrayOf(1, 4, 3), intArrayOf(1, 2, 2))
    println(Solution().solution(queries).contentToString())
}


class Solution {
    fun solution(queries: Array<IntArray>): IntArray {
        println("Start 0")
        run(queries[0])

        println()
        println("Start 1")
        run(queries[1])

        var answer: IntArray = intArrayOf()

        return answer
    }

    fun run(query: IntArray, first: Boolean = false): Boolean {
        println("${query.contentToString()} $first")
        if (isPalindrome(query)) {
            return first
        }

        val indexes = mutableListOf<Int>()
        for (i in query.indices) {
            if (query[i] > 0) {
                query[i]--
                val result = run(query, !first)
                if (result == first) indexes.add(i)
                query[i]++
            }
        }
        println(indexes)

        return true
    }

    fun isPalindrome(array: IntArray): Boolean {
        for (i in 0 until array.size / 2) {
            if (array[i] != array[array.size - 1 - i]) return false
        }
        return true
    }
}