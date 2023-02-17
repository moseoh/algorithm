package src.programmers.level0.잘라서배열로저장하기

fun main(args: Array<String>) {
    val my_str = "abc1Addfggg4556b"
    val n = 6
    println(Solution().solution(my_str, n).contentToString())
}

class Solution {
    fun solution(my_str: String, n: Int): Array<String> {
//        val answer = mutableListOf<String>()
//        for (i in my_str.indices step n) {
//            answer.add(my_str.substring(i, Integer.min(i + n, my_str.length)))
//        }
//        return answer.toTypedArray()
        return my_str.chunked(n).toTypedArray()
    }
}