package src.baekjun.그리디

import java.io.ByteArrayInputStream
import java.util.*

fun main(args: Array<String>) {
    val testInput = "6\n" +
            "1 3\n" +
            "2 5\n" +
            "7 8\n" +
            "4 12\n" +
            "9 10\n" +
            "7 11"
    System.setIn(ByteArrayInputStream(testInput.toByteArray()))

    data class Course(val start: Int, val end: Int)

    val reader = System.`in`.bufferedReader()
    val n = reader.readLine().toInt()
    val arr = Array(n) {
        val st = StringTokenizer(reader.readLine())
        val s = st.nextToken().toInt()
        val t = st.nextToken().toInt()
        Course(s, t)
    }
    arr.sortBy { it.start }


    val courses = PriorityQueue<Course> { a, b -> a.end - b.end }
    courses.add(arr[0])
    for (i in 1 until n) {
        if (courses.peek().end <= arr[i].start) {
            courses.add(Course(courses.poll().start, arr[i].end))
        } else {
            courses.add(arr[i])
        }
    }

    println(courses.size)

    reader.close()
}