package src.programmers.level2.우박수열정적분

fun main() {
    val k1 = 5
    val ranges1 = arrayOf(intArrayOf(0, 0), intArrayOf(0, -1), intArrayOf(2, -3), intArrayOf(3, -3))
    val answer1 = doubleArrayOf(33.0, 31.5, 0.0, -1.0)
    val result1 = Solution().solution(k1, ranges1)
    check(result1.contentEquals(answer1)) {
        "\n\n테스트 케이스 1\n" +
                "\t- 실행 결과: ${result1.contentToString()}\n" +
                "\t- 기댓값: ${answer1.contentToString()}\n"
    }

    val k2 = 10
    val ranges2 = arrayOf(intArrayOf(0, 0), intArrayOf(0, -1), intArrayOf(2, -3), intArrayOf(3, -3))
    val answer2 = doubleArrayOf(33.0, 31.5, 0.0, -1.0)
    val result2 = Solution().solution(k2, ranges2)
    check(result2.contentEquals(answer2)) {
        "\n\n테스트 케이스 1\n" +
                "\t- 실행 결과: ${result2.contentToString()}\n" +
                "\t- 기댓값: ${answer2.contentToString()}\n"
    }
}

class Solution {
    fun solution(k: Int, ranges: Array<IntArray>): DoubleArray {
        val hailStone = getHailStone(k)
        val area = getArea(hailStone)
        println(hailStone)
        println(area)
        return ranges.map { getIntegral(area, it) }.toDoubleArray()
    }

    private fun getIntegral(area: List<Double>, range: IntArray): Double {
        val startIndex = range[0]
        val endIndex = area.size - 1 + range[1]
        if (startIndex == endIndex) return 0.0
        if (startIndex > endIndex) return -1.0

        println("startIndex: $startIndex, endIndex: $endIndex")
        return area[endIndex] - area[startIndex]
    }

    private fun getArea(hailStone: List<Int>): List<Double> {
        val area = mutableListOf<Double>()
        area.add(0.0)

        for (i in 0 until hailStone.size - 1) {

            val min = hailStone[i].coerceAtMost(hailStone[i + 1])
            val max = hailStone[i].coerceAtLeast(hailStone[i + 1])
            area.add(min + ((max - min).toDouble() / 2) + area[i])
        }
        return area
    }

    private fun getHailStone(k: Int): List<Int> {
        val hailStone = mutableListOf<Int>()
        var num = k
        while (num != 1) {
            hailStone.add(num)
            num = if (num % 2 == 0) num / 2 else num * 3 + 1
        }
        hailStone.add(1)
        return hailStone
    }
}