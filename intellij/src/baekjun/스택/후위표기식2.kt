package src.baekjun.스택

import java.util.*
import kotlin.collections.HashMap

fun main() {
    val num = readLine()!!.toInt()
    val postfix = readLine()!!.toCharArray()
    val map = HashMap<Char, Double>()
    for (i in 0 until num) {
        map['A'+i] = readLine()!!.toDouble()
    }

    val stack = Stack<Double>()
    postfix.forEach { ch ->
        if (ch in 'A'..'Z') {
            stack.push(map[ch])
        } else {
            val y = stack.pop()
            val x = stack.pop()
            when (ch) {
                '+' -> {
                    stack.push(x + y)
                }
                '-' -> {
                    stack.push(x - y)
                }
                '*' -> {
                    stack.push(x * y)
                }
                '/' -> {
                    stack.push(x / y)
                }
            }
        }
    }

    print(String.format("%.2f", stack.pop()))
}