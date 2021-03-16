package src.baekjun.스택

import java.util.*
import kotlin.collections.HashMap

fun main() {
    val infix = readLine()!!.toCharArray()
    print(replacePostfix(infix))
}

fun replacePostfix(infix: CharArray): StringBuilder {
    val postfix = StringBuilder()
    val stack = Stack<Char>()
    val isp = HashMap<Char, Int>()
    isp.apply {
        put('*', 1)
        put('/', 1)
        put('+', 2)
        put('-', 2)
        put('(', 3)
    }

    infix.forEach { ch ->
        if (ch in 'A'..'Z') {
            postfix.append(ch)
            return@forEach
        }
        if (ch == '(') {
            stack.push(ch)
            return@forEach
        }
        if (ch == ')') {
            while (stack.peek() != '(') {
                postfix.append(stack.pop())
            }
            stack.pop()
            return@forEach
        }
        while (true) {
            if (stack.isEmpty()) break
            if (isp[ch]!! < isp[stack.peek()]!!) break
            postfix.append(stack.pop())
        }
        stack.push(ch)
    }
    while (!stack.isEmpty()) postfix.append(stack.pop())
    return postfix
}