package src.baekjun.백트래킹

import java.util.*
import kotlin.math.max

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()

    val strength = IntArray(n)
    val weight = IntArray(n)

    for (i in 0 until n) {
        val st = StringTokenizer(readLine())
        strength[i] = st.nextToken().toInt()
        weight[i] = st.nextToken().toInt()
    }

    var answer = 0
    fun crashing(index: Int = 0, count: Int = 0) {
        if (n - count <= 1 || index == n) {
            answer = max(answer, count)
            return
        }

        if (strength[index] <= 0) {
            crashing(index + 1, count)
            return
        }

        for (i in 0 until n) {
            if (i == index) continue

            if (strength[i] > 0) {
                strength[index] -= weight[i]
                strength[i] -= weight[index]

                if (strength[index] <= 0 && strength[i] > 0) { // 왼 손에 든것만 깨진 경우
                    crashing(index + 1, count + 1)
                } else if (strength[i] <= 0 && strength[index] > 0) { // 오른 손에 든게 깨진 경우
                    crashing(index + 1, count + 1)
                } else if (strength[i] <= 0 && strength[index] <= 0) { // 둘다 깨진 경우
                    crashing(index + 1, count + 2)
                } else { // 둘다 안깨진 겨우
                    crashing(index + 1, count)
                }

                strength[index] += weight[i]
                strength[i] += weight[index]
            }
        }
    }

    crashing()

    println(answer)
}