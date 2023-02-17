package src.programmers.archive.socar.temp1

import kotlin.math.max

fun main(args: Array<String>) {
    val height = intArrayOf(140, 21, 21, 32)
    val width = intArrayOf(2, 1, 3, 7)
    println(Solution().solution(height, width))
}

class Solution {
    fun solution(height: IntArray, width: IntArray): Int {
        val squareList = mutableListOf<Square>()
        for (i in height.indices) {
            squareList.add(Square(height[i], width[i]))
        }
        squareList.sortBy(Square::height)
        return getAreaByWidth(squareList)
    }

    private fun getAreaByWidth(squareList: List<Square>): Int {
        val tempList = squareList.toMutableList()
        var area = 0
        while (tempList.isNotEmpty()) {
            val fullWidth = tempList.sumOf(Square::width)
            val minHeight = tempList.minOf(Square::height)
            area = max(area, fullWidth * minHeight)
            tempList.removeIf { it.height == minHeight }
        }
        return area
    }

    data class Square(val height: Int, val width: Int)
}