package src.programmers.고득점kit.완전탐색.전력망을둘로나누기

import kotlin.math.abs

fun main() {
    val n1 = 9
    val wires1 = arrayOf(
        intArrayOf(1, 3),
        intArrayOf(2, 3),
        intArrayOf(3, 4),
        intArrayOf(4, 5),
        intArrayOf(4, 6),
        intArrayOf(4, 7),
        intArrayOf(7, 8),
        intArrayOf(7, 9)
    )
    check(Solution().solution(n1, wires1) == 3) { "오답" }

    val n2 = 4
    val wires2 = arrayOf(intArrayOf(1, 2), intArrayOf(2, 3), intArrayOf(3, 4))
    check(Solution().solution(n2, wires2) == 0) { "오답" }

    val n3 = 7
    val wires3 = arrayOf(
        intArrayOf(1, 2),
        intArrayOf(2, 7),
        intArrayOf(3, 7),
        intArrayOf(3, 4),
        intArrayOf(4, 5),
        intArrayOf(6, 7)
    )
    check(Solution().solution(n3, wires3) == 1) { "오답" }
}

class Solution {
    fun solution(n: Int, wires: Array<IntArray>): Int {
        var answer: Int = Int.MAX_VALUE
        wires.forEachIndexed { i, _ ->
            val map = hashMapOf<Int, MutableList<Int>>()
            wires.forEachIndexed { j, (parent, child) ->
                if (i != j) {
                    map[parent - 1] = (map[parent - 1] ?: mutableListOf()).apply { add(child - 1) }
                    map[child - 1] = (map[child - 1] ?: mutableListOf()).apply { add(parent - 1) }
                }
            }
            answer = answer.coerceAtMost(run(n, map))
        }
        return answer
    }

    private fun run(n: Int, map: Map<Int, List<Int>>): Int {
        val randomKey = map.keys.random()
        val isVisited = BooleanArray(n)
        visit(randomKey, map, isVisited)
        return abs(isVisited.count { it } - isVisited.count { !it })
    }

    private fun visit(key: Int, map: Map<Int, List<Int>>, isVisited: BooleanArray) {
        isVisited[key] = true
        (map[key] ?: return).onEach {
            if (!isVisited[it]) {
                visit(it, map, isVisited)
            }
        }
    }

}
