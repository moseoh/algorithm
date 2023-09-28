package src.programmers.level1.공원_산책

fun main() {
    fun printResult(index: Int, result: IntArray, answer: IntArray) {
        val correct = result.contentEquals(answer)
        val sb = StringBuilder()
        sb.append("\n\n테스트 케이스 ").append(index).append(": ")
        sb.append(if (correct) "정답" else "오답").append("\n")
        sb.append("\t- 실행 결과: \t").append(result.contentToString()).append("\n")
        sb.append("\t- 기댓값: \t").append(answer.contentToString()).append("\n")
        if (correct) println(sb) else throw RuntimeException(sb.toString())
    }

    val park1 = arrayOf("SOO", "OOO", "OOO")
    val routes1 = arrayOf("E 2", "S 2", "W 1")
    val answer1 = intArrayOf(2, 1)
    val result1 = Solution().solution(park1, routes1)
    printResult(1, result1, answer1)

    val park2 = arrayOf("SOO", "OXX", "OOO")
    val routes2 = arrayOf("E 2", "S 2", "W 1")
    val answer2 = intArrayOf(0, 1)
    val result2 = Solution().solution(park2, routes2)
    printResult(2, result2, answer2)

    val park3 = arrayOf("OSO", "OOO", "OXO", "OOO")
    val routes3 = arrayOf("E 2", "S 3", "W 1")
    val answer3 = intArrayOf(0, 0)
    val result3 = Solution().solution(park3, routes3)
    printResult(3, result3, answer3)

    val park4 = arrayOf("OXO", "XSX", "OXO")
    val routes4 = arrayOf("S 1", "E 1", "W 1", "N 1")
    val answer4 = intArrayOf(1, 1)
    val result4 = Solution().solution(park4, routes4)
    printResult(4, result4, answer4)
}

class Solution {
    fun solution(park: Array<String>, routes: Array<String>): IntArray {
        var current = getStartPosition(park)

        routes.forEach {
            val split = it.split(" ")
            current = movedPosition(Direction.valueOf(split[0]), split[1].toInt(), park, current)
        }

        return current.toAnswer()
    }

    private fun getStartPosition(
        park: Array<String>,
    ): Position {
        for (y in park.indices) {
            for (x in 0 until park[0].length) {
                if (park[y][x] == 'S') {
                    return Position(x, y)
                }
            }
        }

        throw RuntimeException("시작 위치를 찾을 수 없음")
    }

    private fun movedPosition(
        direction: Direction,
        distance: Int,
        park: Array<String>,
        current: Position
    ): Position {
        var a: Int
        var b: Int
        val max = Position(park[0].length, park.size)
        val moved = Position(current.x + direction.x * distance, current.y + direction.y * distance)

        if (moved.x < 0 || moved.x >= max.x || moved.y < 0 || moved.y >= max.y) {
            return current
        }

        a = minOf(current.x, moved.x)
        b = maxOf(current.x, moved.x)
        for (x in a..b) {
            if (park[current.y][x] == 'X') {
                return current
            }
        }

        a = minOf(current.y, moved.y)
        b = maxOf(current.y, moved.y)
        for (y in a..b) {
            if (park[y][current.x] == 'X') {
                return current
            }
        }

        return moved
    }

    data class Position(val x: Int, val y: Int) {
        fun toAnswer(): IntArray {
            return intArrayOf(y, x)
        }
    }

    enum class Direction(val x: Int, val y: Int) {
        E(1, 0),
        S(0, 1),
        W(-1, 0),
        N(0, -1)
    }
}

