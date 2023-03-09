package src.개념.sort

abstract class Sort {
    open fun sort(array: IntArray) {}
    fun swap(arr: IntArray, i: Int, j: Int) {
        val tmp = arr[i]
        arr[i] = arr[j]
        arr[j] = tmp
    }
}