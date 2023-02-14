package src.programmers.level0.다음에올숫자

fun main(args: Array<String>) {
    val common = intArrayOf(1, 2, 3, 4)
    println(Solution().solution(common))
}


class Solution {
    fun solution(common: IntArray): Int {
        val lastIndex = common.lastIndex
        return if (isAS(common)) common.last() * 2 - common[lastIndex - 1]
        else common.last() * common.last() / common[lastIndex - 1]
    }

    // 등차 수열 arithmetic sequence or arithmetic progression AP
    // 등비 수열 geometric sequence
    fun isAS(common: IntArray): Boolean =
        common[1] - common[0] == common[2] - common[1]

}