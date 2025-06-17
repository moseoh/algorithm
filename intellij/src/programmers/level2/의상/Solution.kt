package src.programmers.level2.의상

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

    val clothes1 = arrayOf(
        arrayOf("yellow_hat", "headgear"),
        arrayOf("blue_sunglasses", "eyewear"),
        arrayOf("green_turban", "headgear")
    )
    val answer1 = 5
    val result1 = Solution().solution(clothes1)
    printResult(1, result1, answer1)

    val clothes2 =
        arrayOf(arrayOf("crow_mask", "face"), arrayOf("blue_sunglasses", "face"), arrayOf("smoky_makeup", "face"))
    val answer2 = 3
    val result2 = Solution().solution(clothes2)
    printResult(2, result2, answer2)
}

class Solution {
    fun solution(clothes: Array<Array<String>>): Int {
        val map = mutableMapOf<String, Int>()
        for (clothe in clothes) {
            val (_, category) = clothe
            map[category] = map.getOrDefault(category, 1) + 1
        }

        return map.values.fold(1) { acc, i -> acc * i } - 1
    }
}