package src.programmers.sort

import java.lang.StringBuilder
import java.util.Collections


// 0 또는 양의 정수가 주어졌을 때, 정수를 이어 붙여 만들 수 있는 가장 큰 수를 알아내 주세요.
//
// 예를 들어, 주어진 정수가 [6, 10, 2]라면 [6102, 6210, 1062, 1026, 2610, 2106]를 만들 수 있고, 이중 가장 큰 수는 6210입니다.
//
// 0 또는 양의 정수가 담긴 배열 numbers 가 매개변수로 주어질 때, 순서를 재배치하여 만들 수 있는 가장 큰 수를 문자열로 바꾸어 return 하도록 solution 함수를 작성해주세요.
//
// 제한 사항
// numbers 의 길이는 1 이상 100,000 이하입니다.
// numbers 의 원소는 0 이상 1,000 이하입니다.
// 정답이 너무 클 수 있으니 문자열로 바꾸어 return 합니다.

// 첫 숫자를 따와서 큰 숫자부터
// 첫 숫자가 같다면 그 다음 숫자 비교

fun main() {
    val array1 = intArrayOf(0, 0, 0)
    val array2 = intArrayOf(3, 30, 34, 5, 9)
    val array3 = intArrayOf(3333, 3030, 3434, 5555, 9999)

    println(Solution().solution(array1))
    println(Solution().solution(array2))
    println(Solution().solution2(array1))
    println(Solution().solution2(array2))
}

private class Solution {
    fun solution(numbers: IntArray): String {
        val tempArray = IntArray(numbers.size)

        for (i in numbers.indices) {
            var str = ""
            for (j in 0..3) {
                str += numbers[i].toString()
            }
            tempArray[i] = str.substring(0, 4).toInt()
        }

        val sb = StringBuilder()
        for (i in 9999 downTo 0) {
            for (j in numbers.indices) {
                if (i == tempArray[j]) {
                    sb.append(numbers[j])
                }
            }
        }

        return if (sb[0] == '0') "0" else sb.toString()
    }

    fun solution2(numbers: IntArray): String {
        val list = numbers.toList()
        Collections.sort(list) { a: Int, b: Int ->
            val aStr = a.toString()
            val bStr = b.toString()
            -Integer.compare((aStr + bStr).toInt(), (bStr + aStr).toInt())
        }
        val sb = StringBuilder()
        for(i in list) sb.append(i)
        return if(sb[0] == '0') "0" else sb.toString()
    }
}
