package src.baekjun.시뮬레이션

import java.io.ByteArrayInputStream
import java.util.*
import kotlin.math.abs
import kotlin.math.min

fun main(args: Array<String>) {
    val testInput = "5 2\n" +
            "0 2 0 1 0\n" +
            "1 0 1 0 0\n" +
            "0 0 0 0 0\n" +
            "2 0 0 1 1\n" +
            "2 2 0 1 2"
    System.setIn(ByteArrayInputStream(testInput.toByteArray()))

    data class Index(val x: Int, val y: Int)

    val reader = System.`in`.bufferedReader()
    var st = StringTokenizer(reader.readLine())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()
    val chickens = mutableListOf<Index>()
    val houses = mutableListOf<Index>()

    for (i in 0 until n) {
        st = StringTokenizer(reader.readLine())
        for (j in 0 until n) {
            when (st.nextToken().toInt()) {
                1 -> houses.add(Index(i, j))
                2 -> chickens.add(Index(i, j))
            }
        }
    }

    var min = Int.MAX_VALUE
    val isVisited = BooleanArray(chickens.size)
    fun combination(
        index: Int,
        cnt: Int,
    ) {
        if (cnt == m) {
            var total = 0
            for (house in houses) {
                var distance = Int.MAX_VALUE

                for (j in chickens.indices) {
                    if (isVisited[j]) {
                        distance =
                            min(
                                distance,
                                abs(house.x - chickens[j].x) + abs(house.y - chickens[j].y)
                            )
                    }
                }

                total += distance
            }

            min = min(min, total)
            return
        }

        for (i in index until isVisited.size) {
            isVisited[i] = true
            combination(i + 1, cnt + 1)
            isVisited[i] = false
        }
    }

    combination(0, 0)

    println(min)

    reader.close()
}