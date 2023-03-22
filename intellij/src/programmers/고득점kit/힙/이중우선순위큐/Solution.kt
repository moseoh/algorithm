package src.programmers.고득점kit.힙.이중우선순위큐

fun main() {
    val operations1 = arrayOf("I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1")
    check(Solution().solution(operations1).contentEquals(intArrayOf(0, 0))) { "오답" }

    val operations2 = arrayOf("I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333")
    check(Solution().solution(operations2).contentEquals(intArrayOf(333, -45))) { "오답" }

    val operations3 = arrayOf(
        "I 1",
        "I 2",
        "I 3",
        "I 4",
        "I 5",
        "I 6",
        "I 7",
        "I 8",
        "I 9",
        "I 10",
        "D 1",
        "D -1",
        "D 1",
        "D -1",
        "I 1",
        "I 2",
        "I 3",
        "I 4",
        "I 5",
        "I 6",
        "I 7",
        "I 8",
        "I 9",
        "I 10",
        "D 1",
        "D -1",
        "D 1",
        "D -1"
    )
    check(Solution().solution(operations3).contentEquals(intArrayOf(8, 3))) { "오답" }
}

class Solution {
    fun solution(operations: Array<String>): IntArray {
        val list = mutableListOf<Int>()
        operations.map { it.split(" ") }.forEach { (command, num) ->
            if (command == "I") {
                list.add(num.toInt())
            } else {
                if (list.isNotEmpty()) {
                    if (num.toInt() == 1) list.remove(list.maxOrNull())
                    else list.remove(list.minOrNull())
                }
            }
        }
        return intArrayOf(list.maxOrNull() ?: 0, list.minOrNull() ?: 0)
    }
}
