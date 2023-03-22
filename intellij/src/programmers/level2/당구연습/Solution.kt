package src.programmers.level2.당구연습

import kotlin.math.pow

fun main() {
//    val m1 = 10
//    val n1 = 10
//    val startX1 = 3
//    val startY1 = 7
//    val balls1 = arrayOf(intArrayOf(7, 7), intArrayOf(2, 7), intArrayOf(7, 3), intArrayOf(0, 0))
//    check(Solution().solution(m1, n1, startX1, startY1, balls1).contentEquals(intArrayOf(52, 37, 116))) { "오답" }

    val m2 = 10
    val n2 = 10
    val startX2 = 3
    val startY2 = 3
    val balls2 = arrayOf(intArrayOf(1, 1))
    println(Solution().solution(m2, n2, startX2, startY2, balls2).contentToString())
}

class Solution {
    fun solution(m: Int, n: Int, startX: Int, startY: Int, balls: Array<IntArray>): IntArray =
        balls.map { (ballX, ballY) ->
            val list = mutableListOf<Int>()
            // 왼쪽
            if (!(startY == ballY && ballX < startX))
                list.add((startX + ballX).pow() + (startY - ballY).pow())

            // 오른쪽
            if (!(startY == ballY && ballX > startX))
                list.add((2 * m - (startX + ballX)).pow() + (startY - ballY).pow())

            // 아래
            if (!(startX == ballX && ballY < startY))
                list.add((startX - ballX).pow() + (startY + ballY).pow())

            // 위
            if (!(startX == ballX && ballY > startY))
                list.add((startX - ballX).pow() + (2 * n - (startY + ballY)).pow())
            list.minOrNull()!!
        }.toIntArray()


    private fun Int.pow(n: Int = 2): Int = this.toDouble().pow(n.toDouble()).toInt()
}

