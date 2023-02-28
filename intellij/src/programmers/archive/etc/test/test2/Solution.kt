package src.programmers.archive.etc.test.test2

fun main(args: Array<String>) {
//    val play_list = intArrayOf(2, 3, 1, 4)
    val play_list = intArrayOf(1, 2, 3, 4)
    val listen_time = 5
    println(Solution().solution(play_list, listen_time))
}

class Solution {
    fun solution(play_list: IntArray, listen_time: Int): Int {
        // play_list 배열의 index를 0부터 끝까지 getListenCountFromIndex에 넣어서 max값을 구함
        return play_list.mapIndexed { index, _ ->
            getListenCountFromIndex(play_list, listen_time, index)
        }.maxOf { it }
    }

    private fun getListenCountFromIndex(
        play_list: IntArray,
        listen_time: Int,
        index: Int,
    ): Int {
        var sum = 1
        var count = 1

        // while문 count가 play_list 배열 길이에 도달하면 종료
        while (count < play_list.size) {
            val nextIndex = if (index + 1 >= play_list.size) 0 else index + 1
            if (sum + play_list[nextIndex] < listen_time) {
                sum += play_list[nextIndex]
                count++
            } else if (sum + 1 <= listen_time) {
                count++
                break
            } else {
                break
            }
        }
        return count
    }
}