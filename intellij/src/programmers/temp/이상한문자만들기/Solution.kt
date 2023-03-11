package src.programmers.temp.이상한문자만들기

fun main(args: Array<String>) {
    val s = "try hello world"
    println(Solution().solution(s))
}


class Solution {
    fun solution(s: String): String {
        s.split(" ").map {
            println(convert(it))
        }
        var answer = ""
        return answer
    }

    private fun convert(word: String): String {
        return word.mapIndexed { index, c ->
            if (index % 2 != 0) c.toLowerCase()
            else c.toUpperCase()
        }.toString()
    }
}