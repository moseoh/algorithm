package src.programmers.level1.대충만든자판


fun main(args: Array<String>) {
    val keymap = arrayOf("ABACD", "BCEFD")
    val target = arrayOf("XABCD", "AABB")
    println(Solution().solution(keymap, target).contentToString())
}

class Solution {
    fun solution(keymap: Array<String>, targets: Array<String>): IntArray {
        val map = hashMapOf<Char, Int>()

        keymap.forEach { str ->
            str.mapIndexed { index, c ->
                val stored = map.getOrDefault(c, Integer.MAX_VALUE)
                val pressed = index + 1
                if (pressed < stored) map[c] = pressed
            }
        }

        return targets.map sum@{ target ->
            target.map {
                map.getOrElse(it) { return@sum -1 }
            }.sum()
        }.toIntArray()
    }
}