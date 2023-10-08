package src.baekjun.백트래킹

import java.util.*

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    var st = StringTokenizer(readLine())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()

    val numbers = IntArray(n)
    val isVisited = BooleanArray(n)
    val out = IntArray(m)
    val sb = StringBuilder()

    st = StringTokenizer(readLine())
    for (i in numbers.indices) {
        numbers[i] = st.nextToken().toInt()
    }
    Arrays.sort(numbers)

    fun backtracking(depth: Int = 0) {
        if (depth == m) {
            out.forEach { sb.append(it).append(" ") }
            sb.append("\n")
            return
        }

        var before = 0
        for (i in numbers.indices) {
            if (!isVisited[i] && before != numbers[i]) {
                isVisited[i] = true
                out[depth] = numbers[i]
                before = numbers[i]
                backtracking(depth + 1)
                isVisited[i] = false
            }
        }
    }

    backtracking()

    println(sb)
}