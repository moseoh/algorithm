package src.programmers.etc.숨어있는숫자의덧셈1

fun main(args: Array<String>) {
    val my_string = "aAb1B2cC34oOp"
    println(Solution().solution(my_string))
}

class Solution {
    fun solution(my_string: String): Int =
        my_string
            .filter(Char::isDigit)
            .sumOf(Character::getNumericValue)
}