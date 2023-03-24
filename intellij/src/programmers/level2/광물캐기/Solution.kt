package src.programmers.level2.광물캐기

fun main() {
    val picks1 = intArrayOf(1, 3, 2)
    val minerals1 = arrayOf("diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone")
    check(Solution().solution(picks1, minerals1) == 12) { "오답" }

    val picks2 = intArrayOf(0, 1, 1)
    val minerals2 = arrayOf(
        "diamond",
        "diamond",
        "diamond",
        "diamond",
        "diamond",
        "iron",
        "iron",
        "iron",
        "iron",
        "iron",
        "diamond"
    )
    check(Solution().solution(picks2, minerals2) == 50) { "오답" }
}

class Solution {
    fun solution(picks: IntArray, minerals: Array<String>): Int {
        val list = mutableListOf<Pair<Int, Int>>()
        for (i in 0 until (picks.sum() * 5).coerceAtMost(minerals.size) step 5) {
            var sum = 0
            for (j in i until (i + 5).coerceAtMost(minerals.size)) {
                sum += getValue(minerals[j])
            }
            list.add(Pair(sum, i))
        }
        println(list)

        list.sortByDescending { it.first }

        return list.sumOf { getStamina(it.second, picks, minerals) }
    }

    private fun getStamina(from: Int, picks: IntArray, minerals: Array<String>): Int {
        val pick = getPick(picks)
        if (pick == -1) return 0

        val to = (from + 5).coerceAtMost(minerals.size)

        var staminas = 0
        for (i in from until to) {
            val stamina = getValue(minerals[i]) / pick
            staminas += if (stamina == 0) 1 else stamina
        }
        return staminas
    }

    private fun getPick(picks: IntArray): Int {
        if (picks[0] > 0) {
            picks[0]--
            return 25
        } else if (picks[1] > 0) {
            picks[1]--
            return 5
        } else if (picks[2] > 0) {
            picks[2]--
            return 1
        }

        return -1
    }

    private fun getValue(mineral: String): Int {
        return when (mineral) {
            "diamond" -> 25
            "iron" -> 5
            "stone" -> 1
            else -> throw RuntimeException()
        }
    }
}