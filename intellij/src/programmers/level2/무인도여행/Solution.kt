package src.programmers.level2.무인도여행

fun main(args: Array<String>) {
    val maps = arrayOf("X591X", "X1X5X", "X231X", "1XXX1")
    println(Solution().solution(maps).contentToString())
}

class Solution {
    companion object {
        val dx = intArrayOf(1, 0, -1, 0)
        val dy = intArrayOf(0, -1, 0, 1)
    }

    fun solution(maps: Array<String>): IntArray {
        val area = maps.map {
            it.toCharArray()
        }.toTypedArray()

        val answer = mutableListOf<Int>()
        area.forEachIndexed { y, arr ->
            arr.forEachIndexed { x, _ ->
                search(area, x, y).let { if (it > 0) answer.add(it) }
            }
        }

        return if (answer.isEmpty()) intArrayOf(-1) else answer.toIntArray().sortedArray()
    }

    private fun search(area: Array<CharArray>, x: Int, y: Int): Int {
        if (x < 0 || area[0].size <= x) return 0
        if (y < 0 || area.size <= y) return 0
        if (area[y][x] == 'X') return 0

        var newSum = Character.getNumericValue(area[y][x])
        area[y][x] = 'X'

        for (i in dx.indices)
            newSum += search(area, x + dx[i], y + dy[i])

        return newSum
    }
}