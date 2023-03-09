package src.개념.sort

import kotlin.system.measureTimeMillis
import kotlin.time.Duration
import kotlin.time.ExperimentalTime
import kotlin.time.measureTimedValue

@OptIn(ExperimentalTime::class)
fun main() {
    val selectionSort = SelectionSort()
    val insertionSort = InsertionSort()
    val quickSort = QuickSort()
    val elapsed = mutableListOf<Pair<String, Double>>()
    elapsed.add(Pair("Thread Test", measureTimedValue {
        Thread.sleep(1000)
    }.duration.inMilliseconds))

    (0..1).forEach {
        elapsed.add(Pair("Default", measureTimedValue {
            repeat((0..1000).count()) {
                val array = intArrayOf(6, 2, 1, 8, 9, 0, 10, 89, 22, 156, 221, 556, 513, 12, 8584, 24, 35, 1, 2, 1, 2)
                array.sort()
            }
        }.duration.inMilliseconds))
    }

    elapsed.add(Pair(selectionSort.javaClass.simpleName, sortingWithCheckTime(selectionSort)))
    elapsed.add(Pair(insertionSort.javaClass.simpleName, sortingWithCheckTime(insertionSort)))
    elapsed.add(Pair(quickSort.javaClass.simpleName, sortingWithCheckTime(quickSort)))


    println()
    elapsed.forEach { printResult(it) }
}

@OptIn(ExperimentalTime::class)
private fun sortingWithCheckTime(sort: Sort): Double {
    println()
    println()
    println("=================================")
    println(sort.javaClass.simpleName)
    println("=================================")
    var array = intArrayOf(6, 2, 1, 8, 9, 0, 10, 89, 22, 156, 221, 556, 513, 12, 8584, 24, 35, 1, 2, 1, 2)
    println(array.contentToString())
    sort.sort(array)
    println(array.contentToString())
    return measureTimedValue {
        repeat((0..1000).count()) {
            array = intArrayOf(6, 2, 1, 8, 9, 0, 10, 89, 22, 156, 221, 556, 513, 12, 8584, 24, 35, 1, 2, 1, 2)
            sort.sort(array)
        }
    }.duration.inMilliseconds
}

private fun printResult(pair: Pair<String, Double>) {
    println("${pair.first}: ${String.format("%.3f", pair.second)}ms")
}