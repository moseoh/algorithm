package src.programmers.archive.toss._4

import java.util.Stack

fun main() {
    val maxSize = 3
    val actions = arrayOf("1", "2", "B", "F")
    println(Solution().solution(maxSize, actions).contentToString())
}

class Solution {
    private val recentList: Stack<Int> = Stack()
    private val backList: Stack<Int> = Stack()
    private val forwardList: Stack<Int> = Stack()
    private var maxSize = 0

    fun solution(maxSize: Int, actions: Array<String>): Array<String> {
        this.maxSize = maxSize
        actions.forEach { action(it) }
        return recentList.map { it.toString() }.toTypedArray().reversedArray()
    }

    private fun action(action: String) {
        when (action) {
            "B" -> back()
            "F" -> forward()
            else -> visit(action.toInt())
        }
        checkRecent()
    }

    private fun visit(num: Int) {
        if (recentList.isNotEmpty()) backList.add(recentList.peek())
        forwardList.clear()
        if (recentList.contains(num)) recentList.remove(num)
        recentList.push(num)
    }

    private fun forward() {
        if (forwardList.isEmpty()) return
        if (recentList.isNotEmpty()) backList.add(recentList.peek())

        val num = forwardList.pop()
        if (recentList.contains(num)) recentList.remove(num)
        recentList.push(num)
    }

    private fun back() {
        if (backList.isEmpty()) return
        if (recentList.isNotEmpty()) forwardList.add(recentList.peek())

        val num = backList.pop()
        if (recentList.contains(num)) recentList.remove(num)
        recentList.push(num)
    }

    private fun checkRecent() {
        if (recentList.size > maxSize) {
            recentList.removeFirst()
        }
    }
}