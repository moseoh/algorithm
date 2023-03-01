package src.programmers.level2.호텔대실

import java.time.LocalTime
import java.time.format.DateTimeFormatter

fun main(args: Array<String>) {
    val book_time =
        arrayOf(
            arrayOf("15:00", "17:00"),
            arrayOf("17:10", "23:59")
        )
    println(Solution().solution(book_time))
}

class Solution {
    fun solution(book_time: Array<Array<String>>): Int {
        val formatter = DateTimeFormatter.ofPattern("HH:mm")
        val list = mutableListOf<LocalTime>()
        book_time.sortBy { LocalTime.parse(it[0]).hour * 60 + LocalTime.parse(it[0]).minute }

        for (i in book_time.indices) {
            val startTime = LocalTime.parse(book_time[i][0], formatter)
            var endTime = LocalTime.parse(book_time[i][1], formatter).plusMinutes(10)
            if (endTime.isBefore(LocalTime.parse("00:10"))) endTime = LocalTime.parse("23:59", formatter)

            val index = list.indexOfFirst { !startTime.isBefore(it) }
            if (index != -1) list.removeAt(index)
            list.add(endTime)
        }
        return list.size
    }
}