package src.programmers.level1.둘만의암호

fun main(args: Array<String>) {
    val s = "z"
    val skip = "abcdefghij"
    val index = 20
    println(Solution().solution2(s, skip, index))
}

class Solution {
    fun solution2(s: String, skip: String, index: Int): String {
        val alphabet = ('a'..'z').filter { it !in skip.toCharArray() }
        return s.map {
            alphabet[(alphabet.indexOf(it) + index) % alphabet.size]
        }.joinToString("")
    }

    fun solution(s: String, skip: String, index: Int): String =
        s.map {
            convertChar(it, skip.toCharArray(), index)
        }.toCharArray().joinToString("")


    private tailrec fun convertChar(char: Char, skipChars: CharArray, index: Int): Char {
        if (index == 0) return char
        val nextChar = if (char + 1 > 'z') 'a' else char + 1
        return if (skipChars.contains(nextChar)) convertChar(nextChar, skipChars, index)
        else convertChar(nextChar, skipChars, index - 1)
    }
}
