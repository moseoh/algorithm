package src.programmers.level3.부대복귀

import java.util.*

fun main() {
    val n1 = 3
    val roads1 = arrayOf(intArrayOf(1, 2), intArrayOf(2, 3))
    val sources1 = intArrayOf(2, 3)
    val destination1 = 1
    check(Solution().solution(n1, roads1, sources1, destination1).contentEquals(intArrayOf(1, 2))) { "오답" }

    val n2 = 5
    val roads2 = arrayOf(intArrayOf(1, 2), intArrayOf(1, 4), intArrayOf(2, 4), intArrayOf(2, 5), intArrayOf(4, 5))
    val sources2 = intArrayOf(1, 3, 5)
    val destination2 = 5
    check(Solution().solution(n2, roads2, sources2, destination2).contentEquals(intArrayOf(2, -1, 0))) { "오답" }
}

class Solution {
    fun solution(n: Int, roads: Array<IntArray>, sources: IntArray, destination: Int): IntArray {
        val map = hashMapOf<Int, MutableSet<Int>>()

        roads.forEach { (a, b) ->
            val linkedA = map.getOrDefault(a, hashSetOf())
            linkedA.add(b)
            map[a] = linkedA

            val linkedB = map.getOrDefault(b, hashSetOf())
            linkedB.add(a)
            map[b] = linkedB
        }

        val dp = IntArray(n + 1) { -1 }
        val isVisited = BooleanArray(n + 1)
        dp(destination, isVisited, dp, map)
        return sources.map { dp[it] }.toIntArray()
    }

    fun dp(destination: Int, isVisited: BooleanArray, dp: IntArray, map: Map<Int, MutableSet<Int>>) {
        val que = LinkedList<Pair<Int, Int>>()
        que.add(Pair(destination, 0))
        isVisited[destination] = true

        while (que.isNotEmpty()) {
            val pair = que.poll()
            val current = pair.first
            val count = pair.second
            dp[current] = count

            val hashSet = map[current] ?: return
            hashSet.forEach {
                if (!isVisited[it]) {
                    isVisited[it] = true
                    que.add(Pair(it, count + 1))
                }
            }
        }
    }
}