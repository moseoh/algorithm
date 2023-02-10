package src.programmers.archive.완전탐색

//한자리 숫자가 적힌 종이 조각이 흩어져있습니다. 흩어진 종이 조각을 붙여 소수를 몇 개 만들 수 있는지 알아내려 합니다.
//
//각 종이 조각에 적힌 숫자가 적힌 문자열 numbers 가 주어졌을 때, 종이 조각으로 만들 수 있는 소수가 몇 개인지 return 하도록 solution 함수를 완성해주세요.
//
//numbers 는 길이 1 이상 7 이하인 문자열입니다.
//numbers 는 0~9까지 숫자만으로 이루어져 있습니다.
//013은 0, 1, 3 숫자가 적힌 종이 조각이 흩어져있다는 의미입니다.

//입출력 예
//numbers	return
//17	3
//011	2
//입출력 예 설명
//예제 #1
//[1, 7]으로는 소수 [7, 17, 71]를 만들 수 있습니다.
//
//예제 #2
//[0, 1, 1]으로는 소수 [11, 101]를 만들 수 있습니다.
//
//11과 011은 같은 숫자로 취급합니다.

fun main() {
    val number1 = "17"
    val number2 = "011"

    Solution2().solution(number1)
}

class Solution2 {
    fun solution(numbers: String): Int {

        val numberArray = numbers.toCharArray()
        var number = ""

        numberArray.sortDescending()
        numberArray.forEach { number += it }
        numberArray.forEach { print("$it ") }
        println()

        val primeList = primeNumber(number.toInt())
        primeList.forEach { print("$it ") }

        return 0
    }

    private fun primeNumber(number: Int): ArrayList<Int> {
        val primeArray = BooleanArray(number)

        for (i in 2 until number) {
            primeArray[i] = true
        }

        var k = 2
        while (k * k < number) {
            var j = k * k
            while (j < number) {
                primeArray[j] = false //2를 제외한 2의 배수 false
                j += k
            }
            k += 1
        }

        val list = ArrayList<Int>()
        for (i in primeArray.indices) {
            if (primeArray[i]) list.add(i)
        }
        return list
    }
}