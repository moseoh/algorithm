package src.programmers.level2.미로탈출

import java.util.*

fun main(args: Array<String>) {
//    val maps = arrayOf("SOOOL", "XXXXO", "OOOOO", "OXXXX", "OOOOE")
//    val maps = arrayOf("XXXXL", "XOOSX", "XXXXX", "XXXOO", "EXXXX", "XXXXX")
//    val maps = arrayOf("XXXXXL", "XXXXOO", "OOSXOX", "OXXXOX", "EOOOOX")
    val maps = arrayOf("OOOOOL", "OXOXOO", "OOSXOX", "OXXXOX", "EOOOOX")
    println(Solution().solution(maps))
}

class Solution {
    private val dx = intArrayOf(1, 0, -1, 0)
    private val dy = intArrayOf(0, 1, 0, -1)

    fun solution(maps: Array<String>): Int {
        val startIndex = getIndexAt(maps, 'S')
        val leverIndex = getIndexAt(maps, 'L')
        val exitIndex = getIndexAt(maps, 'E')

        val startToLeverCount = bfs(maps, startIndex, leverIndex)
        if (startToLeverCount == -1) return -1
        val leverToEndCount = bfs(maps, leverIndex, exitIndex)
        if (leverToEndCount == -1) return -1
        return startToLeverCount + leverToEndCount
    }

    private fun bfs(maps: Array<String>, from: Pair<Int, Int>, to: Pair<Int, Int>): Int {
        val isVisited = Array(maps.size) { BooleanArray(maps[0].length) }
        val que = LinkedList<Triple<Int, Int, Int>>()
        que.add(Triple(from.first, from.second, 0))

        while (que.isNotEmpty()) {
            val current = que.poll()
            val y = current.first
            val x = current.second
            val count = current.third

            if (to.first == y && to.second == x) return count

            for (i in 0..3) {
                val ny = y + dy[i]
                val nx = x + dx[i]

                if (ny < 0 || ny >= maps.size || nx < 0 || nx >= maps[0].length) continue
                if (maps[ny][nx] == 'X') continue
                if (isVisited[ny][nx]) continue
                isVisited[ny][nx] = true

                que.add(Triple(ny, nx, count + 1))
            }
        }
        return -1
    }

    private fun getIndexAt(maps: Array<String>, char: Char): Pair<Int, Int> {
        maps.forEachIndexed { y, s ->
            s.forEachIndexed { x, c ->
                if (c == char) return Pair(y, x)
            }
        }
        throw RuntimeException("can not find $char")
    }
}