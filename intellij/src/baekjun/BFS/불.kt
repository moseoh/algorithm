package src.baekjun.BFS

import java.io.ByteArrayInputStream
import java.util.*

fun main(args: Array<String>) {
    val testInput = "5 6\n" +
            "######\n" +
            "#J...#\n" +
            "#....#\n" +
            "#....#\n" +
            "######\n"
    System.setIn(ByteArrayInputStream(testInput.toByteArray()))

    data class Position(val x: Int, val y: Int, val count: Int)

    val reader = System.`in`.bufferedReader()
    val st = StringTokenizer(reader.readLine())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()
    val matrix = Array(n) { CharArray(m) }
    val fireMatrix = Array(n) { IntArray(m) { -1 } }

    val characterQueue: Queue<Position> = LinkedList()
    val fireQueue: Queue<Position> = LinkedList()
    for (i in 0 until n) {
        val str = reader.readLine()
        for (j in 0 until m) {
            matrix[i][j] = str[j]
            if (matrix[i][j] == 'J') {
                characterQueue.add(Position(i, j, 0))
            } else if (matrix[i][j] == 'F') {
                fireQueue.add(Position(i, j, 0))
            }
        }
    }

    val dx = intArrayOf(1, 0, -1, 0)
    val dy = intArrayOf(0, 1, 0, -1)

    while (fireQueue.isNotEmpty()) {
        val pos = fireQueue.poll()
        if (fireMatrix[pos.x][pos.y] != -1) continue
        fireMatrix[pos.x][pos.y] = pos.count

        for (i in 0 until 4) {
            val nextX = pos.x + dx[i]
            val nextY = pos.y + dy[i]

            if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= m) continue
            if (matrix[nextX][nextY] == '#') continue
            fireQueue.add(Position(nextX, nextY, pos.count + 1))
        }
    }

    while (characterQueue.isNotEmpty()) {
        print(matrix)
        println()


        val pos = characterQueue.poll()
        if (fireMatrix[pos.x][pos.y] != -1 && fireMatrix[pos.x][pos.y] <= pos.count) continue

        // 캐릭터
        for (i in 0 until 4) {
            val nextX = pos.x + dx[i]
            val nextY = pos.y + dy[i]

            if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= m) {
                println(pos.count + 1)
                return
            }
//            if (matrix[nextX][nextY] in charArrayOf('#', 'V')) continue
            if (matrix[nextX][nextY] == '#' || matrix[nextX][nextY] == 'V') continue
            matrix[nextX][nextY] = 'V'
            characterQueue.add(Position(nextX, nextY, pos.count + 1))
        }
    }

    println("IMPOSSIBLE")
    reader.close()
}

fun print(array: Array<CharArray>) {
    for (i in array) {
        println(i.contentToString())
    }
}

fun print(array: Array<IntArray>) {
    for (i in array) {
        println(i.contentToString())
    }
}