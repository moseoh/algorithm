package src.programmers.temp.행렬의덧셈

fun main(args: Array<String>) {
    val arr1 = arrayOf(intArrayOf(1, 2), intArrayOf(2, 3))
    val arr2 = arrayOf(intArrayOf(3, 4), intArrayOf(5, 6))

//    val arr1 = arrayOf(intArrayOf(1), intArrayOf(2))
//    val arr2 = arrayOf(intArrayOf(3), intArrayOf(4))
    println(Solution().solution(arr1, arr2).contentToString())
}


class Solution {
    fun solution(arr1: Array<IntArray>, arr2: Array<IntArray>): Array<IntArray> = arr1.mapIndexed { x, arr ->
        arr.mapIndexed { y, it ->
            arr2[x][y] + it
        }.toIntArray()
    }.toTypedArray()
}