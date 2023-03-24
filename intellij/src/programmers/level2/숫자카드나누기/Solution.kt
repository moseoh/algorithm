package src.programmers.level2.숫자카드나누기

fun main() {
    val arrayA1 = intArrayOf(10, 17)
    val arrayB1 = intArrayOf(5, 20)
    check(Solution().solution(arrayA1, arrayB1) == 0) { "오답" }

    val arrayA2 = intArrayOf(10, 20)
    val arrayB2 = intArrayOf(5, 17)
    check(Solution().solution(arrayA2, arrayB2) == 10) { "오답" }

    val arrayA3 = intArrayOf(14, 35, 119)
    val arrayB3 = intArrayOf(18, 30, 102)
    check(Solution().solution(arrayA3, arrayB3) == 7) { "오답" }
}


class Solution {
    fun solution(arrayA: IntArray, arrayB: IntArray): Int {
        return getAnswer(getNums(arrayA), arrayB).coerceAtLeast(getAnswer(getNums(arrayB), arrayA))
    }

    private fun getNums(array: IntArray): IntArray {
        fun isNum(num: Int, array: IntArray): Boolean {
            for (i in array.indices) {
                if (array[i] % num != 0) return false
            }
            return true
        }

        val num = array.minOrNull()!!
        val list = mutableListOf<Int>()
        for (i in num downTo 1) {
            if (num % i == 0 && isNum(i, array)) list.add(i)
        }
        return list.toIntArray()
    }

    private fun getAnswer(nums: IntArray, array: IntArray): Int {
        fun isAnswer(num: Int, array: IntArray): Boolean {
            for (i in array.indices) {
                if (array[i] % num == 0) return false
            }
            return true
        }
        for (i in nums.indices) {
            if (isAnswer(nums[i], array)) return nums[i]
        }
        return 0
    }
}
