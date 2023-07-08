package src.programmers.archive.toss._2

fun main() {
    val relationships =
        arrayOf(
            intArrayOf(1, 2),
            intArrayOf(2, 3),
            intArrayOf(2, 6),
            intArrayOf(3, 4),
            intArrayOf(4, 5),
        )
    val target = 1
    val limit = 2
    println(Solution().solution(relationships, target, limit))
}

class Solution {
    fun solution(relationships: Array<IntArray>, target: Int, limit: Int): Int {
        val relationMap = getRelationMap(relationships)
        val oldFriendCount = getOldFriendCount(relationMap, target)
        val newFriendCount =
            getNewFriendCount(relationMap.toMutableMap(), target, limit, relationMap[target]!!) - oldFriendCount
        println("$oldFriendCount $newFriendCount")
        return oldFriendCount * 5 + newFriendCount * 10 + (newFriendCount)
    }

    private fun getOldFriendCount(relationMap: Map<Int, MutableSet<Int>>, target: Int): Int {
        return relationMap[target]!!.size
    }

    private fun getNewFriendCount(
        relationMap: Map<Int, MutableSet<Int>>,
        target: Int,
        limit: Int,
        friends: Set<Int>,
        depth: Int = 1
    ): Int {
        if (limit == depth) return friends.size
        val newFriends = friends.toMutableSet()

        for (friend in friends) {
            relationMap[friend]?.let { relations ->
                relations.forEach { if (!friends.contains(it) && target != it) newFriends.add(it) }
            }
        }

        return getNewFriendCount(relationMap, target, limit, newFriends, depth + 1)
    }

    private fun getRelationMap(relationships: Array<IntArray>): Map<Int, MutableSet<Int>> {
        val relationMap = mutableMapOf<Int, MutableSet<Int>>()

        relationships.forEach {
            val set1 = relationMap.getOrDefault(it[0], mutableSetOf())
            set1.add(it[1])
            relationMap[it[0]] = set1

            val set2 = relationMap.getOrDefault(it[1], mutableSetOf())
            set2.add(it[0])
            relationMap[it[1]] = set2
        }

        return relationMap
    }
}