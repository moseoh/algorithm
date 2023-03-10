package src.programmers.level2.테이블해시함수

fun main(args: Array<String>) {
    val data = arrayOf(
        intArrayOf(2, 2, 5),
        intArrayOf(1, 5, 10),
        intArrayOf(4, 2, 9),
        intArrayOf(3, 8, 3),
    )
    val col = 2
    val row_begin = 2
    val row_end = 3
    println(Solution().solution2(data, col, row_begin, row_end))
}

class Solution {
    fun solution2(data: Array<IntArray>, col: Int, row_begin: Int, row_end: Int): Int {
        data.sortWith(compareBy({ it[col - 1] }, { -it.first() }))
        return (row_begin - 1 until row_end).map { i ->
            data[i].indices.fold(0) { acc, j ->
                acc + data[i][j] % (i + 1)
            }
        }.fold(0) { acc, i -> acc xor i }
    }

    fun solution(data: Array<IntArray>, col: Int, row_begin: Int, row_end: Int): Int {
        data.sortWith(compareBy<IntArray> { it[col - 1] }.thenByDescending { it.first() })

        var answer: Int = 0
        for (i in row_begin..row_end) {
            var sum = 0
            val arr = data[i - 1]
            arr.forEach { sum += (it % i) }
            answer = answer xor sum
        }

        return answer
    }
}