package src.programmers.level3.보석_쇼핑

fun main() {
    fun printResult(index: Int, result: IntArray, answer: IntArray) {
        val correct = result.contentEquals(answer)
        val sb = StringBuilder()
        sb.append("\n\n테스트 케이스 ").append(index).append(": ")
        sb.append(if (correct) "정답" else "오답").append("\n")
        sb.append("\t- 실행 결과: \t").append(result.contentToString()).append("\n")
        sb.append("\t- 기댓값: \t").append(answer.contentToString()).append("\n")
        if (correct) println(sb) else throw RuntimeException(sb.toString())
    }

    val gems1 = arrayOf("DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA")
    val answer1 = intArrayOf(3, 7)
    val result1 = Solution().solution(gems1)
    printResult(1, result1, answer1)

    val gems2 = arrayOf("AA", "AB", "AC", "AA", "AC")
    val answer2 = intArrayOf(1, 3)
    val result2 = Solution().solution(gems2)
    printResult(2, result2, answer2)

    val gems3 = arrayOf("XYZ", "XYZ", "XYZ")
    val answer3 = intArrayOf(1, 1)
    val result3 = Solution().solution(gems3)
    printResult(3, result3, answer3)

    val gems4 = arrayOf("ZZZ", "YYY", "NNNN", "YYY", "BBB")
    val answer4 = intArrayOf(1, 5)
    val result4 = Solution().solution(gems4)
    printResult(4, result4, answer4)

    val gems5 = arrayOf("C", "A", "A", "A", "A", "B", "A", "B", "B", "C")
    val answer5 = intArrayOf(7, 10)
    val result5 = Solution().solution(gems5)
    printResult(5, result5, answer5)

    val gems6 = arrayOf("C", "A", "A", "A", "A", "B", "A", "B", "C", "A", "B", "B", "C")
    val answer6 = intArrayOf(7, 9)
    val result6 = Solution().solution(gems6)
    printResult(6, result6, answer6)
}

class Solution {
    fun solution(gems: Array<String>): IntArray {
        return intArrayOf()
    }

    // 시간 초과
    fun solution2(gems: Array<String>): IntArray {
        val allGemsSize = gems.toSet().size
        for (length in gems.indices) {
            for (index in 0 until gems.size - length) {
                if (gems.copyOfRange(index, index + length + 1).toSet().size == allGemsSize)
                    return intArrayOf(index + 1, index + length + 1)
            }
        }

        return intArrayOf(-1, -1)
    }

    // 정확도 실패
    fun solution3(gems: Array<String>): IntArray {
        val gemsList = gems.toMutableList()
        val allGemsSize = gems.toSet().size
        var startIndex = 1
        var endIndex = gems.size

        while (true) {
            if (gemsList.subList(0, gemsList.size - 1).toSet().size == allGemsSize) {
                gemsList.removeLastOrNull()
                endIndex--
            } else {
                break
            }
        }

        while (true) {
            if (gemsList.subList(1, gemsList.size).toSet().size == allGemsSize) {
                gemsList.removeFirstOrNull()
                startIndex++
            } else {
                break
            }
        }

        return intArrayOf(startIndex, endIndex)
    }

    // 시간 초과 (2번보단 빠름)
    fun solution4(gems: Array<String>): IntArray {
        fun getLines(gems: Array<String>, startIndex: Int, allGemsSize: Int): Pair<Int, Int> {
            val set = mutableSetOf<String>()
            for (i in startIndex until gems.size) {
                set.add(gems[i])
                if (set.size == allGemsSize) return Pair(startIndex + 1, i + 1)
            }
            return Pair(1, gems.size)
        }

        val allGems = gems.toSet()
        val answers = mutableListOf<Pair<Int, Int>>()
        for (i in gems.indices) {
            answers.add(getLines(gems, i, allGems.size))
        }

        return answers.minByOrNull { it.second - it.first }!!.toList().toIntArray()
    }
}