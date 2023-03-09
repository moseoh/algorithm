package src.개념.sort

/**
 * 퀵 정렬
 *
 * 퀵 정렬은 n개의 데이터를 정렬할 때, 최악의 경우에는 O(n2)번의 비교를 수행하고, 평균적으로 O(n log n)번의 비교를 수행한다.
 */
class QuickSort : Sort() {
    override fun sort(array: IntArray) {
        this.sort(array, left = 0, array.size - 1)
    }

    private fun sort(array: IntArray, left: Int = 0, right: Int = array.size - 1) {
        // base condition
        if (left >= right) return

        val pivot = array[right]
        var sortedIndex = left
        for (i in left until right) {
            if (array[i] <= pivot) {
                swap(array, i, sortedIndex)
                sortedIndex++
            }
        }
        swap(array, sortedIndex, right)
        sort(array, left, sortedIndex - 1)
        sort(array, sortedIndex + 1, right)
    }
}

