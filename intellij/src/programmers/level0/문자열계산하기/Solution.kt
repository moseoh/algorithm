package src.programmers.level0.문자열계산하기

fun main(args: Array<String>) {
    val my_string = "3 + 4 - 12"
    println(Solution().solution(my_string))
}

class Solution {
    fun solution(my_string: String): Int = calculate(my_string).toInt()

    fun solution2(my_string: String): Int = my_string
        .replace("[-] ".toRegex(), "-")
        .replace("[+] ".toRegex(), "")
        .split(" ")
        .sumOf { it.toInt() }

    private fun calculate(str: String): String {
        var temp = str
        return str.split(" ").let { (n1, op, n2) ->
            temp = operationFromStr(op).invoke(n1, n2).toString() + temp.substring("$n1 $op $n2".length)
            if (temp.contains(" [+-] ".toRegex())) {
                println("return $temp")
                return calculate(temp)
            }
            temp
        }
    }


    private fun operationFromStr(op: String): (String, String) -> Int {
        return when (op) {
            "+" -> { n1, n2 -> n1.toInt() + n2.toInt() }
            "-" -> { n1, n2 -> n1.toInt() - n2.toInt() }
            else -> throw UnsupportedOperationException()
        }
    }
}