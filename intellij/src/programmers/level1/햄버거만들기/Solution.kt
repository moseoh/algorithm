package src.programmers.level1.햄버거만들기

fun main(args: Array<String>) {
    val ingredient = intArrayOf(2, 1, 1, 2, 3, 1, 2, 3, 1)
    println(Solution().solution(ingredient))
}

class Solution {
    fun solution(ingredient: IntArray): Int {
        val hamburger = "1231"
        var str = ingredient.joinToString("")
        var answer: Int = 0
        while (str.contains(hamburger)) {
            val index = str.indexOf(hamburger)
            val prefix = str.substring(0, index)
            val suffix = str.substring(index + hamburger.length)
            str = prefix + suffix
            if (index > 4) {
                str = str.substring(index - 4)
            }
            answer++
        }

        return answer
    }
}