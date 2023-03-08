package src.programmers.level1.바탕화면정리

fun main(args: Array<String>) {
    val wallpaper = arrayOf("..........", ".....#....", "......##..", "...##.....", "....#.....")
    println(Solution().solution(wallpaper).contentToString())
}

class Solution {
    fun solution(wallpaper: Array<String>): IntArray {
        var minY = Int.MAX_VALUE
        var maxY = Int.MIN_VALUE
        var minX = Int.MAX_VALUE
        var maxX = Int.MIN_VALUE
        wallpaper.forEachIndexed { index, s ->
            if (s.contains('#')) {
                minY = minY.coerceAtMost(index)
                maxY = maxY.coerceAtLeast(index)
                minX = minX.coerceAtMost(s.indexOfFirst { it == '#' })
                maxX = maxX.coerceAtLeast(s.indexOfLast { it == '#' })
            }
        }
        return intArrayOf(minY, minX, maxY + 1, maxX + 1)
    }
}