package src.programmers.level1.삼총사


fun main(args: Array<String>) {
    val number = intArrayOf(-1, 1, -1, 1)
    println(Solution().solution(number))
}

class Solution {
    var count = 0
    fun solution(number: IntArray): Int {
//        combination(number.size, 3, number, IntArray(3) { -1 })
//        return count
        return combinations(number, 3).count { it.sum() == 0 }
    }

    // 조합: 순서 X, 중복 X
    private fun combination(length: Int, amount: Int, array: IntArray, combArray: IntArray) {
        if (amount <= 0) {
            if (combArray.sum() == 0) count++
            return
        } else if (length < amount) {
            return
        } else {
            combArray[amount - 1] = array[length - 1]
            combination(length - 1, amount - 1, array, combArray)
            combination(length - 1, amount, array, combArray)
        }
    }

    private fun combinations(nums: IntArray, k: Int): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        val current = mutableListOf<Int>()

        fun backtrack(start: Int) {
            if (current.size == k) {
                result.add(current.toList())
                return
            }

            for (i in start until nums.size) {
                current.add(nums[i])
                backtrack(i + 1)
                current.removeLast()
            }
        }

        backtrack(0)
        return result
    }
}