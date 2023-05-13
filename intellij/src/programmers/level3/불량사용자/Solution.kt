package src.programmers.level3.불량사용자

fun main() {
    fun printResult(index: Int, result: Int, answer: Int) {
        val correct = result == answer
        val sb = StringBuilder()
        sb.append("\n\n테스트 케이스 ").append(index).append(": ")
        sb.append(if (correct) "정답" else "오답").append("\n")
        sb.append("\t- 실행 결과: \t").append(result).append("\n")
        sb.append("\t- 기댓값: \t").append(answer).append("\n")
        if (correct) println(sb) else throw RuntimeException(sb.toString())
    }

    val user_id1 = arrayOf("frodo", "fradi", "crodo", "abc123", "frodoc")
    val banned_id1 = arrayOf("fr*d*", "abc1**")
    val answer1 = 2
    val result1 = Solution().solution(user_id1, banned_id1)
    printResult(1, result1, answer1)

    val user_id2 = arrayOf("frodo", "fradi", "crodo", "abc123", "frodoc")
    val banned_id2 = arrayOf("*rodo", "*rodo", "******")
    val answer2 = 2
    val result2 = Solution().solution(user_id2, banned_id2)
    printResult(2, result2, answer2)

    val user_id3 = arrayOf("frodo", "fradi", "crodo", "abc123", "frodoc")
    val banned_id3 = arrayOf("fr*d*", "*rodo", "******", "******")
    val answer3 = 3
    val result3 = Solution().solution(user_id3, banned_id3)
    printResult(3, result3, answer3)
}

class Solution {
    fun solution(user_id: Array<String>, banned_id: Array<String>): Int {
        val list = banned_id
            .map { Regex(it.replace("*", ".{1}")) }
            .map { banned -> user_id.filter { banned.matches(it) } }

        return getCombinations(list).size
    }

    private fun getCombinations(
        lists: List<List<String>>,
        index: Int = 0,
        currentCombination: MutableList<String> = mutableListOf()
    ): List<List<String>> {
        if (index == lists.size) {
            currentCombination.sort()
            return listOf(currentCombination)
        }

        val combinations = mutableListOf<List<String>>()
        for (element in lists[index]) {
            if (element in currentCombination) continue
            currentCombination.add(element)
            val newCombinations = getCombinations(lists, index + 1, currentCombination.toMutableList())
            combinations += newCombinations
            currentCombination.remove(element)
        }

        return combinations.distinct()
    }
}